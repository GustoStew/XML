package classe;

import java.util.ArrayList;

import javax.jws.WebService;


/**
 * La classe Friend est un bean contenant les données et les méthodes relatives à un ami
 * @author Germain LE GUEN et Roxanne COUSIN
 */
@WebService
public class Friend {
	/**
	 * Prénom de l'ami
	 */
	private String firstName;
	/**
	 * Nom de l'ami
	 */
	private String lastName;
	/**
	 * Adresse mail de l'ami
	 */
	private String mail;
	/**
	 * Numéro de téléphone de l'ami
	 */
	private String phone;
	/**
	 * Adresse de l'ami
	 */
	private String address;
	/**
	 * Liste des noms des groupes dont l'ami fait partie
	 */
	private ArrayList<String> groups;
	
	/**
	 * Constructeur par défaut
	 */
	public Friend() {
		super();
	}
	
	/**
	 * Constructeur avec paramètres :
	 * Affecte les différents paramètres aux attributs de l'instance
	 * @param firstName Le prénom de l'ami
	 * @param lastName Le nom de l'ami
	 * @param mail L'adresse mail de l'ami
	 * @param phone Le numéro de téléphone de l'ami
	 * @param address L'adresse de l'ami
	 */
	public Friend(String firstName, String lastName, String mail, String phone,	String address) {
		super();
		this.groups = new ArrayList<String>();
		this.firstName = firstName;
		this.lastName = lastName;
		this.mail = mail;
		this.phone = phone;
		this.address = address;
	}
	/**
	 * Retourne le prénom de l'ami
	 * @return Prénom de l'ami
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Met à jour le prénom de l'ami
	 * @param firstName Le nouveau prénom
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * Retourne le nom de famille de l'ami 
	 * @return Le nom de famille de l'ami
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Met à jour le nom de famille de l'ami
	 * @param lastName Le nouveau nom de famille
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * Retourne l'adresse mail de l'ami
	 * @return L'adresse mail de l'ami
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * Met à jour l'adresse mail de l'ami
	 * @param mail La nouvelle adresse mail
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * Retourne le numéro de téléphone de l'ami
	 * @return Le numéro de téléphone de l'ami
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Met à jour le numéro de téléphone de l'ami
	 * @param phone Le nouveau numéro de téléphone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * Retourne l'adresse de l'ami
	 * @return L'adresse de l'ami
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Met à jour l'adresse de l'ami
	 * @param address La nouvelle adresse
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Retourne la liste des groupes dont l'ami fait partie
	 * @return Liste de groupes
	 */
	public ArrayList<String> getGroups() {
		return groups;
	}
	
	/**
	 * Met à jour la liste de groupes de l'ami
	 * @param groups La nouvelle liste de groupes
	 */
	public void setGroups(ArrayList<String> groups) {
		this.groups = groups;
	}
	
	/**
	 * Teste si les informations de l'ami contient la chaîne de caractères recherchée
	 * @param search Chaine de caractères recherchée
	 * @return Vrai si la chaine de caractère est contenu, Faux sinon
	 */
	public boolean infoMatchWithWord(String search){
		//On teste si la chaine de caractères est contenu dans le nom des groupes de l'ami
		for(String s : groups){
			if(s.toLowerCase().contains(search.toLowerCase())){
				return true;
			}
		}
		//On teste si la chaine de caractères est contenu dans les informations de l'ami
		if(firstName.toLowerCase().contains(search.toLowerCase())
    	|| lastName.toLowerCase().contains(search.toLowerCase())
    	|| mail.toLowerCase().contains(search.toLowerCase())
    	|| phone.toLowerCase().contains(search.toLowerCase())
    	|| address.toLowerCase().contains(search.toLowerCase()))
			return true;
		return false;
	}
}
