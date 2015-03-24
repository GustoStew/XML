package util;


import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


public abstract class XmlSerializer {

    protected String pathFile;

	public XmlSerializer(String pathFile) {
        this.pathFile = pathFile;
    }
	
	public String getPathFile() {
		return pathFile;
	}

	public void setPathFile(String pathFile) {
		this.pathFile = pathFile;
	}
	
    public boolean createFile(){
    	try{
    		File f = new File(this.pathFile);
    		f.createNewFile();
    		return true;
    	}
    	catch(IOException e){
    		System.out.println("Impossible de créer le fichier");
    		return false;
    	}
    }
    
    public void save(Object o){
        try {
            FileOutputStream os = new FileOutputStream(this.pathFile);
            XMLEncoder encoder = new XMLEncoder(os);

            encoder.writeObject(o);
            encoder.close();
        } 
        catch(Exception e ){
            if(createFile())
            	save(o);
            else{
            	System.out.println("Impossible de sauvegarder le fichier");
            }
        }
    }
    
    public abstract Object getLastSave();
       
}
