package edu.upc.eetac.dsa;

import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.ResourceBundle;

public class I18NManager {
    final static Logger log = Logger.getLogger(I18NManager.class.getName());


    private static I18NManager instance;

    private HashMap<String, ResourceBundle> languages;


    private I18NManager(){
        languages = new HashMap<String, ResourceBundle>();
    }

    public static I18NManager getInstance(){
        if(instance == null) instance = new I18NManager();
        return instance;
    }

    public String getString (String filename, String key) throws Exception{
        //Let's see if the file exists
        ResourceBundle rbundle = languages.get(filename);

        if (rbundle ==null ) {
            log.info ("Busquemos el fichero");
            rbundle = ResourceBundle.getBundle(filename);
            languages.put(filename, rbundle);
        }
        else {
            log.info("Utilizamos lo encontrado en la cache!");
        }

        return rbundle.getString(key);
    }

}
