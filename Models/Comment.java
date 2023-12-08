package Models;

public class Comment {
	private int ID;
	private String text;
	private Object poster;

	public Comment(int id, String text, Object poster) {
		this.ID = id;
		this.text = text;
		this.poster = poster;
	}
}
