package Models;

public class Page extends Object {
	private String name;

	public Page(int id, String name) {
		this.id = "p" + Integer.toString(id);
		this.name = name;
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
