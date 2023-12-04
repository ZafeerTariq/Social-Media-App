package Models;

public class Page extends Object {
	private String name;

	public Page(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}
}
