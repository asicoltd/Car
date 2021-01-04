import java.util.*;
public class SecondMenu {
    public Scanner sc = new Scanner(System.in);
    //View Profile
     public void viewProfile(int profile, ArrayList<Local> localList){
        System.out.println(localList.get(profile).toString());
    }
    //Profile Type
    public int profileType(int profile, ArrayList<Local> localList){
         if(localList.get(profile) instanceof Rider) return 1;
         else return 2;
    }
    //Verify Now
    public boolean verifyNow(int profile, ArrayList<Local> localList){
         while(true) {
             System.out.println("1.Verify by phone number\n2.Verify by Email\n3.Verify Later");
             int option = sc.nextInt();
             sc.nextLine();
             if (option == 1) {
                 System.out.println("Enter your phone No.");
                 while (true) {
                     int phn = sc.nextInt();
                     sc.nextLine();
                     if (phn == (localList.get(profile).getPhoneNo())) {
                         extra.loading("Verifying");
                         return true;
                     } else {
                         System.out.println("Please try with your registered Phone no\n0.Return");
                         int optionPhn = sc.nextInt();
                         sc.nextLine();
                         if (optionPhn == 0) break;
                     }
                 }
             } else if (option == 2) {
                 System.out.println("Enter your Email");
                 while (true) {
                     String mail = sc.nextLine();
                     if (mail.equals(localList.get(profile).getEmail())) {
                         extra.loading("Verifying");
                         return true;
                     } else {
                         System.out.println("Please try with your registered email\n0.Return");
                         int optionMail = sc.nextInt();
                         sc.nextLine();
                         if (optionMail == 0) break;
                     }
                 }
             }
             else if( option == 3 )break;
         }
         return false;
    }
    //Previous Rides
    public void previousRides(int profile, ArrayList<Local> localList){
         for (int i = 0 ; i < localList.get(profile).previousRides().size(); i++){
             System.out.println(localList.get(profile).previousRides().get(i));
         }
    }
    //For Rider
    //Search Ride
    public Rides searchRide(ArrayList<Local> localList) {
        System.out.println("Destination :");
        String string = sc.nextLine();
        Rides ride = new Rides();
        ride.setDestination(string);
        System.out.println("Pickup Point :");
        string = sc.nextLine();
        ride.setPickupPoint(string);
        //MapAPI
        System.out.println("Total distance :"+ride.getTotalDistance()+" Km");
        extra.loading("Estimating Bill");
        System.out.println("Estimated Bill : "+ ride.getEstimatedBill()+" tk\nContinue Ride?\n1.Yes\n2.No");
        int continueOption = sc.nextInt();
        sc.nextLine();
        if( continueOption == 2 ){
            return null;
        }
        //searching rider
        int driverNo = -1;
        extra.loading("Searching driver");
        for (int i = 0 ; i < localList.size() ; i++ ) {
            if (localList.get(i) instanceof Driver) {
                if (((Driver) localList.get(i)).isAvailable()) {
                    driverNo = i;
                    System.out.println("Driver found:\n" + (localList.get(i)).getFirstName()+" "+ localList.get(i).getLastName());
                    break;
                }
            }
        }
        if (driverNo == -1) {
            System.out.println("Sorry!!! No Driver found active");
            return null;
        } else {
            extra.loading("Ride Starting");
            ride.setStartTime();
            extra.loading("Riding");
            System.out.println("Ride will end approximately "+ride.getEstimatedTime()+" min");
            ride.setEndingTime();
            System.out.println("Reach to your destination at "+ride.getTimeNeeded()+" min needed");
            ride.setTotalTime();
            System.out.println("Total time (Min.):" + ride.getTotalTime());
            while (true) {
                System.out.println("Pay bill "+ ride.getBillNeeded()+"\nTo pay bill press 1");
                int payOption = sc.nextInt();
                sc.nextLine();
                if (payOption == 1) {
                    System.out.println("Bill paid successfully");
                    System.out.println("How many stars for " + localList.get(1).getFirstName() +
                            " " + localList.get(1).getLastName());
                    localList.get(driverNo).setRating(sc.nextDouble());
                    sc.nextLine();
                    System.out.println("Thanks for rating");
                    return ride;
                }
            }
        }
    }
    //For Driver
    //Ride request
    public void receiveRide(int riderNo,ArrayList<Local> localList) {
        Rides ride = new Rides();

        extra.loading("Searching pickup request ");
        System.out.println("1 pickup request found");
        System.out.println("1.Accept\n2.Cancel");
        int option = sc.nextInt();
        sc.nextLine();
        if (option == 1) {
            System.out.println("Rider Name :" + localList.get(0).getFirstName() + " " + localList.get(0).getLastName());
            System.out.println("Pickup Point : Khilgaon Taltala Market");
            //MapAPI
            extra.loading("Almost reached to the Rider's pick up point");
            System.out.println("Press 1 for start ride");
            int startOption = sc.nextInt();
            sc.nextLine();
            if (startOption == 1) {
                extra.loading("Ride Starting");
                ride.setStartTime();
                extra.loading("Riding");
                System.out.println("Ride will end approximately 30 min");
                ride.setEndingTime();
                System.out.println("Reach to your destination");
                ride.setTotalTime();
                System.out.println("Total time (Min.):" + ride.getTimeNeeded());
                System.out.println("Bill :"+ride.getBillNeeded());

                System.out.println("How many stars for " + localList.get(0).getFirstName()+
                        " "+ localList.get(0).getLastName());
                localList.get(0).setRating(sc.nextDouble());
                sc.nextLine();
                System.out.println("Thanks for rating");
                localList.get(riderNo).addRide(ride);
            }
        }
    }
    //Available Status
    public void Available(int profile, ArrayList<Local> localList){
         while(true) {
             String status;
             if (((Driver) localList.get(profile)).isAvailable()) {
                 status = "Online";
             } else status = "Offline";
             System.out.println("Your current status :" + status);
             System.out.println("press 1 to change status\npress 2 to exit");
             int option = sc.nextInt();
             sc.nextLine();
             if (option == 1) {
                 ((Driver) localList.get(profile)).setAvailable(!((Driver) localList.get(profile)).isAvailable());
             } else if (option == 2)
                 break;
         }
    }
}