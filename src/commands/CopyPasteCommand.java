package commands;

import model.AppModel;

import javax.swing.*;

public class CopyPasteCommand implements Command {
    private final AppModel appModel;

    public CopyPasteCommand(AppModel appModel) {
        this.appModel = appModel;
    }

    @Override
    public void execute() {
        if (appModel.getOutputPath().getPathName().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please provide an output path.");
        } else {
            try {
                appModel.copyPaste(true);
                JOptionPane.showMessageDialog(null, "Sectors copied successfully!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Unexpected error.");
            }
        }
    }
}
