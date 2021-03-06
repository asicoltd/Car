import java.util.*;
import java.lang.*;
public class Login {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        FirstMenu m1 = new FirstMenu(); // Load first menu
        SecondMenu m2 = new SecondMenu();// Load second menu
        feature f = new extra();// Load file read/ write methods and some visual effects
        f.loading("Program starting");
        ArrayList<Account> localList = f.read(); // Read data from save file
//        ArrayList<Account> localList = new ArrayList<>();
//        localList.add(f.defaultAccount(1));
//        localList.add(f.defaultAccount(2));
        int profile = 0;
        x:while (true) {
            f.clearScreen();
            System.out.println("1.Sign In\n2.Sign Up\n3.Save & Exit");
            int option = f.Int();
            if (option == 1) {
                do {
                    System.out.println("EMAIL: ");
                    String Email = sc.nextLine();
                    System.out.println("Password: ");
                    String Password = sc.nextLine();
                    profile = m1.signIn(Email, Password, localList); // Detail in FirstMenu class
                    if( profile == -2 )continue x;
                } while (profile == -1);
            } else if (option == 2) {
                    localList.add(m1.signUp()); // Detail in FirstMenu class
                System.out.println("Data has been saved");
                f.write(localList);
                    continue;
            } else if (option == 3) {
                f.write(localList);
                break;
            }
            while (true){
                int profileType = m2.profileType(profile,localList); // Detail in SecondMenu class
                if( profileType == 1 ) {//Rider == 1
                    System.out.println("1.View Profile\n2.Request a Ride\n3.Previous Rides\n4.Log Out");
                    int option2 = f.Int();
                    if (option2 == 1) {
                        m2.viewProfile(profile, localList); // Detail in SecondMenu class
                        if(!localList.get(profile).getVerification()){
                            System.out.println("Press 1 for Verify your Account");
                            int verifyOption = f.Int();

                            if( verifyOption == 1 )
                            localList.get(profile).setVerification(m2.verifyNow(profile,localList));
                        }
                    } else if (option2 == 2) {
                        localList.get(profile).ridesList.add(m2.searchRide(localList));
                    } else if (option2 == 3) {
                        m2.previousRides(profile,localList);
                    } else if (option2 == 4) {
                        break;
                    }
                }
                else{//Driver == 2
                    System.out.println("1.View Profile\n2.Availability\n3.Previous Rides\n4.Log Out");
                    int option2 = f.Int();
                    if (option2 == 1) {
                        m2.viewProfile(profile, localList);
                        if(!localList.get(profile).getVerification()){
                            System.out.println("Press 1 for Verify your Account");
                            int verifyOption = f.Int();
                            if( verifyOption == 1 )
                                localList.get(profile).setVerification(m2.verifyNow(profile,localList));
                        }
                    } else if (option2 == 2) {
                        if(localList.get(profile).getVerification()) {
                        m2.Available(profile,localList);
                        if(((Driver)localList.get(profile)).isAvailable()){
                                m2.receiveRide(profile, localList);
                            }
                        }
                        else
                            System.out.println("You are not verified");
                    } else if (option2 == 3) {
                        m2.previousRides(profile,localList);
                    } else if (option2 == 4) {
                        break ;
                    }
                }
            }
        }

    }

}
