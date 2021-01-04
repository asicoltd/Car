import static java.lang.Thread.*;
public class extra {
    public static Local defaultAccount(int i) {
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
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static void sleepSec( long sec ){
        try {
            sleep(sec * 100);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void loading(String s) {
        for( int i = 0 ; i < 1 ; i++ ) {
            clearScreen();
            System.out.println(s);
            sleepSec(5);
            clearScreen();
            System.out.println(s + " .");
            sleepSec(5);
            clearScreen();
            System.out.println(s + " ..");
            sleepSec(5);
            clearScreen();
            System.out.println(s + " ...");
            sleepSec(5);
            clearScreen();
            System.out.println(s + " ....");
            sleepSec(5);
        }
    }
}
