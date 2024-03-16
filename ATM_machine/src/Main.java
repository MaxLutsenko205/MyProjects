import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {

//        Variables:
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        boolean inProcess = false; //need for body work
        boolean inVerification = true; //need to verification
        int id = -1; // current client's id

        Database database = new Database();

        String request;

//        Introduction
        System.out.println("========== ATM MACHINE ==========");
        System.out.println("For using machine write needed request:\n");

        while (true) {
//            client verification
            while (inVerification) {

                System.out.println("""
                        If you are new client - "reg"
                        If you already have account - "log"
                        To stop program - "stop\"""");
                request = bufferedReader.readLine();

                switch (request) {
//                      client registration
                    case "reg" -> {
                        System.out.print("Please write your first name: ");
                        String name = bufferedReader.readLine();
                        System.out.print("Please write your second name: ");
                        String lName = bufferedReader.readLine();
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
                        id = database.addClient(name, lName, password);
                        if (id>=0) {
                            System.out.println("New client registered!");
                            inVerification = false;     // end registration
                            inProcess = true;
                        } else{
                            System.out.println("Client already exists!");
                        }
                    }

//                      client log in
                    case "log" -> {
                        System.out.print("Your first name: ");
                        String name = bufferedReader.readLine();
                        System.out.print("Your second name: ");
                        String lName = bufferedReader.readLine();
                        System.out.print("Password: ");
                        String password = bufferedReader.readLine();
                        if(database.clientExistence(name, lName, password)>=0){
                            id = database.clientExistence(name, lName, password); // return client id from database
                            inProcess = true;
                            inVerification = false;
                            System.out.println("Success!");
                        } else{
                            System.out.println("Invalid name or password!");
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


            // Account interface
            System.out.println("To show commands - \"info\"");
            while (inProcess) {
                request = bufferedReader.readLine(); //entering a command
                switch (request) {
                    case "info" -> System.out.println("""
                              *Show account information - "show"
                              *Deposit money - "in"
                              *Take money back - "out"
                              *Log out - "exit"
                            """);
                    case "in" -> {
                        System.out.print("What amount you want to put: ");
                        int amount = Integer.parseInt(bufferedReader.readLine());
                        database.putInAccount(id, amount);
                    }
                    case "out" -> {
                        System.out.print("What amount you want to get: ");
                        int amount = Integer.parseInt(bufferedReader.readLine());
                        if (database.outFromAccount(id, amount)){
                            System.out.println("Success!");
                        } else {
                            System.out.println("Not enough money!");
                        }
                    }
                    case "show" -> System.out.println(database.getClientData(id));
                    case "exit" -> {
                        inProcess = false;
                        inVerification = true;
                    }
                    default -> System.out.println("Incorrect request! Please try again");
                }

            }
        }
    }

}
