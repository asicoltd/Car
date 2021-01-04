import java.io.Serializable;

public class Driver extends Local implements Serializable {
    private String carNo;
    private String Licence;
    private boolean Available;
    String experience = "1 year";
    int totalRide = 100;
    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public void setLicence(String licence) {
        Licence = licence;
    }

    public void setAvailable(boolean available) {
        Available = available;
    }

    public boolean isAvailable() {
        return Available;
    }


    @Override
    public String toString() {

        return  "Name :"+getFirstName()+" "+getLastName()+"\n"+
                "Email :"+getEmail()+"\n"+
                "Phone No :"+getPhoneNo()+"\n"+
                "Verified :"+getVerification()+"\n"+
                "Rating :"+getRating()+"\n"+
                "Car ID :"+carNo+"\n"+
                "Licence :"+Licence+"\n"+
                "Total Ride :"+ totalRide +"\n"+
                "Experience :"+ experience +"\n";
    }
}
