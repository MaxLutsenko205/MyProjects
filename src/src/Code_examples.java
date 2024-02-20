import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Code_examples {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

/*
        Ternary operator:

        variable = (condition)?true result:false result;
        int a = 4;
        String output = (a % 2 == 0) ? "even" : "odd";
        System.out.println(output);
*/

        /*Switch cases

        switch (variable) {
          case condition -> result;
          case condition -> result;
          default -> result;
        }*/
        /*int x = s.nextInt();
        int y = s.nextInt();
        String text = s.next();
        switch (text) {
            case "+" -> System.out.println(x+y);
            case "-" -> System.out.println(x-y);
            case "*" -> System.out.println(x*y);
            case "/" -> System.out.println(x/y);
            default -> System.out.println("Invalid operator");
        }*/

/*      public class Main(){

            static void staticMethod(){}
            public void publicMethod(){}

            public static void main(String[] args){
           -We can call static method without creating an object-
                staticMethod();
           -But we can't call public method without an object-
                Main myFile = new Main();
                myFile.publicMethod();
            }
        }
*/


//        GUI in Java
//
//        We can use swing or JavaFX packages
//        import javax.swing.JOptionPane;

//        Exceptions (try/catch)
        /*String[] arr = new String[2];
        arr[0] = "Hello";
        arr[1] = "World";
        try {           // code with expected exception
            System.out.println(arr[2]);
        }
        catch (Exception e) {       // commit if exception error is found
            System.out.println("There is no needed element");
            System.out.println("Your exception: "+e);
        }
        finally {           // anyway commit in the end
            System.out.println("Try again");
        }

        if (arr[0].equals("Hello")){
            throw new SecurityException("Wrong word");  // creating exception and changing its content
        }
        else {
            System.out.println("OK");
        }*/


//        Files
//        -To work with files you need import package classes:
//        import java.io.File;
//        -To write into files:
//        import java.io.FileWriter;
//        -To catch exceptions related with file:
//        import java.io.IOException;
//        -To catch exceptions related with file reading:
//        import java.io.FileNotFoundException;

//        creating file
        /*try {
            File myFile = new File("file_name.txt");    //creating an object with path where file will be created
            if (myFile.createNewFile()){    //creating a file
                System.out.println("File created: "+ myFile.getName()); //if file created
            }
            else {
                System.out.println("File already created"); //if this file already exist
            }
        }
        catch (IOException e){  // if we have error with file creating
            System.out.println("Something wrong");
            e.printStackTrace();
        }*/

//        write into file
        /*try {
            FileWriter fileToWrite = new FileWriter("file_name.txt");   //opening or creating file for writing
            fileToWrite.write(s.nextLine());    // write something to file
            fileToWrite.close();    // closing the file, necessary!
        }
        catch (IOException e){
            System.out.println("Something wrong");
            e.printStackTrace();
        }*/

//        read from file
        /*try {
            File myFile = new File("file_name.txt");
            Scanner reader = new Scanner(myFile);   // creating reader as Scanner object
            while (reader.hasNextLine()){   // go through lines in a file
                String data = reader.nextLine();    // write data from file into variable
                System.out.println(data);   // show data in terminal
            }
            reader.close(); // close file, necessary!
        }
        catch (FileNotFoundException e){
            System.out.println("Something wrong");
            e.printStackTrace();
        }*/

//        some info about file
        /*File myFile = new File("file_name.txt");
        if (myFile.exists()) {
            System.out.println("File name: " + myFile.getName());
            System.out.println("Absolute path: " + myFile.getAbsolutePath());
            System.out.println("Writeable: " + myFile.canWrite());
            System.out.println("Readable " + myFile.canRead());
            System.out.println("File size in bytes " + myFile.length());
        } else {
            System.out.println("The file does not exist.");
        }*/

//        file deleting
        /*File myFile = new File("file_name.txt");
        if (myFile.delete()){
            System.out.println("File deleted: "+myFile.getName());
        }
        else {
            System.out.println("Something wrong");
        }*/

    }
}