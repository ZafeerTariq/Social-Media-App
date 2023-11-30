import javax.swing.*;

public class Main {
	public static final int SCREEN_WIDTH = 1600;
	public static final int SCREEN_HEIGHT = 900;

	private JFrame frame;

	private Main() {
        frame = new LoginFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        frame.setVisible(true);
	}

	public static void main(String[] args) {
		new Main();
	}
}