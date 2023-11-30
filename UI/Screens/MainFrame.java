
import javax.swing.JFrame;
import javax.swing.WindowConstants;


public class MainFrame extends JFrame{
    public void init() {
        setTitle("Welcome ");
        setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
