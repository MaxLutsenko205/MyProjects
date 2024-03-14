import java.sql.*;
import java.util.TreeSet;

public class Database {

    private Connection connection;
    Statement statement;
    private String sql;


    public Database(){
        try{
//            database connection
            String url = "jdbc:postgresql://localhost:5433/ATM";
            String name = "postgres";
            String password = "0000";
            connection = DriverManager.getConnection(url, name, password);
            statement = connection.createStatement();
        } catch (SQLException e){
            e.getStackTrace();
        }
    }

    public String getClientData(int id){
        String sql = "SELECT * FROM clients_info WHERE personid="+id;
        String clientData = "";
        try {
            ResultSet rs = statement.executeQuery(sql);
        while (rs.next()){
            int personid = rs.getInt("personid");
            String firstName = rs.getString("firstname");
            String secondName = rs.getString("lastname");
            String clientPassword = rs.getString("clientpassword");
            int account = rs.getInt("account");
            clientData = (personid+": "+firstName+" "+secondName+" "+clientPassword+" "+account);
        }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return clientData;
    }

    public int addClient(String firstName, String secondName, String clientPassword) throws SQLException {
        int newClientID=-1;
        TreeSet<Integer> clientsIDs = new TreeSet<>();
        boolean exists = false;
        String newClientData = firstName+" "+secondName;
        ResultSet resultSet = statement.executeQuery("SELECT * FROM clients_info");
        while (resultSet.next()) {
            int clientID = resultSet.getInt("personid");
            clientsIDs.add(clientID);
            String fn = resultSet.getString("firstname");
            String sn = resultSet.getString("lastname");
            String clientData = (fn+" "+sn);
            if (newClientData.equals(clientData)){
                exists = true;
                break;
            }
        }
//        add person if he not exists in database
        if (!exists){
            newClientID = clientsIDs.last()+1;
            sql = "INSERT INTO clients_info VALUES ("+newClientID+", '"+firstName+"', '"+secondName+"', '"+clientPassword+"', "+0+")";
            try {
                statement.executeUpdate(sql);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return newClientID;
    }

    public int clientExistence(String firstName, String secondName, String password) throws SQLException {
        int currentID = -1;
        String currentClientData = firstName+" "+secondName+" "+password;
        ResultSet resultSet = statement.executeQuery("SELECT * FROM clients_info");
        while (resultSet.next()) {
            int id = resultSet.getInt("personid");
            String fn = resultSet.getString("firstname");
            String sn = resultSet.getString("lastname");
            String pass = resultSet.getString("clientpassword");
            String clientData = (fn+" "+sn+" "+pass);
            if (currentClientData.equals(clientData)){
                currentID = id;
            }
        }
        return currentID;
    }

    public void putInAccount(int id, int amount) throws SQLException {
        sql = "UPDATE clients_info SET account="+amount+" WHERE personid="+id;
        statement.executeUpdate(sql);
        System.out.println("Account is updated!");
    }

    public boolean outFromAccount(int id, int amount) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT account FROM clients_info WHERE personid="+id);
        resultSet.next();
        int availableAmount = resultSet.getInt("account");
        if (availableAmount>=amount) {
            sql = "UPDATE clients_info SET account=" + (availableAmount-amount) + " WHERE personid=" + id;
            statement.executeUpdate(sql);
            return true;
        }
        return false;
    }
    public void connectionClose(){
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
