package com.producer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import com.IO.Data;
import com.IO.DataDAO;
import com.IO.DataCSVDAO;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.Producer;
import java.util.List;
import java.util.Properties;

/**
 * @author Laureline Martin
 * Classe ProducerP  Gère le producteur
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
		 configProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
		 configProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
		 
	      Producer<String, String> producer = new KafkaProducer
	    	         <String, String>(configProperties);
	      final DataDAO dataDao = new DataCSVDAO();
	      final List<Data> data = dataDao.lecture();
	      // System.out.println("Liste des eleves");
	      for (Data d : data) {
		        producer.send(new ProducerRecord<String, String>("Vector", 
		        		  Data.toStringPhysio(d)));
		        producer.send(new ProducerRecord<String, String>("GSR", 
		        		  Data.toStringGSR(d)));
		        producer.send(new ProducerRecord<String, String>("HR", 
		        		  Data.toStringHR(d)));
		        producer.send(new ProducerRecord<String, String>("BT", 
		        		  Data.toStringBT(d)));
		        producer.send(new ProducerRecord<String, String>("RR", 
		        		  Data.toStringRR(d)));
		        producer.send(new ProducerRecord<String, String>("Lat", 
		        		  Data.toStringLat(d)));
		        producer.send(new ProducerRecord<String, String>("Lon", 
		        		  Data.toStringLon(d)));
		        producer.send(new ProducerRecord<String, String>("Pres",
		        		Data.toStringPres(d)));
		        // Simulation temps-réel
		        try {
					Thread.sleep(30);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
	      }
	      System.out.println("[INFO] : Message envoyé\n" );
	      producer.close();
	 }
}
