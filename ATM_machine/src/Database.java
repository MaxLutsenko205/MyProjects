import java.sql.*;

public class Database {

    private Connection connection;
    Statement statement;
    private String sql;
    public Database(){
        try{
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
    public void addClient(int id, String firstName, String secondName, String clientPassword){
        sql = "INSERT INTO clients_info VALUES ("+id+ ", '" +firstName+"', '"+secondName+"', '"+clientPassword+"', "+0+")";
        try {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
