package services;

import java.util.Iterator;

import classe.*;

public class ServiceGroup {
	
	public static void addFriend(Group g, Friend f){
		g.getMembers().add(f.getMail());
		f.getGroups().add(g.getName());
	}
	
	public static void deleteFriend(Group g, Friend f){
		g.getMembers().remove(f.getMail());
		Iterator<String> iterator = f.getGroups().iterator();
		while(iterator.hasNext()){
			String s = iterator.next();
			if(s.equals(g.getName())){
				iterator.remove();
			}
		}
	}
	
}
