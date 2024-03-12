public class LoginInterface {

    public static void main(String[] args){

        Storage clientsInfo = new Storage();
        VerificationPage VerificationPage = new VerificationPage(clientsInfo.getClientsData());
    }
}
