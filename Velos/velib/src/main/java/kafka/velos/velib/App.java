package kafka.velos.velib;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Properties;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.json.JSONArray;
import org.json.JSONObject;

public class App 
{
    public static void main( String[] args ) throws UnirestException, UnsupportedEncodingException
    {
    	String url = "https://api.jcdecaux.com/vls/v1/stations";
    	String key = "ceed4b2d54f76506a4d840798ff4a96d66cc1d0c";
        HttpResponse <JsonNode> response = Unirest.get(url+"?apiKey="+key)
    		      .asJson();
    	Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(response.getBody().toString());
        String prettyJsonString = gson.toJson(je);
        //System.out.println(prettyJsonString);
        
        
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.ByteArraySerializer");
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
	    Producer producer = new KafkaProducer(props);
	    try {
	    	producer.send(new ProducerRecord<String, String>("velos", prettyJsonString));
	    	producer.close();
	    }catch (Exception e) {
	    	e.printStackTrace();
	    }
	    System.out.println("end !");
	    
    }
}
