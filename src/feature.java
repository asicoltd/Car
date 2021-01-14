import java.util.ArrayList;

public interface feature {
    void clearScreen();
    void sleepSec( long sec );
    void loading(String s);
    int Int();
    ArrayList<Account> read();
    void write(ArrayList<Account> cars);
}