package commands;

import data.PathIO;
import model.AppModel;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class BrowseCommand implements Command {
    private final JTextField textField;
    private final PathIO pathToChange;

    public BrowseCommand(JTextField textField, PathIO pathToChange) {
        this.textField = textField;
        this.pathToChange = pathToChange;
    }
    @Override
    public void execute() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int result = fileChooser.showDialog(null, "Select");

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            pathToChange.setPathName(selectedFile.getAbsolutePath());
            updateTextFieldAppearance();
        }
    }

    private void updateTextFieldAppearance() {
        if (pathToChange.getPathName() == null) {
            textField.setBackground(Color.WHITE);
        } else {
            textField.setText(pathToChange.getPathName());
            textField.setEditable(false);
            textField.setBackground(Color.GREEN);
        }
    }
}
