package classe;

import java.util.HashMap;

public class ListUserID {
	private HashMap<String, String> data;

	public ListUserID() {
		super();
		data = new HashMap<String, String>();
	}

	public HashMap<String, String> getData() {
		return data;
	}

	public void setData(HashMap<String, String> data) {
		this.data = data;
	}
	
	public boolean hasUser(String idUser){
		return data.containsKey(idUser);
	}
	
	public void addUser(String idUser, String pwd){
		data.put(idUser, pwd);
	}
	
	public String getUserPwd(String idUser){
		return data.get(idUser);
	}
	
}
