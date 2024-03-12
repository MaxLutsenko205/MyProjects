// this class perform a database functions using HashMap
import java.util.HashMap;

public class Storage {
    HashMap<String,String> clientsData = new HashMap<>();

    Storage (){
        clientsData.put("Maxim", "123456");
        clientsData.put("Arman", "000000");
        clientsData.put("Ivan", "qwerty");
    }

//    method for conveying the database into LoginPage
    protected HashMap<String,String> getClientsData(){
        return clientsData;
    }

//    protected void setClientData(String id, String password){
//        clientsData.put(id, password);
//    }
}
