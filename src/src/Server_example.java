import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_example {

    public static void main(String[] args) throws IOException {
        Socket socket = null;
        InputStreamReader inputStreamReader = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        ServerSocket serverSocket = null;

        serverSocket = new ServerSocket(999);
        while (true){

            socket = serverSocket.accept();

            inputStreamReader = new InputStreamReader(socket.getInputStream());
            outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());

            bufferedWriter = new BufferedWriter(outputStreamWriter);
            bufferedReader = new BufferedReader(inputStreamReader);

            while (true){

                String messageFromClient = bufferedReader.readLine();
                System.out.println("Client: "+messageFromClient);

                bufferedWriter.write("Message received!");
                bufferedWriter.newLine();
                bufferedWriter.flush();

                if (messageFromClient.equals("BYE")){
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
}
