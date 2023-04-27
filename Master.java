import java.util.Random;

public class Master {
    private static volatile String user = "";
    private static volatile String pass  = "";
    protected static volatile String[] dataTemp = {null, null, null, null, null, null};
    public String logo = "Logo.png";
    public String logo2 = "Logo2.png";
    public String menu = "Menu.png";
    public String bg = "Background.png";
    public void setUser(String id, String password){
        user = id;
        pass = password;
    }
    public String getID(){
        return user;
    }
    public String getPW(){
        return pass;
    }

    protected String setID() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 5) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }

    protected String setPass() {
        String SALTCHARS = "1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 5) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }

    

}
