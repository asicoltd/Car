import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class FirstMenu {
    public Scanner sc = new Scanner(System.in);
    public int signIn(String email, String passWord, ArrayList<Local> localList) {
        for ( int i = 0 ; i < localList.size() ; i++ ){
            if( localList.get(i).getEmail().equals(email) ){
                if( localList.get(i).getPassWord().equals(passWord) ){
                    return i;
                }
                if ( i == (localList.size()-1) ) {
                    System.out.println("Wrong Password\nPress 0 to return login menu");
                    int option = Int();
                    if(option == 0){
                        return -2;
                    }
                    return -1;
                }
            }
        }
        System.out.println("No Account found in this email\nPress 0 to return login menu");
        int option = Int();
        if(option == 0){
            return -2;
        }
        return -1;
    }

    public Local signUp() {
        while (true) {
            System.out.println("Sign Up as:\n1.Rider\n2.Driver\n3.Return to login menu");
            int option = Int();
            sc.nextLine();
            if (option == 1) {
                Local rider = new Rider();
                System.out.println("First Name: ");
                rider.setFirstName(sc.nextLine());
                System.out.println("Last Name: ");
                rider.setLastName(sc.nextLine());
                System.out.println("Email: ");
                rider.setEmail(sc.nextLine());
                System.out.println("Password: ");
                rider.setPassWord(sc.nextLine());
                System.out.println("Phone no: ");
                rider.setPhoneNo(Int());
                return rider;
            } else if (option == 2) {
                Driver driver = new Driver();
                System.out.println("First Name: ");
                driver.setFirstName(sc.nextLine());
                System.out.println("Last Name: ");
                driver.setLastName(sc.nextLine());
                System.out.println("Email: ");
                driver.setEmail(sc.nextLine());
                System.out.println("Password: ");
                driver.setPassWord(sc.nextLine());
                System.out.println("Phone no: ");
                driver.setPhoneNo(Int());
                System.out.println("Car no: ");
                driver.setCarNo(sc.nextLine());
                System.out.println("Driving Licence no: ");
                driver.setLicence(sc.nextLine());
                return driver;
            } else if (option == 3) {
                break;
            }
        }
        return null;
    }
    public int Int() {
        while (true) {
            try {
                return sc.nextInt();
            } catch (InputMismatchException e) {
                sc.next();
                System.out.print("Please enter an integer value\n");
            }
        }
    }
}