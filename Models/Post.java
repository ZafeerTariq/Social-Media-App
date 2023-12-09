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
		this.postDate = posted;
		this.likedBy = new ArrayList<>();
		this.comments = new ArrayList<>();
	}

	public void addLike(User user) {
		likedBy.add(user);
	}

	public void addComment(Comment comment) {
		comments.add(comment);
	}

	public ArrayList<Comment> getComments() {
		return comments;
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
