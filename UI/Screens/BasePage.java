package UI.Screens;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class BasePage extends JFrame{
    public static final int SCREEN_WIDTH = 1280;
	public static final int SCREEN_HEIGHT = 720;

    public void enter() {
        setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void exit() {
        setVisible(false);
    }
}