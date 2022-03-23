import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;

public class MySocialBook {

    public static void main(String[] args) {

        ArrayList<User> users = new ArrayList<>();

        ZoneId defaultZoneId = ZoneId.systemDefault();

        try {
            BufferedReader br = new BufferedReader(new FileReader(new File("/Users/apple/eclipse-workspace/Sena/users.txt")));
            String[] line;
            String st;
            int ID = 1;
            while ((st = br.readLine()) != null) {
                line = st.split("\t");
                String[] d = line[3].split("/");
                LocalDate localDate = LocalDate.of(Integer.valueOf(d[2]),Integer.valueOf(d[0]),Integer.valueOf(d[1]));
                Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());
                users.add(new User(ID,line[0],line[1],line[2],date,line[4]));
                ID++;
            }
            br.close();


            BufferedReader b = new BufferedReader(new FileReader(new File("/Users/apple/eclipse-workspace/Sena/commands.txt")));
            String s;
            String signInUser = "";


            while ((s = b.readLine()) != null) {

                String[] user = s.split("\t");
                System.out.println("-----------------------");
                System.out.println("Command: "+ s );

                if (user[0].equals("ADDUSER")) {

                    String[] d = user[4].split("/");
                    LocalDate localDate = LocalDate.of(Integer.parseInt(d[2]),Integer.parseInt(d[0]),Integer.parseInt(d[1]));
                    Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());
                    users.add(new User(ID,user[1],user[2],user[3],date,user[5]));
                    System.out.println(user[1] + " has been successfully added.");
                    ID++;
                }

                else if (user[0].equals("REMOVEUSER")) {

                    int id = Integer.parseInt(user[1]);
                    User f = findUsers(users,id);

                    if (f != null) {
                        users.remove(f);
                        System.out.println("User has been successfully removed.");
                    }else
                        System.out.println("No such user!");
                }

                else if (user[0].equals("SHOWPOSTS")) {

                    String username = user[1];
                    User bs = findUserUsername(users,username);

                    if (bs != null)
                        bs.showPosts();
                    else
                        System.out.println("No such user!");
                }

                else if (user[0].equals("SIGNIN")) {

                    String username = user[1];
                    String password = user[2];
                    User c = findUserUsername(users, username);

                    if (c == null || !c.getPassword().equals(password)){
                        System.out.println("Invalid username or password! Please try again.");
                    }else if (!signInUser.equals(""))
                        System.out.println("Only one user can sign in at a time!");
                    else {
                        c.signIn();
                        signInUser = username;
                    }
                }

                else if (s.startsWith("SIGNOUT")) {

                    if (signInUser.equals(""))
                        System.out.println("You can't sign out if you didn't sign in.");
                    else {
                        User cs = findUserUsername(users, signInUser);
                        assert cs != null;
                        cs.signOut();
                        signInUser = "";
                    }
                }

                else if (user[0].equals("UPDATEPROFILE")) {

                    String name = user[1];
                    String school = user[3];
                    String[] d = user[2].split("/");
                    LocalDate localDate = LocalDate.of(Integer.parseInt(d[2]),Integer.parseInt(d[0]),Integer.parseInt(d[1]));
                    Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());

                    if (signInUser.equals(""))
                        System.out.println("Error: Please sign in and try again.");
                    else {
                        User u = findUserUsername(users, signInUser);
                        assert u != null;
                        u.update(name,date,school);
                    }
                }

                else if (user[0].equals("CHPASS")) {

                    String oldPassword = user[1];
                    String newPassword = user[2];

                    if (signInUser.equals(""))
                        System.out.println("Error: Please sign in and try again.");
                    else {
                        User u = findUserUsername(users, signInUser);
                        assert u != null;
                        u.changePassword(oldPassword,newPassword);
                    }
                }

                else if (user[0].equals("ADDFRIEND")) {

                    String username = user[1];
                    User friend = findUserUsername(users, username);

                    if (signInUser.equals(""))
                        System.out.println("Error: Please sign in and try again.");
                    else if (friend == null)
                        System.out.println("No such user!");
                    else {
                        User ab = findUserUsername(users, signInUser);
                        assert ab != null;
                        ab.addFriend(friend);
                    }
                }

                else if (user[0].equals("REMOVEFRIEND")) {

                    String username = user[1];
                    User friend = findUserUsername(users, username);

                    if (signInUser.equals(""))
                        System.out.println("Error: Please sign in and try again.");
                    else if (friend == null)
                        System.out.println("No such user!");
                    else {
                        User e = findUserUsername(users, signInUser);
                        assert e != null;
                        e.removeFriend(friend);
                    }
                }

