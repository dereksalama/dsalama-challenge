/*
 * Derek Salama
 * Jana Code Challenge
 * 10/14/2012
 */

/*
 * Web Servlet for handling POST requests from Twilio API
 */
package janachallenge;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


import javax.servlet.http.*;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.CallFactory;
import com.twilio.sdk.resource.instance.Account;
import com.twilio.sdk.resource.instance.Call;

@SuppressWarnings("serial")
public class JanachallengeServlet extends HttpServlet {
	
	
	public static final String ACCOUNT_SID = "AC80021eefa4455a5892df6beb800182a4";
	
	public static final String AUTH_TOKEN = "9a247199a8282d7269139cc5c344d1fd";
	
	//for the cron job
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		call();
		
		resp.setContentType("text/plain");
        resp.getWriter().println("call sent");
	}
	
	//supplying ximl
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.sendRedirect("/call.jsp");
	}
	
	/*
	 * Ideally this function would be triggered by the "cron" event in GAE,
	 * but GAE is not compatible with the ApacheHTTPclient Twilio uses
	 */
	public void call() {
		/* ERROR
		TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);
		
		Account account = client.getAccount();
		
		CallFactory callFactory = account.getCallFactory();
		
		Map<String, String> callParams = new HashMap<String, String>();
		
		callParams.put("To", "941-526-6106");
		callParams.put("From", "(941) 932-8198");
		
		callParams.put("Url", "http://janachallenge.appspot.com/janachallenge");
		
		try {
			Call call = callFactory.create(callParams);
		} catch (TwilioRestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
	}
	

}
