/*
 * Derek Salama
 * Jana Code Challenge
 * 10/14/2012
 */

/*
 * Quick program to iniate call using Twilio API
 * Must be called manually
 */

package janachallenge;

import java.util.HashMap;
import java.util.Map;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.CallFactory;
import com.twilio.sdk.resource.instance.Account;
import com.twilio.sdk.resource.instance.Call;

public class RedditCall {
	
	public static final String ACCOUNT_SID = "AC80021eefa4455a5892df6beb800182a4";
	
	public static final String AUTH_TOKEN = "9a247199a8282d7269139cc5c344d1fd";
	
	public static void main(String[] args) throws TwilioRestException {
		
		TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);
		
		Account account = client.getAccount();
		
		CallFactory callFactory = account.getCallFactory();
		
		Map<String, String> callParams = new HashMap<String, String>();
		
		callParams.put("To", "617-407-5240");
		callParams.put("From", "(941) 932-8198");
		
		callParams.put("Url", "http://janachallenge.appspot.com/janachallenge");
		
		Call call = callFactory.create(callParams);
	}

}
