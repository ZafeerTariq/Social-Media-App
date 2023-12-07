package Models;

import java.sql.Date;
import java.util.ArrayList;

public class User extends Object {
	private String username;
	private String firstName;
	private String lastName;
	private String bio;
	private String phoneNumber;
	private Date dob;
	private String city;
	private ArrayList<Hobby> hobbies;
	private ArrayList<User> friends;

	public User(int id, String username, String fName, String lName, String bio, String phone, Date dob, String city) {
		this.id = "u" + Integer.toString(id);
		this.username = username;
		this.firstName = fName;
		this.lastName = lName;
		this.bio = bio;
		this.phoneNumber = phone;
		this.dob = dob;
		this.city = city;
		this.hobbies = new ArrayList<>();
		this.friends = new ArrayList<>();
	}

	public void addFriend(User friend) {
		friends.add(friend);
	}

	public void printFriendList() {
		for (int i = 0; i < friends.size(); i++) {
			System.out.println(friends.get(i).getName());
		}
	}

	@Override
	public String getName() {
		return firstName + ' ' + lastName;
	}

	@Override
	public String getID() {
		return id;
	}

	public ArrayList<Hobby> getHobbies() {
		return hobbies;
	}

	public void setHobbies(ArrayList<Hobby> hobbies) {
		this.hobbies = hobbies;
	}
}