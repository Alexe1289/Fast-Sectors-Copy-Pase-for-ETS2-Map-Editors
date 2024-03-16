package view.frame;

import buttons.listeners.ButtonListener;
import commands.Command;
import commands.CopyPasteCommand;
import commands.NewActionCommand;
import buttons.ActionButton;
import buttons.Button;
import data.PathIO;
import model.AppModel;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;

public class MainFrame extends JFrame {

    private final AppModel presetModel1;
    private final AppModel presetModel2;

    private final Button preset1;
    private final Button preset2;
    private final ActionButton newAction;

    public MainFrame() {

        JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));

        presetModel1 = readPreset("1");
        presetModel2 = readPreset("2");

        preset1 = new Button(presetModel1);
        preset2 = new Button(presetModel2);

        preset1.addActionListener(new ButtonListener(new CopyPasteCommand(presetModel1)));
        preset2.addActionListener(new ButtonListener(new CopyPasteCommand(presetModel2)));

        newAction = new ActionButton();
        centerPanel.add(preset1);
        centerPanel.add(preset2);
        centerPanel.add(newAction);

        this.add(centerPanel, BorderLayout.CENTER);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 400);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    public void setNewAction(JFrame newFrame) {
        newAction.addActionListener(new ButtonListener(new NewActionCommand(newFrame, this)));
    }

    private AppModel readPreset(String presetIdx) {
        String inputPath;
        String outputPath;
        String presetName;
        String sectorLine;
        DefaultListModel<String> sectorsList = new DefaultListModel<>();

        String filePath = "preset" + presetIdx + ".txt";
        try {
            BufferedReader reader =  new BufferedReader(new FileReader(filePath));
            presetName = removePrefix(reader.readLine());
            inputPath = removePrefix(reader.readLine());
            outputPath = removePrefix(reader.readLine());
            sectorLine = removePrefix(reader.readLine());
            String[] sectors = sectorLine.split(" ");
            for (String sector : sectors) {
                sectorsList.addElement(sector);
            }
            return new AppModel(new PathIO(inputPath), new PathIO(outputPath), presetName,
                    sectorsList);
        } catch (Exception e) {
            return null;
        }
    }

    private String removePrefix(String line) {
        int index = line.indexOf(' ');
        if (index != -1) return line.substring(index + 1);
        else return line;
    }
}
