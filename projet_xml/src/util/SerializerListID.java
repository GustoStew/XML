package util;

import java.beans.XMLDecoder;
import java.io.FileInputStream;
import classe.ListUserID;

/**
 * La classe SerializerListID permet d'implémenter la méthode {@link XmlSerializer#getLastSave()} pour un objet de type {@link ListUserID} 
 * @author Germain LE GUEN et Roxanne COUSIN
 * @see ListUserID
 */
public class SerializerListID extends XmlSerializer{
	
	/**
	 * Appel du superconstructeur {@link XmlSerializer#XmlSerializer(String)}
	 * @param pathFile Le chemin du fichier
	 */
    public SerializerListID(String pathFile) {
		super(pathFile);
	}

    /**
     * Charge un objet de type {@link ListUserID} depuis le fichier xml situé au chemin contenu dans l'attribut pathFile
     * @return L'objet {@link ListUserID} situé au chemin contenu dans l'attribut pathFile
     */
	public ListUserID getLastSave(){
    	try {
            FileInputStream fs = new FileInputStream(this.pathFile);
            XMLDecoder decoder = new XMLDecoder(fs);
            return (ListUserID) decoder.readObject();

        } catch(Exception e){
        	createFile();
        	return new ListUserID();
        }
    } 
}
