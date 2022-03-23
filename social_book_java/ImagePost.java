import java.util.ArrayList;


public class ImagePost extends Post{

    private String filename;
    private String resolution;

    public ImagePost(String text,String filename,String resolution,double lat,double longt,ArrayList<User> taggedFriends) {
        super(text, lat, longt, taggedFriends);
        this.filename = filename;
        this.resolution = resolution;
    }

    public String getFilename() {

        return this.filename;
    }
    public void setFilename(String filename) {

        this.filename = filename;
    }
    public String getResolution() {
        return
                this.resolution;
    }
    public void setResolution(String resolution) {

        this.resolution = resolution;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Image: " + filename + "\n" +
                "Image resolution: " + resolution;
    }
}