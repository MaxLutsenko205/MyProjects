import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client_example {
    public static void main(String[] args) throws IOException {

        Socket socket = null;
        InputStreamReader inputStreamReader = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        socket = new Socket("localhost", 999);

        inputStreamReader = new InputStreamReader(socket.getInputStream());
        outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());

        bufferedReader = new BufferedReader(inputStreamReader);
        bufferedWriter = new BufferedWriter(outputStreamWriter);

        Scanner s = new Scanner(System.in);
        while (true){

            String message = s.nextLine();

            bufferedWriter.write(message);
            bufferedWriter.newLine();
            bufferedWriter.flush();

            System.out.println(bufferedReader.readLine());

            if (message.equals("BYE")){
                break;
            }
        }
        socket.close();
        inputStreamReader.close();
        outputStreamWriter.close();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
