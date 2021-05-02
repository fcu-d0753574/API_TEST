package APItest;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import org.json.JSONException;
import org.json.JSONObject;

public class TextGears {

	public String readability(String text) throws UnirestException, JSONException {

		String result = null;

		HttpResponse<String> response = Unirest.post("https://textgears-textgears-v1.p.rapidapi.com/readability")
				.header("content-type", "application/x-www-form-urlencoded")
				.header("x-rapidapi-key", "1e406bbe5fmsh2598f5fba231bacp10d145jsnd5e5c3374f9d")
				.header("x-rapidapi-host", "textgears-textgears-v1.p.rapidapi.com")
				.body("text=" + text)
				.asString();

		JSONObject jsonObject = new JSONObject(response.getBody().toString());

		result = jsonObject.toString(4);

		return result;
	}

	public String summarize(String text) throws UnirestException, JSONException {

		String result = null;

		HttpResponse<String> response = Unirest.post("https://textgears-textgears-v1.p.rapidapi.com/summarize")
				.header("content-type", "application/x-www-form-urlencoded")
				.header("x-rapidapi-key", "1e406bbe5fmsh2598f5fba231bacp10d145jsnd5e5c3374f9d")
				.header("x-rapidapi-host", "textgears-textgears-v1.p.rapidapi.com")
				.body("text=" + text + "&max_sentences=3")
				.asString();

		JSONObject jsonObject = new JSONObject(response.getBody().toString());

		result = jsonObject.toString(4);

		return result;
	}

	public String spelling(String text) throws UnirestException, JSONException {

		String result = null;

		HttpResponse<String> response = Unirest.post("https://textgears-textgears-v1.p.rapidapi.com/spelling")
				.header("content-type", "application/x-www-form-urlencoded")
				.header("x-rapidapi-key", "1e406bbe5fmsh2598f5fba231bacp10d145jsnd5e5c3374f9d")
				.header("x-rapidapi-host", "textgears-textgears-v1.p.rapidapi.com")
				.body("text=" + text)
				.asString();

		JSONObject jsonObject = new JSONObject(response.getBody().toString());

		result = jsonObject.toString(4);

		return result;
	}
	
	public String grammar(String text) throws UnirestException, JSONException {

		String result = null;

		HttpResponse<String> response = Unirest.post("https://textgears-textgears-v1.p.rapidapi.com/grammar")
				.header("content-type", "application/x-www-form-urlencoded")
				.header("x-rapidapi-key", "1e406bbe5fmsh2598f5fba231bacp10d145jsnd5e5c3374f9d")
				.header("x-rapidapi-host", "textgears-textgears-v1.p.rapidapi.com")
				.body("text=" + text)
				.asString();

		JSONObject jsonObject = new JSONObject(response.getBody().toString());

		result = jsonObject.toString(4);

		return result;
	}
}
