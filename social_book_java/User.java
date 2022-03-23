import java.security.InvalidParameterException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class User{

    private int userID;
    private String name;
    private String username;
    private String password;
    private String school;

    Date dateOfBirth;
    Date logInDate;

    ArrayList<User> friends;
    ArrayList<Post> posts;
    private ArrayList<User> blockedUsers;

    public User(int userID,String name,String username,String password,Date dateOfBirth,String school) {
        this.userID = userID;
        this.name = name;
        this.username = username;
        this.password = password;
        this.school = school;
        this.dateOfBirth = dateOfBirth;

        this.friends = new ArrayList<>();
        this.posts = new ArrayList<>();
        this.blockedUsers = new ArrayList<>();
    }

    public void signIn(){
        this.logInDate = new Date();
        System.out.println("You have successfully signed in.");
    }

    public void signOut(){
        System.out.println("You have successfully signed out.");
    }

    public void changePassword(String oldPassword,String newPassword){
        if (!password.equals(oldPassword)) {
            System.out.println("Password mismatch!");
            return;
        }
        this.password = newPassword;
    }

    public void update(String name,Date dateOfBirth,String school){
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.school = school;

    }

    public void addFriend(User friend){
        for(int i=0;i<friends.size();i++) {

            if(friends.get(i)==friend) {
                System.out.println("This user is already in your friend list!");
                return;
            }
        }
        friends.add(friend);
        System.out.println(friend.getUsername() + " has been successfully added to your friend list.");
    }

    public void removeFriend(User friend){
        for(int i=0;i<friends.size();i++) {
            if (friends.get(i)!=friend) {
                System.out.println("No such friend!");
                return;
            }
        }
        friends.remove(friend);
        System.out.println(friend.getUsername() + " has been successfully removed from your friend list.");
    }

    public void addTextPost(String text,double longt,double lat,ArrayList<User> taggedFriends){

        Iterator<User> itr = taggedFriends.iterator();
        while (itr.hasNext()) {
            User u = itr.next();
            if (!friends.contains(u)){
                System.out.println(u.getUsername() + " is not your friend, and will not be tagged!");
                itr.remove();
            }
        }
        posts.add(new Post(text,lat,longt,taggedFriends));
        System.out.println("The post has been successfully added.");
    }

    public void addImagePost(String text,String filename,String resolution,double longt,double lat,ArrayList<User> taggedFriends){

        Iterator<User> itr = taggedFriends.iterator();
        while (itr.hasNext()) {
            User u = itr.next();
            for(int i=0;i<friends.size();i++) {
                if (!friends.contains(u)){
                    System.out.println(u.getUsername() + " is not your friend, and will not be tagged!");
                    itr.remove();
                }
            }
        }
        posts.add(new ImagePost(text,filename,resolution,lat,longt,taggedFriends));
        System.out.println("The post has been successfully added.");
    }

    public void addVideoPost(String text,String filename,int duration,double longt,double lat,ArrayList<User> taggedFriends){
        Iterator<User> itr = taggedFriends.iterator();
        while (itr.hasNext()) {
            User u = itr.next();
            if (!friends.contains(u)){
                System.out.println(u.getUsername() + " is not your friend, and will not be tagged!");
                itr.remove();
            }
        }

        try {
            posts.add(new VideoPost(text,filename,duration,lat,longt,taggedFriends));
            System.out.println("The post has been successfully added.");
        }
        catch (InvalidParameterException e) {
            System.out.println(e.getMessage());
        }
    }

    public void removePost(){
        if (posts == null) {
            System.out.println("Error: You do not have any post.");
            return;
        }
        posts.remove(posts.get(posts.size()-1));
        System.out.println("Your last post has been successfully removed.");
    }

    public void blockUser(User user){
        this.blockedUsers.add(user);
        System.out.println(user.getUsername() + " has been successfully blocked.");
    }

    public void unblockUser(User user){
        for(int i=0;i<friends.size();i++) {
            if(blockedUsers.get(i)!=user) {
                System.out.println("No such user in your blocked-user list!");
                return;
            }
        }
        this.blockedUsers.remove(user);
        System.out.println(user.getUsername() + " has been successfully unblocked.");
    }

    public void listFriends(){
        if(friends== null) {
            System.out.println("You have not added any friend yet!");
            return;
        }

        for (User user : friends)
            System.out.println(user);
    }

    public void listBlockedFriends(){
        boolean isFound = false;
        for (User user : blockedUsers) {
            for(int i=0;i<friends.size();i++) {
                if(friends.get(i)==user) {
                    isFound = true;
                    System.out.println(user);
                }
            }
        }
        if(!isFound)
            System.out.println("You haven't blocked any friend yet!");
    }

    public void listBlockedUsers(){
        if(blockedUsers== null) {
            System.out.println("You haven't blocked any user yet!");
            return;
        }
        for (User user : blockedUsers)
            System.out.println(user);
    }

    public void showPosts(){
        if (posts== null) {
            System.out.println(username + " does not have any posts yet.");
            return;
        }

        System.out.println("**************");
        System.out.println(username + "'s Posts");
        System.out.println("**************");

        for (Post post : posts) {
            System.out.println(post);
            System.out.println("----------------------");
        }
    }


    public int getUserID() {
        return this.userID;
    }
    public String getName() {
        return this.name;
    }
    public String getUsername() {
        return this.username;
    }
    public String getPassword() {
        return this.password;
    }

    @Override
    public String toString() {
        String pattern = "dd/MM/yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(dateOfBirth);

        return "Name: " + name + "\n" +
                "Username: " + username + "\n" +
                "Date of Birth: " + date + "\n" +
                "School: " + school + "\n" +
                "---------------------------";
    }
}