import java.sql.*;

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

    // need to add if statement to check whether client exist or not
    public void addClient(String firstName, String secondName, String clientPassword) throws SQLException {
        int newClientID=0;
        boolean exists = false;
        String newClientData = firstName+" "+secondName;
        ResultSet resultSet = statement.executeQuery("SELECT * FROM clients_info");
        while (resultSet.next()) {
            newClientID = resultSet.getInt("personid");
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
            sql = "INSERT INTO clients_info VALUES ("+(newClientID+1)+", '"+firstName+"', '"+secondName+"', '"+clientPassword+"', "+0+")";
            try {
                statement.executeUpdate(sql);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            System.out.println("New client registered!");
        } else {
            System.out.println("Client already exists!");
        }
    }

    public boolean clientExistence(String firstName, String secondName, String password) throws SQLException {
        String currentClientData = firstName+" "+secondName+" "+password;
        ResultSet resultSet = statement.executeQuery("SELECT * FROM clients_info");
        while (resultSet.next()) {
            String fn = resultSet.getString("firstname");
            String sn = resultSet.getString("lastname");
            String pass = resultSet.getString("clientpassword");
            String clientData = (fn+" "+sn+" "+pass);
            if (currentClientData.equals(clientData)){
                return true;
            }
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

//    sql = "UPDATE clients_info SET clientpassword='999999' WHERE personid=3";
}
