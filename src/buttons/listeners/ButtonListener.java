package buttons.listeners;

import buttons.Button;
import commands.Command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {
    private final Command command;
    public ButtonListener(Command command) {
        this.command = command;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        command.execute();
    }
}
