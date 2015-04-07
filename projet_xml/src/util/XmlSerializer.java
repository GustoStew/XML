package util;


import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * La classe XmlSerializer permet de sauvegarder un objet complexe au format xml
 * @author Germain LE GUEN et Roxanne COUSIN
 *
 */
public abstract class XmlSerializer {
	
	/**
	 * Chemin vers le fichier xml 
	 */
    protected String pathFile;

    /**
     * Constructeur avec paramètre:
     * affecte le chemin en paramètre à l'instance
     * @param pathFile Chemin du fichier xml
     */
	public XmlSerializer(String pathFile) {
        this.pathFile = pathFile;
    }
	
	/**
	 * Retourne le chemin du fichier xml
	 * @return Chemin
	 */
	public String getPathFile() {
		return pathFile;
	}

	/**
	 * Met à jour le chemin du fichier xml
	 * @param pathFile Le nouveau chemin
	 */
	public void setPathFile(String pathFile) {
		this.pathFile = pathFile;
	}
	
	/**
	 * Crée le fichier au chemin contenu dans l'attribut pathFile
	 * @return Vrai si la création du fichier a réussi, Faux sinon
	 */
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
    
    /**
     * Sauvegarde un objet en xml 
     * @param o L'objet à sauvegarder
     */
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
    
    /**
     * Charge l'objet situé au chemin contenu dans l'attribut pathFile
     * @return Un objet 
     */
    public abstract Object getLastSave();
       
}
