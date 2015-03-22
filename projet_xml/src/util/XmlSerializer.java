package util;


import com.sun.org.apache.xml.internal.serialize.XMLSerializer;

import classe.*;

import java.awt.*;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class XmlSerializer {

    private String file;


    public XmlSerializer(String file) {
        this.file = file;
        try{
        File f = new File(file);
        f.createNewFile();
        }
        catch(IOException e){
        	System.out.println("impossible de créer le fichier");
        }
    }

    public void save(User u){
        try {

            FileOutputStream os = new FileOutputStream(this.file);
            XMLEncoder encoder = new XMLEncoder(os);

            encoder.writeObject(u);
            encoder.close();

        } catch(Exception e ){
            e.printStackTrace();
        }
    }


    public User getLastSave(){
        try {
            FileInputStream fs = new FileInputStream(this.file);
            XMLDecoder decoder = new XMLDecoder(fs);
            return (User) decoder.readObject();

        } catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}
    
    
    
}
