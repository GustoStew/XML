package classe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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
	
	public boolean friendExist(String idFriend){
		return getFriends().containsKey(idFriend);
	}
	
	public boolean groupExist(String idGroup){
		return getGroups().containsKey(idGroup);
	}
	
	public boolean hasNoFriends(){
		return friendCount==0;
	}
	
	public boolean hasNoGroups(){
		return groupCount==0;
	}
	
	public void addFriend(Friend f){
		friends.put(f.getMail(), f);
		friendCount++;
	}
	
	public void deleteFriend(String idFriend){
		Friend friendTmp = getFriends().get(idFriend);
		ArrayList<String> listGroupTmp = new ArrayList<String>(friendTmp.getGroups());
		for(String idGroup : listGroupTmp){
			deleteFriendFromGroup(idFriend, idGroup);
		}
		friends.remove(idFriend);
		friendCount--;
	}
	
	public void deleteFriendFromGroup(String idFriend, String idGroup){
		Friend f = getFriends().get(idFriend);
		Group g = getGroups().get(idGroup);
		g.deleteFriend(f);
	}
	
	public void deleteGroup(String idGroup){
		Group groupTmp = getGroups().get(idGroup);
		ArrayList<String> listFriendTmp = new ArrayList<String>(groupTmp.getMembers());
		for(String idFriend : listFriendTmp){
			deleteFriendFromGroup(idFriend, idGroup);
		}
		groups.remove(idGroup);
		groupCount--;
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

	/*public void modifyFriend(String keyFriend, String firstName, String lastName, String mail, String phone, String address, String nameGroup){
		for(Entry<String, Group> tmp : groups.entrySet()){
			if(tmp.getValue().getMembers().containsKey(keyFriend))
				tmp.getValue().getMembers().remove(keyFriend);
		}
		Friend newFriend = new Friend(firstName, lastName, mail, phone, address);
	}*/
}
