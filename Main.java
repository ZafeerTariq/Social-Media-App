import java.sql.Date;
import Models.User;

public class Main {
	public static final int SCREEN_WIDTH = 1600;
	public static final int SCREEN_HEIGHT = 900;

	private Main() {
		User user = new User(
			"zafeertariq", "Zafeer", "Tariq", "nothing in bio",
			"0300-4220223", new Date(2004, 3, 8)
		);
        new UserFrame(user);
	}

	public static void main(String[] args) {
		new Main();
	}
}