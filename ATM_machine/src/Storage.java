import java.util.HashMap;

public class Storage {
    HashMap<String,String> clientsData = new HashMap<String,String>();

    Storage (){
        clientsData.put("Max L", "123456");
        clientsData.put("Arman I", "000000");
        clientsData.put("Ivan S", "qwerty");
    }

    protected HashMap<String,String> getClientsData(){
        return clientsData;
    }
}
