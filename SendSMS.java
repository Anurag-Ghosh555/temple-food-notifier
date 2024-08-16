import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import java.util.HashMap;
import java.util.Map;

public class SendSMS {
    public static final String ACCOUNT_SID = "ACe893791947ad2e25cd713157dabf4d8e";
    public static final String AUTH_TOKEN = "b9ec5ca6ed9832c1361fb7df0003d8f7";

    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        // Define temples and their location links and food serving details
        Map<String, String> temples = new HashMap<>();
        temples.put("Shiva Temple", "https://maps.app.goo.gl/6j2GoTjRcfnQXDnh8, Food served on Mondays and Thursdays.");
        temples.put("Ganesh Temple", "https://maps.app.goo.gl/cudUHsTXSdWhnHsK8, Food served on Wednesdays and Fridays.");
        temples.put("Vishnu Temple", "https://maps.app.goo.gl/1ktN7TnjP3YrXQVQ9, Food served on Sundays and Tuesdays.");

        // Send the list of temples with details
        sendTempleDetails(temples);
    }

    private static void sendTempleDetails(Map<String, String> temples) {
        StringBuilder messageBody = new StringBuilder("\n List of temples with location links and food serving details:\n\n");
        for (Map.Entry<String, String> entry : temples.entrySet()) {
            String[] details = entry.getValue().split(", ");
            messageBody.append(entry.getKey()).append(":\n")
                    .append("Location: ").append(details[0]).append("\n")
                    .append("Food served on: ").append(details[1]).append("\n\n");
        }

        Message message = Message
                .creator(new PhoneNumber("+917394865520"),//User Number
                        new PhoneNumber("+12678734365"),//Twilio number
                        messageBody.toString())
                .create();
        System.out.println("Temple details sent: " + message.getSid());
    }
}