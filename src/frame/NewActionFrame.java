package frame;

import data.UserData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class NewActionFrame extends JFrame {
    UserData userData;

    private JLabel pathLabel;
    private JTextField pathField;
    private JButton browseButton;

    public NewActionFrame(Point location, UserData userData) {
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 11, 10));

        this.pathLabel = new JLabel("Path:");
        pathLabel.setFont(new Font("Arial", Font.BOLD, 14));
        pathLabel.setBackground(Color.BLUE);

        this.pathField = new JTextField(25);
        this.pathField.setEditable(false);
        pathField.setFont(new Font("Verdana", Font.PLAIN, 12));

        this.browseButton = new JButton("Browse");
        browseButton.setPreferredSize(new Dimension(95, 25));
        this.add(pathLabel);
        this.add(pathField);
        this.add(browseButton);
        this.setSize(500, 400);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only the new frame
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                // Reopen the previous frame when the new frame is closed
                new MainFrame();
            }
        });

        browseButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

            int result = fileChooser.showDialog(null, "Select");
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                pathField.setText(selectedFile.getAbsolutePath());
                pathField.setEditable(false);
                updateTextFieldAppearance();
            }
        });
        this.setVisible(true);
        this.setLocation(location);
    }

    private void updateTextFieldAppearance() {
        if (pathField.getText().isEmpty()) {
            pathField.setBackground(Color.WHITE);
        } else {
            pathField.setBackground(Color.GREEN);
        }
    }
}
