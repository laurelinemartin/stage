package com.main;
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
        ProducerP prod = new ProducerP(args[0]);
    }
}
