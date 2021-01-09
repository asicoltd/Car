import java.util.*;

public interface feature {
    String filepath="SaveFile.bat";
    void clearScreen();
    void sleepSec( long sec );
    void loading(String s);
    void WriteObjectToFile(ArrayList<Local> accounts);
    ArrayList<Local> ReadObjectFromFile(String filepath);
}