import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class VerificationPage implements ActionListener {
    HashMap<String,String> accountsInfo = new HashMap<String,String>();
    JFrame loginFrame = new JFrame(); // adding main interface window
    JLabel idLabel = new JLabel("User name:");   // creating some text
    JLabel passwordLabel = new JLabel("Password:");
    JTextField idField = new JTextField(); // creating a field for text
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("Login"); //creating a button
    JButton registerButton = new JButton("Register");
    JLabel text = new JLabel();

//    using database from Storage class
    VerificationPage(HashMap<String,String> accountsInfo){
        this.accountsInfo = accountsInfo;

        loginFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // configure main interface window
        loginFrame.setSize(400,500);
        loginFrame.setLayout(null);
        loginFrame.setVisible(true);

        idLabel.setBounds(75, 100, 85, 25); // text settings
        passwordLabel.setBounds(75,150, 85, 25);

        idField.setBounds(150, 100, 125, 25); // text field settings
        passwordField.setBounds(150, 150, 125, 25);

        loginButton.setBounds(75, 200, 100, 25); // button settings
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);
        registerButton.setBounds(175, 200, 100, 25);
        registerButton.setFocusable(false);
        registerButton.addActionListener(this);

        text.setBounds(75,225, 200, 25);
//        text.setHorizontalAlignment(JLabel.CENTER);

        loginFrame.add(idLabel); // adding elements into the frame
        loginFrame.add(passwordLabel);
        loginFrame.add(passwordField);
        loginFrame.add(idField);
        loginFrame.add(loginButton);
        loginFrame.add(registerButton);
        loginFrame.add(text);

    }


//    checking any actions performing in the frame with ActionListener class
    @Override
    public void actionPerformed(ActionEvent e) {

        String id = idField.getText();
        String password = String.valueOf(passwordField.getPassword());

        if (e.getSource()==loginButton){
            if (accountsInfo.containsKey(id)){
                if (accountsInfo.get(id).equals(password)){
                    text.setForeground(Color.GREEN);
                    text.setText("Success!");
                    AccountPage accountPage = new AccountPage(id);
                    loginFrame.dispose();
                }
                else {
                    text.setForeground(Color.RED);
                    text.setText("Invalid password!");
                }
            }
            else {
                text.setForeground(Color.RED);
                text.setText("Name not found!");
            }
        }
        else if (e.getSource()==registerButton) {
            if (accountsInfo.containsKey(id)){
                text.setForeground(Color.RED);
                text.setText("Account already exist!");
            }
            else{
                // record Name and Password into database and go to account page
//                Storage storage = new Storage();
//                storage.setClientData(id, password);
//                AccountPage accountPage = new AccountPage(id);
//                loginFrame.dispose();
            }
        }
    }
}
