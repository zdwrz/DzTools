package dztools.beans;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import dztools.model.LocationMain;

public class JerseyLocation {
	public static LocationMain getLocation(){
		Client restClient = ClientBuilder.newClient();  
        WebTarget target = restClient.target("http://www.aweiz.com/LocationServices/location/getCurrentLocation");  
        Response response= target.request(MediaType.APPLICATION_JSON).get();  
        if (response.getStatus() == 200) {
        	return parseLocationJsonForPage(response.readEntity(String.class));
        }
        return null;
	}
	
	public static LocationMain parseLocationJsonForPage(String json){
		Gson gson = new Gson();
		LocationMain main = gson.fromJson(json,LocationMain.class);
		return main;
	}
}
