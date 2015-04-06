package classe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.jws.WebService;

/**
 * La classe User est un bean contenant les données et méthodes relatives à un utilisateur
 * @author Germain LE GUEN et Roxanne COUSIN
 * @see Group
 * @see Friend
 */
@WebService
public class User {
	/**
	 * Prénom de l'utilisateur
	 */
	private String firstName;
	/**
	 * Nom de l'utilisateur
	 */
	private String lastName;
	/**
	 * Adresse mail de l'utilisateur
	 */
	private String mail;
	/**
	 * Numéro de téléphone de l'utilisateur
	 */
	private String phone;
	/**
	 * Adresse de l'utilisateur
	 */
	private String address;
	/**
	 * HashMap contenant les groupes de l'utilisateur, indexée par le nom du groupe
	 */
	private HashMap<String, Group> groups;
	/**
	 * HashMap contenant les amis de l'utilisateur, indexée par l'adresse mail de l'ami
	 */
	private HashMap<String, Friend> friends;
	/**
	 * Compteur du nombre d'amis
	 */
	private int friendCount;
	/**
	 * Compteur du nombre de groupes
	 */
	private int groupCount;
	
	
	/**
	 * Constructeur par défaut :
	 * Initialise les HashMap
	 */
	public User() {
		super();
		friends = new HashMap<String, Friend>();
		groups = new HashMap<String, Group>();
	}
	
	/**
	 * Constructeur avec paramètres :
	 * Initialise les HashMap, les compteurs d'amis et de groupes , et affecte les différents paramètres aux attributs de l'instance
	 * @param firstName Le prénom de l'utilisateur
	 * @param lastName Le nom de l'utilisateur
	 * @param mail L'adresse mail de l'utilisateur
	 * @param phone Le numéro de téléphone de l'utilisateur
	 * @param address L'adresse de l'utilisateur
	 */
	public User(String firstName, String lastName, String mail, String phone, String address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.mail = mail;
		this.phone = phone;
		this.address = address;
		friends = new HashMap<String, Friend>();
		groups = new HashMap<String, Group>();
		friendCount = 0;
		groupCount = 0;
	}
	
	/**
	 * Retourne le prénom de l'utilisateur
	 * @return Le prénom de l'utilisateur
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Met à jour le prénom de l'utilisateur
	 * @param firstName Le nouveau prénom
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * Retourne le nom de famille de l'utilisateur
	 * @return Nom de famille de l'utilisateur
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Met à jour le nom de famille de l'utilisateur
	 * @param lastName Le nouveau nom de famille
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Retourne l'adresse mail de l'utilisateur
	 * @return Adresse mail de l'utilisateur
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * Met à jour l'adresse mail de l'utilisateur
	 * @param mail La nouvelle adresse mail
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * Retourne le numéro de téléphone de l'utilisateur
	 * @return Le numéro de téléphone de l'utilisateur
	 */
	public String getPhone() {
		return phone;
	}
	
	/**
	 * Met à jour le numéro de téléphone de l'utilisateur
	 * @param phone Le nouveau numéro de téléphone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * Retourne l'adresse de l'utilisateur
	 * @return L'adresse de l'utilisateur
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * Met à jour l'adresse de l'utilisateur
	 * @param address La nouvelle adresse
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * Retourne le nombre d'amis de l'utilisateur
	 * @return friendCount
	 */
	public int getFriendCount() {
		return friendCount;
	}

	/**
	 * Met à jour le nombre d'amis de l'utilisateur
	 * @param friendCount Le nouveau nombre d'amis
	 */
	public void setFriendCount(int friendCount) {
		this.friendCount = friendCount;
	}
	
	/**
	 * Retourne le nombre de groupes de l'utilisateur
	 * @return groupCount
	 */
	public int getGroupCount() {
		return groupCount;
	}
	
	/**
	 * Met à jour le nombre de groupes de l'utilisateur
	 * @param groupCount Le nouveau nombr de groupes
	 */
	public void setGroupCount(int groupCount) {
		this.groupCount = groupCount;
	}

	/**
	 * Retourne la HashMap contenant les groupes de l'utilisateur
	 * @return HashMap de Group
	 */
	public HashMap<String, Group> getGroups() {
		return groups;
	}
	
