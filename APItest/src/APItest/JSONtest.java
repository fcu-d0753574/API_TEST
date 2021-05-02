package APItest;

import org.json.JSONArray;
import org.json.JSONException;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;


public class JSONtest {
	
	public static void main(String[] args) throws UnirestException, JSONException {
		
		String text = "Texxt with mispeled anyWord";
		
		String newtext = text.replaceAll(" ", "%20");
		
		HttpResponse<String> response = Unirest.get("https://webspellchecker-webspellcheckernet.p.rapidapi.com/ssrv.cgi"
    				+ "?cmd=check_spelling&slang=en_US&out_type=words&text=" + newtext + "&format=json")
                    .header("x-rapidapi-key", "1e406bbe5fmsh2598f5fba231bacp10d145jsnd5e5c3374f9d")
                    .header("x-rapidapi-host", "webspellchecker-webspellcheckernet.p.rapidapi.com")
                    .asString();
				
		JSONArray jsonArray = new JSONArray(response.getBody().toString());
		
		System.out.println(jsonArray.toString(4));
		
	}

}
