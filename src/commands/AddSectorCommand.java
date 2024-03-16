package commands;

import exceptions.FileNotFoundException;
import exceptions.InvalidInputPathException;
import exceptions.InvalidPatternException;
import model.AppModel;

import javax.swing.*;

public class AddSectorCommand implements Command {
    private final AppModel appModel;
    private final JFormattedTextField textField;
    private final JTextField inputField;
    private final JList<String> uiList;
    private final DefaultListModel<String> sectorList;

    public AddSectorCommand(AppModel appModel, JFormattedTextField textField, JTextField inputField,
                            JList<String> uiList) {
        this.appModel = appModel;
        this.textField = textField;
        this.inputField = inputField;
        this.uiList = uiList;
        this.sectorList = new DefaultListModel<>();
    }

    @Override
    public void execute() {
        if (textField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter a sector name.");
        } else {
            try {
                DefaultListModel<String> sectors = appModel.processSector(textField.getText(), inputField);
                for (int i = 0; i < sectors.size(); i++) {
                    sectorList.addElement(sectors.get(i));
                }
                appModel.setSectors(sectorList);
                uiList.setModel(sectorList);
            } catch (InvalidPatternException | FileNotFoundException | InvalidInputPathException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            } catch (Exception e) {
                JOptionPane .showMessageDialog(null, "Error");
            }
            textField.setText("");
        }
    }
}
