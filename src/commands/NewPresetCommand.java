package commands;

import model.AppModel;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class NewPresetCommand implements Command {

    private final JList<String> sectorList;
    private final AppModel appModel;

    public NewPresetCommand(JList<String> sectorList, AppModel appModel) {
        this.appModel = appModel;
        this.sectorList = sectorList;
    }

    @Override
    public void execute() {
        String userInput = JOptionPane.showInputDialog(null, "Enter the preset name:");
        String presetIdx = JOptionPane.showInputDialog(null, "Choose slot for preset [1-2]");
        if (userInput != null) {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("preset" + presetIdx+ ".txt"));
                writer.write("Name " + userInput + "\n");
                writer.write("Input " + appModel.getInputPath().getPathName() + "\n");
                writer.write("Output " + appModel.getOutputPath().getPathName() + "\n");
                writer.write("Sectors");
                ListModel<String> sectors = sectorList.getModel();
                for (int i = 0; i < sectors.getSize(); i++) {
                    writer.write(" " + sectors.getElementAt(i));
                }
                writer.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error saving preset!");
            }
        }
    }
}
