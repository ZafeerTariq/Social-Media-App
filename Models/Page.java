package Models;

import java.util.ArrayList;

public class Page extends Object {
	private String name;
	ArrayList<Post> posts;

	public Page(int id, String name) {
		this.id = "p" + Integer.toString(id);
		this.name = name;
		this.posts = new ArrayList<>();
	}

	@Override
	public void addPost(Post post) {
		posts.add(post);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getID() {
		return id;
	}
}
