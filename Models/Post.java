package Models;

import java.sql.Date;
import java.util.ArrayList;

public class Post {
	private int id;
	private Object sharedBy;
	private String text;
	private Date postDate;
	private ArrayList<Object> likedBy;
	private ArrayList<Comment> comments;

	public Post(int id, String text, Object poster, Date posted) {
		this.id = id;
		this.text = text;
		this.sharedBy = poster;
		this.likedBy = new ArrayList<>();
		this.postDate = posted;
	}

	public void addLike(User user) {
		likedBy.add(user);
	}

	public Object getSharedBy() {
		return sharedBy;
	}

	public String getText() {
		return text;
	}

	public int getID() {
		return id;
	}
}
