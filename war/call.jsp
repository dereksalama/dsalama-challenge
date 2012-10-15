<!-- JSP page to generate xml for Twilio API -->

<?xml version="1.0" encoding="UTF-8" ?>
<%@ page import="janachallenge.RedditParser" %>

<Response>
     <Say>Hello Ben, here is today's top post. </Say>
     <% RedditParser rp = new RedditParser(); 
   		String topPostTitle = rp.getRedditTopPost();%>
     <Say><%out.println(topPostTitle);%></Say>
</Response>
