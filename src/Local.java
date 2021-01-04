import java.util.*;
import java.io.*;

abstract class Local implements Serializable {

    private String firstName;
    private String lastName;
    private String email;
    private int phoneNo;
    private String passWord;
    private boolean Verification;
    private double rating = 5.0;
    ArrayList <Rides> ridesList = new ArrayList<>();


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNo(int phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getPhoneNo() {
        return phoneNo;
    }

    public double getRating() {
        return rating;
    }

    public String getEmail() {
        return email;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setRating(double rating) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            if (rating <= 5 && rating >= 0) {
                this.rating = (rating + this.rating) / 2.0;
                System.out.println("Thanks for rating");
                break;
            }
            else{
                System.out.println("Please rate between 0 to 5");
                 rating = sc.nextDouble();
            }
        }
    }
    public void setVerification(boolean verification ){
        this.Verification = verification;
    }
    public boolean getVerification(){
        return Verification;
    }
    public void addRide(Rides ride){
        ridesList.add(ride);
    }
    public ArrayList<Rides> previousRides(){
        return ridesList;
    }


}
