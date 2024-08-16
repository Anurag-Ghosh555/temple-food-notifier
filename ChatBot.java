
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message; // This is the Twilio REST API message
import com.twilio.type.PhoneNumber;
import com.twilio.twiml.MessagingResponse;
import com.twilio.twiml.messaging.Body;

import static spark.Spark.*;

public class ChatBot {

    // Your Twilio Account SID and Auth Token
    public static final String ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID_WP");
    public static final String AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN_WP");
    public static void main(String[] args) {
        // Initialize Twilio
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        // Set the port for Spark
        port(8080); // You can set this to any available port

        // Define the endpoint for handling incoming messages
        post("/whatsapp", (req, res) -> {
            String from = req.queryParams("From"); // Sender's number
            String body = req.queryParams("Body"); // Message content
            
            // Create a response message
            String responseMessage = "Thank you for your message: " + body;
            
            // Create a Twilio Message object to send a response
            Message.creator(
                new PhoneNumber(from), // To number
                new PhoneNumber("your_twilio_number"), // From number
                responseMessage // Message content
            ).create();
            
            // Create a Twilio MessagingResponse object
            Body myMsg = new Body
                    .Builder(responseMessage)
                    .build();

            MessagingResponse response = new MessagingResponse.Builder()
                .message(new com.twilio.twiml.messaging.Message.Builder()
                    .body(myMsg)
                    .build())
                .build();
            
            // Return the XML response
            res.type("application/xml");
            return response.toXml();
        });
    }
}