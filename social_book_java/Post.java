import java.util.ArrayList;
import java.util.Date;


public class Post {

    String text;
    Location location;
    Date created;

    ArrayList<User> taggedFriends;

    public Post(String text,double lat,double longt,ArrayList<User> taggedFriends) {
        this.text = text;
        this.location = new Location(lat,longt);
        this.taggedFriends = taggedFriends;
        this.created = new Date();
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder(text + "\n" +
                "Date: " + created.toString() + "\n" +
                location);

        if(taggedFriends!=null){
            output.append("\nFriends tagged in this post: ");
            for (User user : taggedFriends)
                output.append(user.getUsername()).append(",");
        }
        return output.toString();
    }
}