	/**
	 * Met à jour la HashMap contenant les groupes de l'utilisateur
	 * @param groups Nouvelle HashMap de Group
	 */
	public void setGroups(HashMap<String, Group> groups) {
		this.groups = groups;
	}
	
	/**
	 * Retourne la HashMap contenant les amis de l'utilisateur
	 * @return HashMap de Friend
	 */
	public HashMap<String, Friend> getFriends() {
		return friends;
	}
	
	/**
	 * Met à jour la HashMap contenant les amis de l'utilisateur
	 * @param friends Nouvelle HashMap de Friend
	 */
	public void setFriends(HashMap<String, Friend> friends) {
		this.friends = friends;
	}
	
	/**
	 * Ajoute un ami à l'utilisateur
	 * @param f L'ami à ajouter
	 */
	public void addFriend(Friend f){
		friends.put(f.getMail(), f);
		friendCount++;
	}
	
	/**
	 * Ajoute un groupe à l'utilisateur
	 * @param name Le nom du groupe à ajouter
	 */
	public void addGroup(String name){
		Group tmp = new Group(name);
		groups.put(name, tmp);
		groupCount++;
	}
	
	/**
	 * Teste si un ami existe déjà pour un utilisateur
	 * @param idFriend L'adresse mail de l'ami
	 * @return Vrai si il existe, Faux sinon
	 */
	public boolean friendExist(String idFriend){
		return friends.containsKey(idFriend);
	}
	
	/**
	 * Teste si un groupe existe déjà pour un utilisateur
	 * @param idGroup Le nom du groupe
	 * @return Vrai si le groupe existe, Faux sinon
	 */
	public boolean groupExist(String idGroup){
		return groups.containsKey(idGroup);
	}
	
	/**
	 * Supprime un ami de l'utilisateur
	 * @param idFriend L'adresse mail de l'ami
	 * @see User#deleteFriendFromGroup(String, String)
	 */
	public void deleteFriend(String idFriend){
		Friend friendTmp = friends.get(idFriend);
		//On supprime l'ami des différents groupes dont il fait partie
		ArrayList<String> listGroupTmp = new ArrayList<String>(friendTmp.getGroups());
		for(String idGroup : listGroupTmp){
			deleteFriendFromGroup(idFriend, idGroup);
		}
		friends.remove(idFriend);
		friendCount--;
	}
	
	/**
	 * Supprime un ami d'un groupe de l'utilisateur
	 * @param idFriend L'adresse mail de l'ami
	 * @param idGroup Le nom du groupe
	 * @see Group#deleteFriend(Friend)
	 */
	public void deleteFriendFromGroup(String idFriend, String idGroup){
		Friend f = friends.get(idFriend);
		Group g = groups.get(idGroup);
		g.deleteFriend(f);
	}
	
	/**
	 * Supprime un groupe de l'utilisateur
	 * @param idGroup Nom du groupe
	 */
	public void deleteGroup(String idGroup){
		Group groupTmp = groups.get(idGroup);
		//On supprime le groupe des amis qui en font partie
		ArrayList<String> listFriendTmp = new ArrayList<String>(groupTmp.getMembers());
		for(String idFriend : listFriendTmp){
			deleteFriendFromGroup(idFriend, idGroup);
		}
		groups.remove(idGroup);
		groupCount--;
	}
	
	/**
	 * Renvoie les amis qui ont des informations qui concordent avec la chaîne de caractères recherchée
	 * @param research Chaîne de caractères recherchée
	 * @return HashMap de Friend, indexée par leurs adresses mail
	 * @see Friend#infoMatchWithWord(String)
	 */
	public HashMap<String, Friend> searchMatch(String research){
		//On décompose la chaîne de caractères en mots
		String[] searchTab = research.split(" ");
		
		//Pour chaque ami de l'utilisateur, on teste si chaque mot est contenu dans ses informations
		//Si chacun des mots est contenu dans ses informations alors l'ami est stocké dans une HashMap
		HashMap<String, Friend> tabFriend = new HashMap<String, Friend>();
		for(Entry<String, Friend> friendTmp : friends.entrySet()){
			int concordanceCount = 0;
			for(String s : searchTab){
				if(friendTmp.getValue().infoMatchWithWord(s)){
					concordanceCount++;
				}
			}
			if(concordanceCount==searchTab.length)
				tabFriend.put(friendTmp.getKey(),friendTmp.getValue());
		}
		return tabFriend;
	}
}
