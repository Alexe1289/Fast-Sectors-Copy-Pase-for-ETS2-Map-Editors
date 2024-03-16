package view.frame;

import buttons.listeners.ButtonListener;
import buttons.listeners.CloseFrameListener;
import buttons.listeners.TextFieldListener;
import commands.*;
import model.AppModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class NewActionFrame extends JFrame {

    private CloseFrameListener closeFrameListener;

    private String inputPath;
    private String outputPath;
    private String sectorName;
    private final AppModel appModel;

    private JPanel mainPanel;
    private JButton browseInpButton;
    private JTextField inputField;
    private JLabel pathName;
    private JFormattedTextField formattedTextField1;
    private JList<String> sectorList;
    private JScrollPane scrollPanel;
    private JPanel input;
    private JPanel output;
    private JButton removeSectors;
    private JButton notImplemented;
    private JButton saveToPresetButton;
    private JButton copyPasteButton;
    private JTextField outputField;
    private JButton browseOutButton;
    private JButton addSectorButton;
    private JLabel sectorToAdd;
    private JCheckBox replaceIfExistsCheckBox;

    public NewActionFrame() {

        appModel = new AppModel();

        getContentPane().add(mainPanel);

        setButtons();
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only the new view.frame
        setLocationRelativeTo(null);
        setVisible(false);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                // Notify the listener when the frame is closed
                if (closeFrameListener != null) {
                    closeFrameListener.onFrameClosed();
                }
            }
        });
    }

    private void setButtons() {
        Command inpCommand = new BrowseCommand(inputField, appModel.getInputPath());
        Command outCommand = new BrowseCommand(outputField, appModel.getOutputPath());
        Command addSecCommand = new AddSectorCommand(appModel, formattedTextField1, inputField, sectorList);
        Command copyPasteCommand = new CopyPasteCommand(appModel);
        Command newPresetCommand = new NewPresetCommand(sectorList, appModel);
        saveToPresetButton.addActionListener(new ButtonListener(newPresetCommand));
        browseInpButton.addActionListener(new ButtonListener(inpCommand));
        browseOutButton.addActionListener(new ButtonListener(outCommand));
        addSectorButton.addActionListener(new ButtonListener(addSecCommand));
        formattedTextField1.addActionListener(new ButtonListener(addSecCommand));
        copyPasteButton.addActionListener(new ButtonListener(copyPasteCommand));
    }

    public String getInputPath() {
        return inputPath;
    }

    public void setInputPath(String inputPath) {
        this.inputPath = inputPath;
    }

    public String getOutputPath() {
        return outputPath;
    }

    public void setOutputPath(String outputPath) {
        this.outputPath = outputPath;
    }

    public AppModel getAppModel() {
        return appModel;
    }

    public void setCloseFrameListener(CloseFrameListener closeFrameListener) {
        this.closeFrameListener = closeFrameListener;
    }

    private void createUIComponents() {
    }
}
