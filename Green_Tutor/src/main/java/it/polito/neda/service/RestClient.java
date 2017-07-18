package it.polito.neda.service;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.Response;
import javax.xml.bind.DatatypeConverter;

import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RestClient {
	
	//private Client client= ClientBuilder.newClient();
	HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic("username", "password");
	 
	final Client client = ClientBuilder.newClient().register(feature);
	private String base_url = "http://192.168.1.80:8083/ZWaveAPI/Data/0";
	private WebTarget baseTarget = client.target(base_url);

	
	public Invocation getLuminicity() {

		return baseTarget.request().buildGet();
	}
	
	public int getLuminicityNumber() {
		
	
		int lumNum = 0;
		Response ris = this.getLuminicity().invoke();
		ObjectMapper mapper = new ObjectMapper();
		JsonNode root;
		//try {
			//root = mapper.readTree(ris.readEntity(String.class));
			System.out.println(ris.readEntity(String.class));
		//} catch (JsonProcessingException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
		//} catch (IOException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
		//}
		
		
		/*try {
			root = mapper.readTree(ris.readEntity(String.class));
			JsonNode nameNode = root.path("devices").path("3").path("instances").path("0").path("commandClasses").path("49").
			        path("data").path("3").path("val").path("value");
			
			lumNum = nameNode.asInt();
			
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block ['devices'][3]['instances'][0]['commandClasses'][49]['data'][3]['val']['value']
			e.printStackTrace();
		}*/
		return lumNum;
	}

}
