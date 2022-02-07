import java.util.Date;
public class AlfredQuotes {
    
    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }
    
    public String guestGreeting(String name) {
        // YOUR CODE HERE
        return String.format("Hello, %s. Lovely to see you", name);
    }
    
    public String dateAnnouncement() {
        // YOUR CODE HERE
        Date currentDate = new Date();
        return String.format("It is currently %s.", currentDate);
    }
    
    public String respondBeforeAlexis(String conversation) {
        // YOUR CODE HERE
        String response;
        if (conversation.indexOf("Alexis") >= 0) {
            response = "Right away, sir. She certainly isn't sophisticated enough for that.";
        } else if (conversation.indexOf("Alfred") >= 0) {
            response = "At your service. As you wish, naturally.";
        } else {
            response = "Right. And with that I shall retire.";
        }
        return response;
    }
    
	// NINJA BONUS
	// See the specs to overload the guessGreeting method
    public String guestGreeting(String name, String dayPeriod) {
        return String.format("Good %s, %s. Lovely to see you.", dayPeriod, name);
    }
    // SENSEI BONUS
    // Write your own AlfredQuote method using any of the String methods you have learned!
    
}

