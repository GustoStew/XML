package classe;

import java.util.ArrayList;
import java.util.Iterator;

import javax.jws.WebService;

/**
 * La classe Group est un bean les données et les méthodes relatives à un groupe 
 * @author Germain LE GUEN et Roxanne COUSIN
 */
@WebService
public class Group {
	/**
	 * Nom du groupe
	 */
	private String name;
	/**
	 * Liste des adresses mail des amis faisant partie du groupe
	 */
	private ArrayList<String> members;
	
	/**
	 * Construteur par défaut
	 */
	public Group() {
		super();
	}
	
	/**
	 * Constructeur avec paramètres :
	 * Initialise la liste d'amis et affecte le nom
	 * @param name Le nom du groupe
	 */
	public Group(String name){
		this.name=name;
		members = new ArrayList<String>();
	}

	/**
	 * Retourne le nom du groupe
	 * @return Le nom du groupe
	 */
	public String getName() {
		return name;
	}

	/**
	 * Met à jour le nom du groupe
	 * @param name Le nouveau nom du groupe
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Retourne la liste des adresses mail des amis faisant partie du groupe 
	 * @return Liste d'adresses mail
	 */
	public ArrayList<String> getMembers() {
		return members;
	}

	/**
	 * Met à jour la liste d'adresses mail des amis faisant partie du groupe
	 * @param members La nouvelle liste d'adresses mail
	 */
	public void setMembers(ArrayList<String> members) {
		this.members = members;
	}
	
	/**
	 * Ajoute un ami au groupe
	 * @param f L'ami à ajouter
	 */
	public void addFriend(Friend f){
		members.add(f.getMail());
		f.getGroups().add(name);
	}
	/**
	 * Supprime un ami du groupe
	 * @param f L'ami à supprimer
	 */
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
