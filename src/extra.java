import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

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
    public static final String filepath="SaveFile.bat";
    public void WriteObjectToFile(ArrayList<Local> accounts) {
        try {

            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(accounts);
            objectOut.close();
            System.out.println("Accounts Saved Successfully");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public ArrayList<Local> ReadObjectFromFile(String filepath) {
        try {

            FileInputStream fileIn = new FileInputStream(filepath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            ArrayList<Local> obj = (ArrayList<Local>) objectIn.readObject();
            objectIn.close();
            return obj;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    }
