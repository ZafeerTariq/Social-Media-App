package Models;

import java.sql.Date;
import java.util.ArrayList;

public class Post {
	private Object sharedBy;
	private String text;
	private Date postDate;
	private ArrayList<Object> likedBy;

	public Post(String text, Object poster, Date posted) {
		this.text = text;
		this.sharedBy = poster;
		this.likedBy = new ArrayList<>();
		this.postDate = posted;
	}

	public Object getSharedBy() {
		return sharedBy;
	}

	public String getText() {
		return text;
	}
}
