package tutokafka.client;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.ProducerConfig;
// import org.apache.kafka.clients.producer.Producer;
import java.util.Properties;
import java.util.Scanner;

public class Producer {
	 private static Scanner in;
	 public static void main(String[] argv)throws Exception {
		 if (argv.length != 1) {
			 System.err.println("Please specify 1 parameters ");
			 System.exit(-1);
		 }
		 String topicName = argv[0];
		 in = new Scanner(System.in);
		 System.out.println("Enter message(type exit to quit)");
		 //Configure the Producer
		 Properties configProperties = new Properties();
		 configProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
		 configProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.ByteArraySerializer");
		 configProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
		 KafkaProducer producer = new KafkaProducer(configProperties);
		 String line = in.nextLine();
		 while(!line.equals("exit")) {
		 //TODO: Make sure to use the ProducerRecord constructor that does not take parition Id
		    try {
		    	ProducerRecord<String, String> rec = new ProducerRecord<String, String>(topicName,line);
		    	producer.send(rec);
		    	line = in.nextLine();
		    }catch (Exception e) {
		    	e.printStackTrace();
		    }
		 }
		 in.close();
		 producer.close();
	 }
}