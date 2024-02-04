package frame;

import data.UserData;
import buttons.ActionButton;
import buttons.Button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    private UserData userData = null;

    private Button preset1;
    private Button preset2;
    private ActionButton newAction;

    public MainFrame() {
        JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        preset1 = new Button("Preset Name", userData);
        preset2 = new Button("Second Preset Name", userData);
        newAction = new ActionButton();
        centerPanel.add(preset1);
        centerPanel.add(preset2);
        centerPanel.add(newAction);

        newAction.addActionListener(e -> openActionFrame());

        this.add(centerPanel, BorderLayout.CENTER);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 400);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    private void openActionFrame() {
        Point location = this.getLocation();
        this.dispose();
        new NewActionFrame(location, userData);
    }
}
