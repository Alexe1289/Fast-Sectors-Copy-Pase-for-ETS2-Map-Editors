package buttons;

import data.UserData;

import javax.swing.*;
import java.awt.*;

public class Button extends JButton {
    public Button(String name, UserData userData) {
        if (userData == null) {
            this.setText("[No Preset]");
            this.setEnabled(false);
        } else {
            this.setText(name);
        }
        this.setPreferredSize(new Dimension(200, 40));
        this.setFocusable(false);
    }
}
