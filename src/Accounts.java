import java.io.*;
import java.util.ArrayList;

    public class Accounts {
        void write(ArrayList<Local> cars){
            try{
                FileOutputStream writeData = new FileOutputStream("cars.bat");
                ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

                writeStream.writeObject(cars);
                writeStream.flush();
                writeStream.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        ArrayList<Local> read(){
            ArrayList<Local> cars = null;
            try{
                FileInputStream readData = new FileInputStream("cars.bat");
                ObjectInputStream readStream = new ObjectInputStream(readData);

                cars = (ArrayList<Local>) readStream.readObject();
                readStream.close();
                System.out.println("File loaded successfully");
            }catch (Exception e) {
                e.printStackTrace();
            }
            return cars;
        }
    }
