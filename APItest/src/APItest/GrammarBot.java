package APItest;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import org.json.JSONException;
import org.json.JSONObject;

public class GrammarBot {
	
	public String run(String text) throws UnirestException, JSONException {
		
		String result = null;
		
		HttpResponse<String> response = Unirest.post("https://grammarbot.p.rapidapi.com/check")
			.header("content-type", "application/x-www-form-urlencoded")
			.header("x-rapidapi-key", "1e406bbe5fmsh2598f5fba231bacp10d145jsnd5e5c3374f9d")
			.header("x-rapidapi-host", "grammarbot.p.rapidapi.com")
			.body("text=" + text +  "&language=en-US")
			.asString();
		
		JSONObject responsejJsonObject = new JSONObject(response.getBody().toString());
		
		result = responsejJsonObject.toString(4);		
		
		return result;
	}
}
