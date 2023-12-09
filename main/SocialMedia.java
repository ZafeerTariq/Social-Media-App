package main;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.*;

import Database.DatabaseServices;
import Models.*;
import Models.Object;
import UI.Screens.*;
import Util.State;

public class SocialMedia {
	public static State states = new State();
	public static DatabaseServices db = new DatabaseServices();

	public static ArrayList<User> users = new ArrayList<User>();
	public static ArrayList<Page> pages = new ArrayList<>();
	public static ArrayList<Post> posts = new ArrayList<>();

	private static User currentUser;

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
		db.loadPosts();
		db.loadLikes();
		db.loadComments();

		posts.get(0).addComment(new Comment(2, "new comment", users.get(1), new java.sql.Date(2023, 12, 9)));
		posts.get(0).addComment(new Comment(3, "new comment", users.get(1), new java.sql.Date(2023, 12, 9)));
		posts.get(0).addComment(new Comment(4, "new comment", users.get(1), new java.sql.Date(2023, 12, 9)));
		posts.get(0).addComment(new Comment(5, "new comment", users.get(1), new java.sql.Date(2023, 12, 9)));
		posts.get(0).addComment(new Comment(6, "new comment", users.get(1), new java.sql.Date(2023, 12, 9)));
		posts.get(0).addComment(new Comment(7, "new comment", users.get(1), new java.sql.Date(2023, 12, 9)));
		posts.get(0).addComment(new Comment(8, "new comment", users.get(1), new java.sql.Date(2023, 12, 9)));
		posts.get(0).addComment(new Comment(9, "new comment", users.get(1), new java.sql.Date(2023, 12, 9)));
		posts.get(0).addComment(new Comment(10, "new comment", users.get(1), new java.sql.Date(2023, 12, 9)));
		posts.get(0).addComment(new Comment(11, "new comment", users.get(1), new java.sql.Date(2023, 12, 9)));
		posts.get(0).addComment(new Comment(12, "new comment 12", users.get(1), new java.sql.Date(2023, 12, 9)));

		currentUser = users.get(0);
		SwingUtilities.invokeLater(() -> {
			states.changeState(new HomePage());
		});
	}

	public static User searchUserByID(String id) {
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getID().equals(id))
				return users.get(i);
		}
		return null;
	}

	public static Object searchObjectByID(String id) {
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getID().equals(id))
				return users.get(i);
		}
		for (int i = 0; i < pages.size(); i++) {
			if (pages.get(i).getID().equals(id))
				return pages.get(i);
		}
		return null;
	}

	public static Post searchPostByID(int id) {
		for (int i = 0; i < posts.size(); i++) {
			if (posts.get(i).getID() == id)
				return posts.get(i);
		}
		return null;
	}

	public static void setCurrentUser(User user) {
		currentUser = user;
	}

	public static User getCurrentUser() {
		return currentUser;
	}

	public static void main(String[] args) {
		new SocialMedia();
	}
}