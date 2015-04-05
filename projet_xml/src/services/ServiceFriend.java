package services;

import classe.Friend;

public class ServiceFriend {
	
	public static boolean infoMatchWithWord(Friend f, String search){
		for(String s : f.getGroups()){
			if(s.toLowerCase().contains(search.toLowerCase())){
				return true;
			}
		}
		;
		if(f.getFirstName().toLowerCase().contains(search.toLowerCase())
    	|| f.getLastName().toLowerCase().contains(search.toLowerCase())
    	|| f.getMail().toLowerCase().contains(search.toLowerCase())
    	|| f.getMail().toLowerCase().contains(search.toLowerCase())
    	|| f.getAddress().toLowerCase().contains(search.toLowerCase()))
			return true;
		return false;
	}
	
}
