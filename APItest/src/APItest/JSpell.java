package APItest;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import org.json.JSONException;
import org.json.JSONObject;

public class JSpell {
	
	public String run(String text) throws UnirestException, JSONException {
		
		String result = null;
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("language", "enUS");
		jsonObject.put("fieldvalues", text);
		
		JSONObject jsonObject2 = new JSONObject();
		jsonObject2.put("forceUpperCase", false);
		jsonObject2.put("ignoreIrregularCaps", false);
		jsonObject2.put("ignoreFirstCaps", true);
		jsonObject2.put("ignoreNumbers", true);
		jsonObject2.put("ignoreUpper", false);
		jsonObject2.put("ignoreDouble", false);
		jsonObject2.put("ignoreWordsWithNumbers", true);
		
		jsonObject.put("config", jsonObject2);
		
		
		HttpResponse<String> response = Unirest
    		.post("https://jspell-checker.p.rapidapi.com/check")
    		.header("content-type", "application/json")
    		.header("x-rapidapi-key", "1e406bbe5fmsh2598f5fba231bacp10d145jsnd5e5c3374f9d")
    		.header("x-rapidapi-host", "jspell-checker.p.rapidapi.com")
    		.body(jsonObject)
    		.asString();
		
		JSONObject responsejJsonObject = new JSONObject(response.getBody().toString());
		
		result = responsejJsonObject.toString(4);

		return result;
	}
}
