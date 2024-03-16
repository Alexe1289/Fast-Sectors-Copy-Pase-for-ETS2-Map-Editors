package commands;

import javax.swing.*;

public class NewActionCommand implements Command {
    private final JFrame frame;
    private final JFrame oldFrame;

    public NewActionCommand(JFrame frame, JFrame oldFrame) {
        this.frame = frame;
        this.oldFrame = oldFrame;
    }
    @Override
    public void execute() {
        frame.setVisible(true);
        oldFrame.setVisible(false);
    }
}
