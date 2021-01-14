import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.Thread.*;
public class extra implements feature{
    ArrayList<Local> localList = new ArrayList<>();
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
    public ArrayList<Local> saveLoad(){
        try {
            File myObj = new File(filepath);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
                localList.add(defaultAccount(1));
                localList.add(defaultAccount(2));
            } else {
                localList =  read();
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
    public static final String filepath="SaveFile.bat";
    static class AppendableObjectOutputStream extends ObjectOutputStream {
        public AppendableObjectOutputStream(OutputStream out) throws IOException {
            super(out);
        }

        @Override
        protected void writeStreamHeader() throws IOException {
        }
    }
    public void writeFile(ArrayList<Local> list)
    {
        try{
            File file = new File(filepath);
            boolean append = file.exists();
            ObjectOutputStream f;
            FileOutputStream fout;
            if(append)
            {
                fout= new FileOutputStream(file,true);
                f = new AppendableObjectOutputStream(fout);
            }
            else{
                fout= new FileOutputStream(file,true);
                f = new ObjectOutputStream(fout);
            }
            f.writeObject(list);
            f.flush();
            f.close();
            fout.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public ArrayList<Local> read() {
        try{
            FileInputStream fin = new FileInputStream(filepath);
            ObjectInputStream f1 = new   ObjectInputStream(fin);
            try{
                    ArrayList<Local> List= (ArrayList<Local>) f1.readObject();
                    return List;
            }
            catch(EOFException e)
            {

            }
            f1.close();
            fin.close();
            System.out.println("\n Success.......");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return null;
    }
    public int Int() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                return sc.nextInt();
            } catch (InputMismatchException e) {
                sc.next();
                System.out.println("Please enter an integer.");
            }
        }
    }
    }
