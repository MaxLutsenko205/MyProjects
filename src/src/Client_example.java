import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client_example {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost", 999);   // creating a socket for connect to server

        InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream()); // for take information from server
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());  // for send information to server

        BufferedReader bufferedReader = new BufferedReader(inputStreamReader); // improving streams with buffered classes
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

        Scanner s = new Scanner(System.in); // for catching user inputs
        while (true){

            String message = s.nextLine();

            bufferedWriter.write(message);  // writing message for send it to server
            bufferedWriter.newLine(); // adding \n into message
            bufferedWriter.flush(); // for immediate writing data

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
