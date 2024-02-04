package buttons;

import javax.swing.*;
import java.awt.*;

public class ActionButton extends JButton {
    public ActionButton() {
        this.setText("New Action");
        this.setPreferredSize(new Dimension(200, 40));
        this.setFocusable(false);
    }
}
