package util;

import java.beans.XMLDecoder;
import java.io.FileInputStream;

import classe.User;

public class SerializerUser extends XmlSerializer{

	public SerializerUser(String pathFile) {
		super(pathFile);
	}

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
