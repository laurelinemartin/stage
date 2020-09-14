package com.io.file;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Laureline Martin
 * Classe LireConfig
 *
 */
public class LireSouscription {
	BufferedReader lecteur = null;
	/**
	 * @param file Le fichier de configuration à lire
	 */
	public LireSouscription(String file) {	
		try {
			lecteur = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Classe topic  met dans une liste tous les topics lus.
	 * @return topics  La liste de tous les topics dans le fichier de souscription.
	 * @throws IOException 
	 */
	public List<String> topics() throws IOException {
		String s = null;
    	List<String> topics = new ArrayList<String>();
		while((s = this.lecteur.readLine()) != null) {
			topics.add(s);
		}
		return topics;
	}
}
