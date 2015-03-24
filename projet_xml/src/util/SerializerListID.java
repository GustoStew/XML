package util;

import java.beans.XMLDecoder;
import java.io.FileInputStream;

import classe.ListUserID;

public class SerializerListID extends XmlSerializer{
	
    public SerializerListID(String pathFile) {
		super(pathFile);
	}

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
