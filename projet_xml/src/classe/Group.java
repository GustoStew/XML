package classe;


import java.util.HashMap;
import java.util.Iterator;

public class Group {
	private String name;
	private HashMap<String, Friend> members;
	
	public Group() {
		super();
	}
	
	public Group(String name){
		this.name=name;
		members = new HashMap<String, Friend>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HashMap<String, Friend> getMembers() {
		return members;
	}

	public void setMembers(HashMap<String, Friend> members) {
		this.members = members;
	}
	
	public void addFriendToGroup(Friend f){
		members.put(f.getMail(), f);
		f.getGroups().add(name);
	}
	
	public void deleteFriend(Friend f){
		members.remove(f.getMail());
		Iterator<String> iterator = f.getGroups().iterator();
		while(iterator.hasNext()){
			String s = iterator.next();
			if(s.equals(name))
				iterator.remove();
		}
	}
	
}
