import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;
public class Main {
    public static void main(String[] args)  throws IOException {

//        Variables:
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Scanner s = new Scanner(System.in);
        boolean inProcess = true; //need for body work
        boolean clientExist = false; //need to verification
        int id = 0;
        int newId = 0;
        ArrayList<Client> clients = new ArrayList<>();
        String request = null;
        boolean running = true;
        Recorder recorder = new Recorder(); // for recording all actions(changes)

//        Introduction
        System.out.println("========== ATM MACHINE ==========");
        System.out.println("For using machine write needed request:\n");

        while (running) {
            while (!clientExist) {

                System.out.println("If you are new client - \"reg\"\n" +
                        "If you already have account - \"log\"\n" +
                        "To stop program - \"stop\"");
                request = bufferedReader.readLine();

                switch (request) {
//                      Client registration
                    case "reg" -> {
                        System.out.print("Please write your first name: ");
//                        String name = s.next();
                        String name = bufferedReader.readLine();
                        System.out.print("Please write your second name: ");
                        String lname = bufferedReader.readLine();
                        System.out.print("Password(greater than 5 characters): ");
                        boolean available = false;
                        String password = null;
                        while (!available) {
                            password = bufferedReader.readLine();
                            if (password.length() > 5) {
                                available = true;
                            } else {
                                System.out.print("Too short, write again: ");
                            }
                        }
                        clients.add(new Client(newId, name, lname, password));
                        System.out.println("New client registered!");
                        id = newId;
                        newId++; //id for next client

                        clientExist = true;     // end registration
                        inProcess = true;
                        recorder.recordToFile("Was registered a new client: "+name+" "+lname); // recording
                    }

//                      client log in
                    case "log" -> {
                        System.out.print("Your first name: ");
                        String name = bufferedReader.readLine();
                        System.out.print("Your second name: ");
                        String lname = bufferedReader.readLine();
                        System.out.print("Password: ");
                        String password = bufferedReader.readLine();
                        boolean exist = false;
                        for (Client client : clients)       // checking if client exist in database
                        {
                            if (name.equals(client.getName()) && lname.equals(client.getLname()) &&
                                    password.equals(client.getPassword())) {
                                id = client.getId();
                                exist = true;
                                break;
                            }
                        }
                        if (!exist) {
                            System.out.println("Invalid name or password!");
                            recorder.recordToFile("Log in error!");
                        } else {
                            clientExist = true; //end of verification if data is correct
                            inProcess = true;
                            recorder.recordToFile("Client logged in: "+name+" "+lname); // recording
                        }
                    }
//                    program stopping
                    case "stop" -> {
                        running = false;
                        clientExist = true;
                        inProcess = false;
                        recorder.recordToFile("Program is stopped");
                    }
                    default -> System.out.println("Invalid request!");
                }
            }


            //        Machine body
            if (inProcess){
                System.out.println("To show commands - \"info\"");
            }
            while (inProcess) {
                request = bufferedReader.readLine(); //entering a command
                switch (request) {
                    case "info" -> {
                        System.out.println("  *Show account information - \"show\"\n" +
                            "  *Deposit money - \"in\"\n" +
                            "  *Take money back - \"out\"\n" +
                            "  *Log out - \"exit\"\n");
                    }
                    case "in" -> {
                        System.out.print("What amount you want to put: ");
                        float amount = Float.parseFloat(bufferedReader.readLine());
                        clients.get(id).setMoneyIntoBill(amount);
                    }
                    case "out" -> {
                        System.out.print("What amount you want to get: ");
                        float amount = Float.parseFloat(bufferedReader.readLine());
                        clients.get(id).getMoneyFromBill(amount);
                    }
                    case "show" -> System.out.println(clients.get(id).getClientInfo());
                    case "exit" -> {
                        inProcess = false;
                        clientExist = false;
                        recorder.recordToFile("Client "+clients.get(id).getName()+" "+clients.get(id).getLname()
                        +" logged out");
                    }
                    default -> System.out.println("Incorrect request! Please try again");
                }

            }
        }
        recorder.stopWriting();
        bufferedReader.close();
    }

}
