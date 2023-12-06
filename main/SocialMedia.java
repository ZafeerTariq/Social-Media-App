package main;

import java.util.ArrayList;

import javax.swing.*;

import Database.DatabaseServices;
import Models.*;
import UI.Screens.*;
import Util.State;

public class SocialMedia {
	public static State states = new State();
	public static DatabaseServices db = new DatabaseServices();

	public static User searchUserByID(int id) {
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getUserID() == id)
				return users.get(i);
		}
		return null;
	}

	public static ArrayList<User> users = new ArrayList<User>();
	public static ArrayList<Page> pages = new ArrayList<>();
	public static ArrayList<Post> posts = new ArrayList<>();

	public static User currentUser;


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

	private SocialMedia() {
		// createUsers();
		// createPages();
		// createPosts();

		// currentUser = users.get(0);
		// ArrayList<Hobby> hobbies = new ArrayList<>();
		// hobbies.add(new Hobby("programming"));
		// hobbies.add(new Hobby("gaming"));
		// hobbies.add(new Hobby("cycling"));
		// hobbies.add(new Hobby("reading"));
		// currentUser.setHobbies(hobbies);

		db.initConnection();
		db.loadUsers();
		System.out.println(users.get(0).getName());
		users.get(0).printFriendList();
		System.out.println(users.get(1).getName());
		users.get(1).printFriendList();

		SwingUtilities.invokeLater(() -> {
			states.changeState(new LoginPage());
		});
	}

	public static void main(String[] args) {
		new SocialMedia();
	}
}