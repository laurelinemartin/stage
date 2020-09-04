package com.producer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.Producer;
import java.util.Properties;
// import java.util.Scanner;

/**
 * @author Laureline Martin
 *
 */
public class ProducerP {
	// Propriétés du producer ------------------------------------------
	 Properties configProperties = new Properties();
	 
	 /**
	  * Constructeur de la classe Producer
	  * @param String topic  Le topic pour envoyer les messages.
	  */
	 public ProducerP(String topic) {
		 configProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
		 configProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.ByteArraySerializer");
		 configProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
		 
	      Producer<String, String> producer = new KafkaProducer
	    	         <String, String>(configProperties);
	      int i = 0;
	      for(i = 0; i < 10; i++)
	          producer.send(new ProducerRecord<String, String>(topic, 
	        		  Integer.toString(i)));
	      System.out.println( i + "message(s) envoyé(s)" );
	      producer.close();
	 }
}
