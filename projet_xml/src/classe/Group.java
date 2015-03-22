package classe;


import java.util.ArrayList;
import java.util.Iterator;

public class Group {
	private String name;
	private ArrayList<String> members;
	
	public Group() {
		super();
	}
	
	public Group(String name){
		this.name=name;
		members = new ArrayList<String>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<String> getMembers() {
		return members;
	}

	public void setMembers(ArrayList<String> members) {
		this.members = members;
	}

	public void addFriend(Friend f){
		members.add(f.getMail());
		f.getGroups().add(name);
	}
	
	public void deleteFriend(Friend f){
		members.remove(f.getMail());
		Iterator<String> iterator = f.getGroups().iterator();
		while(iterator.hasNext()){
			String s = iterator.next();
			if(s.equals(name)){
				iterator.remove();
			}
		}
	}
	
}
