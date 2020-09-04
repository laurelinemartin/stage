package com.main;
import com.consumer.ConsumerC;
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
        System.out.println( "Message du consumer \n ----------------\n" );
        ConsumerC cons = new ConsumerC("test");
    }
}
