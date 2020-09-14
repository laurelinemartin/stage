package com.main;
import java.io.IOException;
import java.util.List;
import com.io.file.LireSouscription;
import com.consumer.*;

/**
 * Classe principale
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	if(args[0].equals("-file")) {
    		LireSouscription ls = new LireSouscription(args[1]);
    		List<String> topics = null;
			try {
				topics = ls.topics();
			} catch (IOException e) {
				e.printStackTrace();
			}
    		System.out.println( "Message du consumer \n ----------------\n" );
            for(String topic : topics) {
            	System.out.println(topic);
            	ConsumerC cons = new ConsumerC(topic);
            }
    	}
    	else {
    		System.out.println("Pas de souscription\n");
    	}
    }
}
