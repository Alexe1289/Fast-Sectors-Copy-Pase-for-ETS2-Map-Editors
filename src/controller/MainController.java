package controller;

import view.frame.MainFrame;
import view.frame.NewActionFrame;

public class MainController {
    private MainFrame mainFrame;
    private final NewActionFrame newActionFrame;

    public MainController() {
        mainFrame = new MainFrame();
        newActionFrame = new NewActionFrame();
        mainFrame.setNewAction(newActionFrame);

        newActionFrame.setCloseFrameListener(this::reloadMainFrame);
    }
    private void reloadMainFrame() {
        mainFrame.dispose();
        mainFrame = new MainFrame();
        mainFrame.setNewAction(newActionFrame);
    }
}
