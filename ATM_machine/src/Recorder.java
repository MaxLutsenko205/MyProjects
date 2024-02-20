//this class should record all actions from application, like a history list
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
public class Recorder {
    FileWriter writer = new FileWriter("ATM_machine\\records.txt");
    File history = new File("ATM_machine\\records.txt");
//    constructor
    public Recorder() throws IOException {
        history.createNewFile();

    }

    public void recordToFile(String message) throws IOException {
        PrintWriter print = new PrintWriter(writer);
        print.println("-"+message);
    }

    public void stopWriting() throws IOException {writer.close();}
}
