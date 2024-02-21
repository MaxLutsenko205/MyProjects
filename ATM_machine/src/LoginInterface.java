public class LoginInterface {

    public static void main(String[] args){

        Storage clientsInfo = new Storage();
        LoginPage loginPage = new LoginPage(clientsInfo.getClientsData());

    }
}
