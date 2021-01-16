import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.Thread.*;
public class extra implements feature{
    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public void sleepSec(long sec){
        try {
            sleep(sec * 100);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void loading(String s) {
        for( int i = 0 ; i < 0 ; i++ ) {
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
        public void write(ArrayList<Account> cars){
            try{
                FileOutputStream writeData = new FileOutputStream("cars.bat");
                ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

                writeStream.writeObject(cars);
                writeStream.flush();
                writeStream.close();
                System.out.println("data save successfully");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public ArrayList<Account> read(){
            ArrayList<Account> cars = null;
            try{
                FileInputStream readData = new FileInputStream("cars.bat");
                ObjectInputStream readStream = new ObjectInputStream(readData);

                cars = (ArrayList<Account>) readStream.readObject();
                readStream.close();
                System.out.println("File loaded successfully");
            }catch (Exception e) {
                e.printStackTrace();
            }
            return cars;
        }
        public Account defaultAccount(int i) {
        if (i == 1) {
            Account r = new Rider();
            r.setFirstName("Default ");
            r.setLastName("Rider");
            r.setEmail("dr@gmail.com");
            r.setPhoneNo(1550032232);
            r.setPassWord("Password");
            r.setVerification(true);
            r.setRating(5);
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
    public int Int() {
        Scanner sc = new Scanner(System.in);
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
