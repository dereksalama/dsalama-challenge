<!DOCTYPE html>
<html>
  <head>
    <title>Hello Client Monkey 1</title>
    <script type="text/javascript"
      src="//static.twilio.com/libs/twiliojs/1.0/twilio.min.js"></script>
    <script type="text/javascript"
      src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js">
    </script>
    <link href="//static0.twilio.com/packages/quickstart/client.css"
      type="text/css" rel="stylesheet" />
    <script type="text/javascript">
 
    Twilio.Device.setup("${token}", {debug: true});
 
    Twilio.Device.ready(function (device) {
        $("#log").text("Ready");
    });
  
    Twilio.Device.error(function (error) {
        $("#log").text("Error: " + error.message);
    });
  
    Twilio.Device.connect(function (conn) {
        $("#log").text("Successfully established call");
    });
 
    /* Log a message when a call disconnects. */
    Twilio.Device.disconnect(function (conn) {
        $("#log").text("Call ended");
    });
 
    function call() {
        Twilio.Device.connect();
    }
 
    /* A function to end a connection to Twilio. */
    function hangup() {
        Twilio.Device.disconnectAll();
    }
    </script>
</head>
<body>
    <button class="call" onclick="call();">
      Call
    </button>
 
    <!-- use an onclick action to hang up the call when the user presses
    the button -->
    <button class="hangup" onclick="hangup();">
        Hangup
    </button>
  
    <div id="log">Loading pigeons...</div>
  </body>
</html>