import controller.MainController;
import view.frame.MainFrame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainController::new);
    }

//    private static void createAndShowGUI() {
//        JFrame view.frame = new JFrame("Folder Chooser Example");
//        view.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        JButton chooseButton = new JButton("Choose Folder");
//        chooseButton.addActionListener(e -> showFolderChooserDialog(view.frame));
//
//        view.frame.getContentPane().add(chooseButton);
//
//        view.frame.setSize(500, 500);
//        view.frame.setLocationRelativeTo(null);
//        view.frame.setVisible(true);
//    }
//
//    private static void showFolderChooserDialog(JFrame view.frame) {
//        JFileChooser fileChooser = new JFileChooser();
//        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
//
//        int result = fileChooser.showOpenDialog(view.frame);
//
//        if (result == JFileChooser.APPROVE_OPTION) {
//            String selectedPath = fileChooser.getSelectedFile().getAbsolutePath();
//            JOptionPane.showMessageDialog(view.frame, "Selected Path: " + selectedPath);
//        } else {
//            JOptionPane.showMessageDialog(view.frame, "No folder selected");
//        }
//    }
}
