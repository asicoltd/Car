import java.util.*;

public interface feature {
    void clearScreen();
    void sleepSec( long sec );
    void loading(String s);
    ArrayList<Local> read();
    void writeFile(ArrayList<Local> list);
    ArrayList<Local> saveLoad();
    int Int();
}