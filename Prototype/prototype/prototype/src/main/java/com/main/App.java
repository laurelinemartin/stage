package com.main;
import java.io.IOException;
import java.util.List;

import com.IO.file.LireSouscription;
import com.consumer.*;
import com.producer.*;

/**
 * Classe main, Appelle le producer et le consumer.
 *
 */
public class App 
{
    @SuppressWarnings("unused")
	public static void main( String[] args )
    {
        System.out.println( "Message du producer \n ----------------\n" );
        ProducerP prod = new ProducerP("test");
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
