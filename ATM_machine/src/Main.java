import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {

//        Variables:
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        boolean inProcess = false; //need for body work
        boolean clientExist = false; //need to verification
        int id = 0;
        int newId = 0;

        List<Client> clients = new ArrayList<>();
        Database database = new Database();

        String request = null;

//        Introduction
        System.out.println("========== ATM MACHINE ==========");
        System.out.println("For using machine write needed request:\n");

        while (true) {
            while (!clientExist) {

                System.out.println("""
                        If you are new client - "reg"
                        If you already have account - "log"
                        To stop program - "stop\"""");
                request = bufferedReader.readLine();

                switch (request) {
//                      Client registration
                    case "reg" -> {
                        System.out.print("Please write your first name: ");
                        String name = bufferedReader.readLine();
                        System.out.print("Please write your second name: ");
                        String lname = bufferedReader.readLine();
                        System.out.print("Password(greater than 5 characters): ");
                        boolean available = false;
                        String password = null;
//                        checking password length
                        while (!available) {
                            password = bufferedReader.readLine();
                            if (password.length() > 5) {
                                available = true;
                            } else {
                                System.out.print("Too short, write again: ");
                            }
                        }
//                        write new client into database
//                        clients.add(new Client(newId, name, lname, password));
                        database.addClient(name, lname, password);
                        id = newId;
                        newId++; //id for next client

                        clientExist = true;     // end registration
                        inProcess = true;
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
                        } else {
                            clientExist = true; //end of verification if data is correct
                            inProcess = true;
                        }
                    }
//                    program stopping
                    case "stop" -> {
                        bufferedReader.close();
                        database.connectionClose();
                        System.exit(-1);
                    }
                    default -> System.out.println("Invalid request!");
                }
            }


            //        Machine body
            System.out.println("To show commands - \"info\"");
            while (inProcess) {
                request = bufferedReader.readLine(); //entering a command
                switch (request) {
                    case "info" -> {
                        System.out.println("""
                                  *Show account information - "show"
                                  *Deposit money - "in"
                                  *Take money back - "out"
                                  *Log out - "exit"
                                """);
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
                    }
                    default -> System.out.println("Incorrect request! Please try again");
                }

            }
        }
    }

}
