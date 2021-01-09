import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Admin {
    private String firstName = "Asif";
    private String lastName = "Hasan";
    private String email = "asifhasan099@gmail.com";
    private int phoneNo = 1550032232;
    private String passWord = "I love java";
    ArrayList<Local> localList;
    void AdminLogin(){
        //
    }
    ArrayList<Local> saveLoad(){
        feature f = new extra();
        try {
            File myObj = new File(f.filepath);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
                localList.add(defaultAccount(1));
                localList.add(defaultAccount(2));
            } else {
                localList =  f.ReadObjectFromFile(extra.filepath);
                System.out.println("Save file loaded successfully");
            }
        } catch (IOException e) {
            System.out.println("An error occurred in save file");
            e.printStackTrace();
        }
        return localList;
    }
    public Local defaultAccount(int i) {
        if (i == 1) {
            Local r = new Rider();
            r.setFirstName("Default ");
            r.setLastName("Rider");
            r.setEmail("dr@gmail.com");
            r.setPhoneNo(1550032232);
            r.setPassWord("Password");
            r.setVerification(true);
            r.setRating(5);
            Rides rides = new Rides();
            r.ridesList.add(rides);
            return r;
        }
        Driver r = new Driver();
        r.setFirstName("Default ");
        r.setLastName("Driver");
        r.setEmail("dd@gmail.com");
        r.setPhoneNo(1828045672);
        r.setPassWord("Password");
        r.setVerification(true);
        r.setRating(5);
        r.setCarNo("ঢাকা মেট্রো গ ১৯-১৬২১");
        r.setLicence("NK0001441C00007");
        Rides rides = new Rides();
        r.ridesList.add(rides);
        return r;
    }
    public ArrayList<Local> getLocalList() {
        return localList;
    }

    public void setLocalList(ArrayList<Local> localList) {
        this.localList = localList;
    }
    void localControl(){
        // disable a local user
    }
}
