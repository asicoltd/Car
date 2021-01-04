import java.io.Serializable;
public class Rider extends Local implements Serializable {


    @Override
    public String toString() {
        if(getVerification()){
            return  "Name :"+getFirstName()+" "+getLastName()+"\n"+
                    "Email :"+getEmail()+"\n"+
                    "Phone No :"+getPhoneNo()+"\n"+
                    "Rating :"+getRating()+"\n"+
                    "***Verified User***";
        }
        return  "Name :"+getFirstName()+" "+getLastName()+"\n"+
                "Email :"+getEmail()+"\n"+
                "Phone No :"+getPhoneNo()+"\n"+
                "Rating :"+getRating()+"\n";
    }
}
