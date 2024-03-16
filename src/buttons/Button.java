package buttons;

import model.AppModel;

import javax.swing.*;
import java.awt.*;

public class Button extends JButton {
    public Button(AppModel appModel) {
        if (appModel == null || appModel.getPresetName() == null) {
            this.setEnabled(false);
            this.setText("[No preset]");
        } else {
            this.setText(appModel.getPresetName());
            this.setEnabled(true);
        }
        this.setPreferredSize(new Dimension(200, 40));
        this.setFocusable(false);
    }
}
