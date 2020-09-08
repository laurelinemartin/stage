package com.consumer;
import java.util.Properties;
import java.util.Arrays;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerConfig;
//import java.util.Scanner;

public class ConsumerC {
    Properties configProperties = new Properties();
	
	/**
	 * Constructeur de la classe ConsumerC
	 */
	public ConsumerC(String topic) {
		 configProperties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
         configProperties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.ByteArrayDeserializer");
         configProperties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
         configProperties.put(ConsumerConfig.GROUP_ID_CONFIG, "test");
         configProperties.put(ConsumerConfig.CLIENT_ID_CONFIG, "simple");
	     @SuppressWarnings("resource")
		KafkaConsumer<String, String> consumer = new KafkaConsumer
	         <String, String>(configProperties);
	     
	     // Souscription au topic test
	     consumer.subscribe(Arrays.asList(topic)) ;
	     System.out.println( "Souscription à " + topic + " : fait\n" );
	     
         // print the offset,key and value for the consumer records.
	     while (true) {
	          ConsumerRecords<String, String> records = consumer.poll(100);
	          for (ConsumerRecord<String, String> record : records)
	        	  System.out.printf("offset = %d, key = %s, value = %s\n", 
	        			  record.offset(), record.key(), record.value());
	      }
	}
}
