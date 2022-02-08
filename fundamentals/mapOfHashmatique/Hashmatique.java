import java.util.HashMap;
import java.util.Set;
public class Hashmatique {
    public static void main(String[] args) {
        HashMap<String,String>trackList = new HashMap<String,String>();
        trackList.put("Beat It","Beat it, Beat it...");
        trackList.put("Just The Way You Are","Girl you're amazing, just the way you are...");
        trackList.put("Panda","Panda Panda Panda Panda...");
        trackList.put("All I want for Christmas", "All I want for Christmas, is you....");
        System.out.println(trackList.get("Panda"));
        Set<String> keys = trackList.keySet();
        for (String key : keys) {
            System.out.println(String.format("%s: %s",key, trackList.get(key)));
        }
    }
}