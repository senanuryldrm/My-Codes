import java.security.InvalidParameterException;
import java.util.ArrayList;

public class VideoPost extends Post {

    private String filename;
    private int duration;

    public VideoPost(String text, String filename,int duration,double lat,double longt,ArrayList<User> taggedFriends) {
        super(text, lat, longt, taggedFriends);
        int maxVideoLength = 10;
        if(duration > maxVideoLength)
            throw new InvalidParameterException("Error: Your video exceeds maximum allowed duration of 10 minutes.");

        this.filename = filename;
        this.duration = duration;
    }

    public String getFilename() {
        return this.filename;
    }
    public void setFilename(String filename) {
        this.filename = filename;
    }
    public int getDuration() {
        return this.duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Video: " + filename + "\n" +
                "Video duration: " + duration + " minutes";
    }
}
