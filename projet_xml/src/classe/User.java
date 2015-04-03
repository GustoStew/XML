package classe;

import java.util.HashMap;

public class User {
	private String firstName, lastName, mail, phone, address;
	private HashMap<String, Group> groups;
	private HashMap<String, Friend> friends;
	private int friendCount, groupCount;
	
	public User() {
		super();
		friends = new HashMap<String, Friend>();
		groups = new HashMap<String, Group>();
	}

	public User(String firstName, String lastName, String mail, String phone, String address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.mail = mail;
		this.phone = phone;
		this.address = address;
		friends = new HashMap<String, Friend>();
		groups = new HashMap<String, Group>();
		friendCount = 0;
		groupCount = 0;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getFriendCount() {
		return friendCount;
	}

	public void setFriendCount(int friendCount) {
		this.friendCount = friendCount;
	}

	public int getGroupCount() {
		return groupCount;
	}

	public void setGroupCount(int groupCount) {
		this.groupCount = groupCount;
	}

	
	public HashMap<String, Group> getGroups() {
		return groups;
	}

	public void setGroups(HashMap<String, Group> groups) {
		this.groups = groups;
	}

	public HashMap<String, Friend> getFriends() {
		return friends;
	}

	public void setFriends(HashMap<String, Friend> friends) {
		this.friends = friends;
	}

	
}
