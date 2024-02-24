import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_example {

    public static void main(String[] args) throws IOException {
        Socket socket = null;

        InputStreamReader inputStreamReader = null;
        OutputStreamWriter outputStreamWriter = null;

        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        ServerSocket serverSocket = new ServerSocket(999);

        while (true){

            socket = serverSocket.accept();

//            InetAddress address = socket.getLocalAddress();

            inputStreamReader = new InputStreamReader(socket.getInputStream());
            outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());

            bufferedWriter = new BufferedWriter(outputStreamWriter);
            bufferedReader = new BufferedReader(inputStreamReader);

            while (true){

                String messageFromClient = bufferedReader.readLine();
                if (socket.getLocalAddress().getHostAddress().equals("localhost2")){
                    System.out.println("Client2: "+messageFromClient);
                } else{
                    System.out.println("Client: "+messageFromClient);
                }

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
