import com.sun.source.tree.WhileLoopTree;

import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args){

//        Variables:
        Scanner s = new Scanner(System.in);
        boolean inProcess = true; //need for body work
        boolean clientExist = false; //need to verification
        int id = 0;
        int newId = 0;
        ArrayList<Client> clients = new ArrayList<>();
        String request = null;
        boolean running = true;

//        Introduction
        System.out.println("========== ATM MACHINE ==========");
        System.out.println("For using machine write needed request:\n");

        while (running) {
            while (!clientExist) {

                System.out.println("If you are new client - \"reg\"\n" +
                        "If you already have account - \"log\"\n" +
                        "To stop program - \"stop\"");
                request = s.next();

                switch (request) {
//                      Client registration
                    case "reg" -> {
                        System.out.print("Please write your first name: ");
                        String name = s.next();
                        System.out.print("Please write your second name: ");
                        String lname = s.next();
                        System.out.print("Password(greater than 5 characters): ");
                        boolean available = false;
                        String password = null;
                        while (!available) {
                            password = s.next();
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
                    }

//                      client log in
                    case "log" -> {
                        System.out.print("Your first name: ");
                        String name = s.next();
                        System.out.print("Your second name: ");
                        String lname = s.next();
                        System.out.print("Password: ");
                        String password = s.next();
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
                        running = false;
                        clientExist = true;
                        inProcess = false;
                    }
                    default -> System.out.println("Invalid request!");
                }
            }


            //        Machine body
            while (inProcess) {
                System.out.println("  *Show account information - \"show\"\n" +
                        "  *Deposit money - \"in\"\n" +
                        "  *Take money back - \"out\"\n" +
                        "  *Log out - \"exit\"\n");
                request = s.next(); //entering a command
                switch (request) {
                    case "in" -> {
                        System.out.print("What amount you want to put: ");
                        float amount = s.nextFloat();
                        clients.get(id).setMoneyIntoBill(amount);
                    }
                    case "out" -> {
                        System.out.print("What amount you want to get: ");
                        float amount = s.nextFloat();
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
