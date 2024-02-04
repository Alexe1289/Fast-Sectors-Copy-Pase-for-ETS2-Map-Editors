import frame.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainFrame::new);
    }

//    private static void createAndShowGUI() {
//        JFrame frame = new JFrame("Folder Chooser Example");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        JButton chooseButton = new JButton("Choose Folder");
//        chooseButton.addActionListener(e -> showFolderChooserDialog(frame));
//
//        frame.getContentPane().add(chooseButton);
//
//        frame.setSize(500, 500);
//        frame.setLocationRelativeTo(null);
//        frame.setVisible(true);
//    }
//
//    private static void showFolderChooserDialog(JFrame frame) {
//        JFileChooser fileChooser = new JFileChooser();
//        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
//
//        int result = fileChooser.showOpenDialog(frame);
//
//        if (result == JFileChooser.APPROVE_OPTION) {
//            String selectedPath = fileChooser.getSelectedFile().getAbsolutePath();
//            JOptionPane.showMessageDialog(frame, "Selected Path: " + selectedPath);
//        } else {
//            JOptionPane.showMessageDialog(frame, "No folder selected");
//        }
//    }
}
