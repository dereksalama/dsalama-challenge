/*
 * Derek Salama
 * Jana Code Challenge
 * 10/14/2012
 */

/*
 * Object that fetches and parses reddit data
 */
package janachallenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class RedditParser {
	
	public RedditParser(){};
	
	/*
	 * fetches Reddit home page, then breaks down JSON
	 * object to get the title of the top post
	 */
	public String getRedditTopPost(){
		
		JsonParser parser = new JsonParser();
		String jString = getJSONfromUrl("http://www.reddit.com/.json");
		if (jString == null)
		{
			return null; //failed
		}
		
		/*
		 * Probably not the cleanest way to do things, but I continually
		 * parse json objects to "navigate" my way through Reddit's nested
		 * classes
		 */
		JsonObject redditJObj = parser.parse(jString).getAsJsonObject();
		
		JsonObject dataJObj = redditJObj.getAsJsonObject("data");
		
		JsonArray childArray = dataJObj.getAsJsonArray("children");
		
		JsonObject topPost = (JsonObject) childArray.get(0); //get first
		
		JsonObject topPostData = topPost.getAsJsonObject("data");
		
		return topPostData.get("title").getAsString();
	}
	
	/*
	 * Standard web connection, must use URL instead of HTTPClient
	 * because of GAE compatibilities
	 */
	public String getJSONfromUrl(String inputurl) {
		
		StringBuilder builder = new StringBuilder();

		URL url;
		try {
			url = new URL(inputurl);
			
				
			BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
			String line; 
				
			while((line = reader.readLine()) != null) {
				builder.append(line);
			}
				
			reader.close();
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		return builder.toString();
	}

}
