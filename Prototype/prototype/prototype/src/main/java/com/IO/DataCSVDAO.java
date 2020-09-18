package com.IO;
import java.io.File;
//import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import au.com.bytecode.opencsv.CSVReader;

/**
 * @author Laureline Martin
 * Classe DataCSVDAO permettant la lecture de données dans un fichier .CSV pour un objet Data
 */
public class DataCSVDAO implements DataDAO {
    private final static String RESOURCES_PATH = "src/main/resources/";
    private final static String FILE_NAME = "data_file.csv";
	// private final static char SEPARATOR = ',';
    
    /*
     * Construteur vide
     */
    public DataCSVDAO() {}

    /**
     * Méthode pour lire les données d'un fichier .csv et les revoyer comme une liste d'objets Data.
     * @return List<Data> La liste d'objets Data contenant les données du fichier .csv
     * @throws IOException 
     */
    public List<Data> lecture(){
    	List<String[]> dataCSV = new ArrayList<String[]>();
        try {
	    	// Ouverture du fichier
	        File file = new File(RESOURCES_PATH + FILE_NAME);
	        FileReader fr = new FileReader(file);
	        CSVReader csvReader = new CSVReader(fr);
	        
	        // Lecture ligne à ligne
	        String[] nextLine = null; 
	        while ((nextLine = csvReader.readNext()) != null) {
	            int size = nextLine.length;
	            String debut = nextLine[0].trim();
	            // Si ligne vide
	            if (size == 0)  continue;
	            if (debut.length() == 0 && size == 1)   continue;
	            // Si ligne de commentaire
	            if (debut.startsWith("#"))   continue;
	            // Ajout données
	            dataCSV.add(nextLine);
	        }
	        //Fermeture fichier
	        csvReader.close();
	        fr.close();
	        } catch(IOException e) {
	        	e.printStackTrace();
	        }
        return donneesToData(dataCSV);
    }
    
    /**
     * Convertir une liste de données (String) en une liste d'objet Data
     * @param List<String[]> donnees  Une liste de chaîne de caractères contenant les données du fichier.CSV
     * @return List<Data>  Une liste d'objets Data.
     */
    public List<Data> donneesToData(List<String[]> donnees){
    	List<Data> data = new ArrayList<Data>();
        for(String[] donnee : donnees) {
        	double RR = Double.parseDouble(donnee[1]);
        	double GSR = Double.parseDouble(donnee[2]);
        	double BT = Double.parseDouble(donnee[3]);
        	double HR = Double.parseDouble(donnee[4]);
        	double lat = Double.parseDouble(donnee[5]);
        	double lon = Double.parseDouble(donnee[6]);
        	boolean pres = Boolean.parseBoolean(donnee[7]);
        	data.add(new Data(RR, GSR, HR, BT, lat, lon, pres));
        }
		return data;
    }
}
