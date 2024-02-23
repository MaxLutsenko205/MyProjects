import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.stream.Stream;

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
//        import java.io.FileWriter;s
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

//        generics
        /*With generics you can give any type of variable into object
        public class Printer <T>{
          public T data;
          public Printer (T data){
              this.data = data
              System.out.println(data);
          }
        }
          In main class
        Printer<Integer> printer = new Printer<>(23);
        Printer<String> printer = new Printer<>("Hello");*/


//        casting

//        double a = 2.4;
//        int b = (int)a;

//        class A{}
//        class B extends A{}
//        A obj = (A) new B(); // upcasting
//        B obj1 = (B) obj; // downcasting


        //        Threads
//        allow you to run different processes at the same time
        /*public static class A extends Thread {
            public void show() throws InterruptedException { // exception for sleep method
                System.out.println("class A");
                Thread.sleep(10); // method for stopping thread for defined period (10 millis)
            }
        }
        public static class B extends Thread {
            public void show() {
                System.out.println("class B");
            }
        }
//        in the main class
        A a = new A();
        B b = new B();
        b.setPriority(Thread.MAX_PRIORITY); // set max priority via constant
        a.setPriority(6); // setting priority 6 (from 1 to 10)
        a.start();  //starting executing a thread A
        b.start();  //starting executing a thread B

        public synchronized void methodName(){}   // synchronized key word allow to use method by terns when 2 or more threads are processing
        */


//        Anonymous inner class
//        also works with abstract class
        /*class A{
            public void show(){
                System.out.println("it is the method");
            }
        }
        A obj = new A(){    // creating an anonymous class in the process of creating object
            public void show(){
                System.out.println("it is the anonymous class");
            }
        };
        obj.show();*/


//        Interfaces need to predefine or design classes
//        -methods in interface have public abstract type
//        -variables in interface have final static(use without object) type


//        Lambda expression method
//        @FunctionalInterface // annotation uses for determine your intention
//        interface A{
//          void add(int a, int b);
//        }
//        A obj = (int a, int b) -> System.out.println(a+b); // Lambda expression uses for fast creating methods
//        obj.add(3,5);


//    Streams need to operate with data and they uses only ones in running time
//        List<Integer> l = Arrays.asList(1, 20, 5, 3, 6, 4);     // creating a list
//        Stream<Integer> s1 = l.stream();    // converting a list into stream
//        Stream<Integer> s2 = s1.filter(n -> n%2!=0);    // using stream filter method(lambda expression in parentheses)
//        s2.forEach(System.out::println);    // using forEach loop for printing the values
//        // or
//        int result = l.stream()     //converting into stream
//                .filter(n -> n%2==0)    // filtering only even numbers
//                .map(n -> n*3)      // changing the values
//                .reduce(0, (c,e) -> c+e);   // sum of the values
//        System.out.println(result);
    }
}