                else if (user[0].equals("ADDPOST-TEXT")) {

                    String text = user[1];
                    double longt = Double.parseDouble(user[2]);
                    double lat = Double.parseDouble(user[3]);

                    String[] tags = user[4].split(":");
                    ArrayList<User> taggedFriends = new ArrayList<>();

                    for(String tag: tags){
                        User h = findUserUsername(users,tag);
                        if (h != null)
                            taggedFriends.add(h);
                        else
                            System.out.println(tag + " is not your friend, and will not be tagged!");
                    }

                    if (signInUser.equals(""))
                        System.out.println("Error: Please sign in and try again.");
                    else {
                        User k = findUserUsername(users, signInUser);
                        assert k != null;
                        k.addTextPost(text,longt,lat,taggedFriends);
                    }
                }

                else if (user[0].equals("ADDPOST-IMAGE")) {

                    String text = user[1];
                    double longt = Double.parseDouble(user[2]);
                    double lat = Double.parseDouble(user[3]);
                    String filename = user[5];
                    String resolution = user[6];

                    String[] tags = user[4].split(":");
                    ArrayList<User> taggedFriends = new ArrayList<>();

                    for(String tag: tags){
                        User u = findUserUsername(users,tag);
                        if (u != null)
                            taggedFriends.add(u);
                        else
                            System.out.println(tag + " is not your friend, and will not be tagged!");
                    }

                    if (signInUser.equals(""))
                        System.out.println("Error: Please sign in and try again.");
                    else {
                        User o = findUserUsername(users, signInUser);
                        assert o != null;
                        o.addImagePost(text,filename,resolution,longt,lat,taggedFriends);
                    }
                }

                else if (user[0].equals("ADDPOST-VIDEO")) {
                    String[] post = s.split("\t");
                    String text = post[1];
                    double longt = Double.parseDouble(post[2]);
                    double lat = Double.parseDouble(post[3]);
                    String filename = post[5];
                    int duration = Integer.parseInt(post[6]);

                    String[] tags = post[4].split(":");
                    ArrayList<User> taggedFriends = new ArrayList<>();

                    for(String tag: tags){
                        User y = findUserUsername(users,tag);
                        if (y != null)
                            taggedFriends.add(y);
                        else
                            System.out.println(tag + " is not your friend, and will not be tagged!");
                    }

                    if (signInUser.equals(""))
                        System.out.println("Error: Please sign in and try again.");
                    else {
                        User q = findUserUsername(users, signInUser);
                        assert q != null;
                        q.addVideoPost(text,filename,duration,longt,lat,taggedFriends);
                    }
                }

                else if (user[0].equals("REMOVELASTPOST")) {
                    if (signInUser.equals(""))
                        System.out.println("Error: Please sign in and try again.");
                    else {
                        User p = findUserUsername(users, signInUser);
                        assert p != null;
                        p.removePost();
                    }
                }

                else if (user[0].equals("BLOCK")) {
                    String username = user[1];
                    User block = findUserUsername(users,username);

                    if (signInUser.equals(""))
                        System.out.println("Error: Please sign in and try again.");
                    else if (block == null)
                        System.out.println("No such user!");
                    else {
                        User g = findUserUsername(users, signInUser);
                        assert g != null;
                        g.blockUser(block);
                    }
                }

                else if (user[0].equals("UNBLOCK")) {

                    String username = user[1];
                    User unblock = findUserUsername(users,username);

                    if (signInUser.equals(""))
                        System.out.println("Error: Please sign in and try again.");
                    else {
                        User j = findUserUsername(users, signInUser);
                        assert j != null;
                        j.unblockUser(unblock);
                    }
                }

                else if (user[0].equals("LISTFRIENDS")) {

                    if (signInUser.equals(""))
                        System.out.println("Error: Please sign in and try again.");
                    else {
                        User r = findUserUsername(users, signInUser);
                        assert r != null;
                        r.listFriends();
                    }
                }

                else if (user[0].equals("LISTUSERS")) {
                    if (signInUser.equals(""))
                        System.out.println("Error: Please sign in and try again.");
                    else {
                        for (User userr : users)
                            System.out.println(userr);
                    }
                }

                else if (user[0].equals("SHOWBLOCKEDFRIENDS")) {
                    if (signInUser.equals(""))
                        System.out.println("Error: Please sign in and try again.");
                    else {
                        User x = findUserUsername(users, signInUser);
                        assert x != null;
                        x.listBlockedFriends();
                    }
                }

                else if (user[0].equals("SHOWBLOCKEDUSERS")) {
                    if (signInUser.equals(""))
                        System.out.println("Error: Please sign in and try again.");
                    else {
                        User vc = findUserUsername(users, signInUser);
                        assert vc != null;
                        vc.listBlockedUsers();
                    }
                }
            }
            b.close();

        } catch (IOException | NumberFormatException fnf) {
            System.out.println("users.txt not found");
        }
    }

    public static User findUsers(ArrayList<User> users, int ID){
        for (User userr : users) {
            if(userr.getUserID() == ID)
                return userr;
        }
        return null;
    }

    public static User findUserUsername(ArrayList<User> users, String username){
        for (User userr : users) {
            if(userr.getUsername().equals(username))
                return userr;
        }
        return null;
    }
}