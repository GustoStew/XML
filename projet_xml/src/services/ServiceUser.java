package services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import classe.*;

public class ServiceUser {
	public static void addFriend(User u, Friend f){
		u.getFriends().put(f.getMail(), f);
		u.setFriendCount(u.getFriendCount()+1);
	}
	
	public static void addGroup(User u, String name){
		Group tmp = new Group(name);
		u.getGroups().put(name, tmp);
		u.setGroupCount(u.getGroups().size());
	}
	
	public static boolean friendExist(User u, String idFriend){
		return u.getFriends().containsKey(idFriend);
	}
	
	public static boolean groupExist(User u, String idGroup){
		return u.getGroups().containsKey(idGroup);
	}
	
	public static boolean hasNoFriends(User u){
		return u.getFriendCount()==0;
	}
	
	public static boolean hasNoGroups(User u){
		return u.getGroupCount()==0;
	}
	
	
	
	public static void deleteFriend(User u, String idFriend){
		Friend friendTmp = u.getFriends().get(idFriend);
		ArrayList<String> listGroupTmp = new ArrayList<String>(friendTmp.getGroups());
		for(String idGroup : listGroupTmp){
			deleteFriendFromGroup(u, idFriend, idGroup);
		}
		u.getFriends().remove(idFriend);
		u.setFriendCount(u.getFriendCount()-1);
	}
	
	public static void deleteFriendFromGroup(User u, String idFriend, String idGroup){
		Friend f = u.getFriends().get(idFriend);
		Group g = u.getGroups().get(idGroup);
		g.deleteFriend(f);
	}
	
	public static void deleteGroup(User u, String idGroup){
		Group groupTmp = u.getGroups().get(idGroup);
		ArrayList<String> listFriendTmp = new ArrayList<String>(groupTmp.getMembers());
		for(String idFriend : listFriendTmp){
			deleteFriendFromGroup(u, idFriend, idGroup);
		}
		u.getGroups().remove(idGroup);
		u.setGroupCount(u.getGroupCount()-1);
	}
	
	public static HashMap<String, Friend> searchMatch(User u, String research){	
		String[] searchTab = research.split(" ");
		HashMap<String, Friend> tabFriend = new HashMap<String, Friend>();
		for(Entry<String, Friend> friendTmp : u.getFriends().entrySet()){
			for(String s : searchTab){
				if(friendTmp.getValue().infoMatchWithWord(s)){
					tabFriend.put(friendTmp.getKey(),friendTmp.getValue());
					break;
				}
					
			}
		}
		return tabFriend;
	}
}
