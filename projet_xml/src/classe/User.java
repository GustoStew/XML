package classe;

import java.util.HashMap;
import java.util.Map.Entry;

public class User {
	private String firstName, lastName, mail, phone, address;
	private HashMap<String, Group> groups;
	private HashMap<String, Friend> friends;
	private int friendCount, groupCount;
	
	public User() {
		super();
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
		addGroup("Travail");
		addGroup("Famille");
		addGroup("Amis");
		friendCount = 0;
		groupCount = 3;
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

	public void addGroup(String name){
		Group tmp = new Group(name);
		groups.put(name, tmp);
		groupCount = groups.size();
	}
	
	public void addFriend(Friend f, String nameGroup){
		Group g = groups.get(nameGroup);
		g.addFriendToGroup(f);
		int count = 0;
		for(Entry<String, Group> tmp : getGroups().entrySet()){
    		count += tmp.getValue().getMembers().size();  
      }
		friendCount = count;
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

	public void modifyFriend(String keyFriend, String firstName, String lastName, String mail, String phone, String address, String nameGroup){
		for(Entry<String, Group> tmp : groups.entrySet()){
			if(tmp.getValue().getMembers().containsKey(keyFriend))
				tmp.getValue().getMembers().remove(keyFriend);
		}
		Friend newFriend = new Friend(firstName, lastName, mail, phone, address);
		addFriend(newFriend, nameGroup);
	}
}
