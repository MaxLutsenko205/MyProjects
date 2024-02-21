// this class perform a database functions using HashMap
import java.util.HashMap;

public class Storage {
    HashMap<String,String> clientsData = new HashMap<String,String>();

    Storage (){
        clientsData.put("Max L", "123456");
        clientsData.put("Arman I", "000000");
        clientsData.put("Ivan S", "qwerty");
    }

//    method for conveying the database into LoginPage
    protected HashMap<String,String> getClientsData(){
        return clientsData;
    }
}
