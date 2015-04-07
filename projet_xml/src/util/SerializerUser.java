package util;

import java.beans.XMLDecoder;
import java.io.FileInputStream;
import classe.User;

/**
 * La classe XmlSerializerUser permet d'implémenter la méthode {@link XmlSerializer#getLastSave()} pour un objet de type {@link User}
 * @author Germain LE GUEN et Roxanne COUSIN
 * @see User
 */
public class SerializerUser extends XmlSerializer{
	
	/**
	 * Appel du superconstructeur {@link XmlSerializer#XmlSerializer(String)}
	 * @param pathFile Le chemin du fichier
	 */
	public SerializerUser(String pathFile) {
		super(pathFile);
	}
	
	/**
	 * Charge un objet de type {@link User} depuis le fichier xml situé au chemin contenu dans l'attribut pathFile
	 * @return L'objet {@link User} chargé depuis le fichier xml
	 */
	public User getLastSave() {
		 try {
	            FileInputStream fs = new FileInputStream(this.pathFile);
	            XMLDecoder decoder = new XMLDecoder(fs);
	            return (User) decoder.readObject();

	        } catch(Exception e){
	            System.out.println("Impossible de charger les informations de l'utilisateur");
	            return null;
	        }
	}
	
}
