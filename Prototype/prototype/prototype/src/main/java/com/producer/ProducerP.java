package com.producer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import com.IO.Data;
import com.IO.DataCSVDAO;
import com.IO.DataDAO;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.Producer;

import java.util.List;
import java.util.Properties;
// import java.util.Scanner;

/**
 * @author Laureline Martin
 *
 */
public class ProducerP {
	// Propriétés du producer
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
	      final DataDAO dataDao = new DataCSVDAO();
	      final List<Data> data = dataDao.lecture();
	      // System.out.println("Liste des eleves");
	      for (Data d : data) {
		        producer.send(new ProducerRecord<String, String>(topic, 
		        		  Data.toStringAll(d)));
		        try {
					wait(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
	      }
	      System.out.println("[INFO] : Message envoyé(s)" );
	      producer.close();
	 }
}
