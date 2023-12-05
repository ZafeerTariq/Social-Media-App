package Models;

import java.sql.Date;
import java.util.ArrayList;

public class User extends Object {
	private String userID;
	private String firstName;
	private String lastName;
	private String bio;
	private String phoneNumber;
	private Date dob;
	private ArrayList<Hobby> hobbies;

	public User(String id, String fName, String lName, String bio, String phone, Date dob) {
		this.userID = id;
		this.firstName = fName;
		this.lastName = lName;
		this.bio = bio;
		this.phoneNumber = phone;
		this.dob = dob;
	}

	public User(String fname, String lname) {
		this.firstName = fname;
		this.lastName = lname;
	}

	@Override
	public String getName() {
		return firstName + ' ' + lastName;
	}

	public String getUserID() {
		return userID;
	}

	public ArrayList<Hobby> getHobbies() {
		return hobbies;
	}

	public void setHobbies(ArrayList<Hobby> hobbies) {
		this.hobbies = hobbies;
	}
}