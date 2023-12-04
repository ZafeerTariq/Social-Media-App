import java.util.ArrayList;

import javax.swing.*;

import Models.*;
import UI.Screens.*;

public class Main {
	public static State states = new State();

	ArrayList<User> users = new ArrayList<User>();
	ArrayList<Page> pages = new ArrayList<>();
	ArrayList<Post> posts = new ArrayList<>();

	private void createUsers() {
		users.add(new User("Zafeer", "Tariq"));
		users.add(new User("Hamza", "Mansoor"));
		users.add(new User("Syed", "Mujtaba"));
		users.add(new User("Abdullah", "Umer"));
		users.add(new User("Anzar", "Zahid"));
	}

	private void createPages() {
		pages.add(new Page("FCBarcelona"));
		pages.add(new Page("Linkin Park"));
		pages.add(new Page("Audioslave"));
		pages.add(new Page("Assassin's Creed"));
		pages.add(new Page("System Of A Down"));
	}

	private void createPosts() {
		posts.add(new Post("The GOAT Neymar!", pages.get(0)));
		posts.add(new Post("Chester Bennington we miss you", pages.get(1)));
		posts.add(new Post("Zafeer is my father", users.get(3)));
		posts.add(new Post("Bass good", pages.get(4)));
		posts.add(new Post("AC Mirage out now", pages.get(3)));
		posts.add(new Post("The GOAT Neymar", pages.get(0)));
		posts.add(new Post("The GOAT Neymar", pages.get(0)));
		posts.add(new Post("The GOAT Neymar", pages.get(0)));
		posts.add(new Post("The GOAT Neymar", pages.get(0)));
		posts.add(new Post("The GOAT Neymar", pages.get(0)));
	}

	private Main() {
		createUsers();
		createPages();
		createPosts();

		SwingUtilities.invokeLater(() -> {
			states.changeState(new HomePage(posts));
		});
	}

	public static void main(String[] args) {
		new Main();
	}
}