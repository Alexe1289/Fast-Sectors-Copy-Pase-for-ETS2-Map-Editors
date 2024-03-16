package buttons.listeners;

import commands.Command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextFieldListener implements ActionListener {
    private final Command command;

    public TextFieldListener(Command command) {
        this.command = command;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        command.execute();
    }
}
