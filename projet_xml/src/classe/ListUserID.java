package classe;

import java.util.HashMap;
import javax.jws.WebService;

/**
 * La classe ListUserID est un bean contenant les adresses mail et mots de passe des différents utilisateurs
 * @author Germain LE GUEN et Roxanne COUSIN
 */
@WebService
public class ListUserID {
	/**
	 * HashMap contenant les mots de passe des utilisateurs, indexée par leurs adresses mail
	 */
	private HashMap<String, String> data;
	
	/**
	 * Constructeur par défaut :
	 * Initialise la HashMap
	 */
	public ListUserID() {
		super();
		data = new HashMap<String, String>();
	}
	
	/**
	 * Retourne la HashMap contenant les mots de passe des utilisateurs
	 * @return HashMap de String
	 */
	public HashMap<String, String> getData() {
		return data;
	}
	
	/**
	 * Met à jour la HashMap contenant les mots de passe des utlisateurs
	 * @param data Nouvelle HashMap de String
	 */
	public void setData(HashMap<String, String> data) {
		this.data = data;
	}
	
}
