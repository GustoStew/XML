package classe;


import java.util.ArrayList;
import javax.jws.WebService;

@WebService
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
	
}
