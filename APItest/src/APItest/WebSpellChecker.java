package APItest;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import org.json.JSONArray;
import org.json.JSONException;

public class WebSpellChecker {

	public String grammarCheck(String text) throws UnirestException, JSONException {
		
		String result = null;
				
		text = this.replace(text);
		
		HttpResponse<String> response = Unirest.get("https://webspellchecker-webspellcheckernet.p.rapidapi.com/ssrv.cgi"
				+ "?cmd=grammar_check&text=" + text + "&slang=en_US&format=json")
				.header("x-rapidapi-key", "1e406bbe5fmsh2598f5fba231bacp10d145jsnd5e5c3374f9d")
				.header("x-rapidapi-host", "webspellchecker-webspellcheckernet.p.rapidapi.com")
				.asString();
		
		JSONArray jsonArray = new JSONArray(response.getBody().toString());
		
		result = jsonArray.toString(4);	
		
		
		return result;
	}
	
	public String spellCheck(String text) throws UnirestException, JSONException {
		
		String result = null;
		
		text = this.replace(text);
		
		HttpResponse<String> response = Unirest.get("https://webspellchecker-webspellcheckernet.p.rapidapi.com/ssrv.cgi"
    				+ "?cmd=check_spelling&slang=en_US&out_type=words&text=" + text + "&format=json")
                    .header("x-rapidapi-key", "1e406bbe5fmsh2598f5fba231bacp10d145jsnd5e5c3374f9d")
                    .header("x-rapidapi-host", "webspellchecker-webspellcheckernet.p.rapidapi.com")
                    .asString();
		
		JSONArray jsonArray = new JSONArray(response.getBody().toString());
		
		result = jsonArray.toString(4);	
		
		return result;
	}
	
	private String replace(String text) {
		
		text = text.replaceAll(" ", "%20");
		text = text.replace("\n", "%20");
		text = text.replace(",", "%2C");
		text = text.replace(":", "%3A");
		text = text.replace("?", "%3F");
		text = text.replace("$", "%24");
		text = text.replace("\"", "%22");
		
		return text;
	}
}
