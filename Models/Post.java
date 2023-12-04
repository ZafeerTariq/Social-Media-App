package Models;

import java.sql.Date;
import java.util.ArrayList;

public class Post {
	private Object sharedBy;
	private String text;
	private Date postDate;
	private ArrayList<Object> likedBy;

	public Post(String text, Object owner) {
		this.text = text;
		this.sharedBy = owner;
	}

	public Object getSharedBy() {
		return sharedBy;
	}

	public String getText() {
		return text;
	}
}
