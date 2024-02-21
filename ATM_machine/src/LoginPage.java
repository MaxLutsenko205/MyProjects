import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class LoginPage implements ActionListener {
    HashMap<String,String> accountsInfo = new HashMap<String,String>();
    JFrame loginFrame = new JFrame(); // adding main interface window
    JLabel idLabel = new JLabel("Login:");   // creating some text
    JLabel passwordLabel = new JLabel("Password:");
    JTextField idField = new JTextField(); // creating a field for text
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("Confirm"); //creating a button
    JLabel text = new JLabel();

//    using database from Storage class
    LoginPage(HashMap<String,String> accountsInfo){
        this.accountsInfo = accountsInfo;

        loginFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // configure main interface window
        loginFrame.setSize(400,500);
        loginFrame.setLayout(null);
        loginFrame.setVisible(true);

        idLabel.setBounds(75, 100, 85, 25); // text settings
        passwordLabel.setBounds(75,150, 85, 25);

        idField.setBounds(150, 100, 125, 25); // text field settings
        passwordField.setBounds(150, 150, 125, 25);

        loginButton.setBounds(150, 200, 100, 25); // button settings
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);

        text.setBounds(100,225, 200, 25);
        text.setHorizontalAlignment(JLabel.CENTER);

        loginFrame.add(idLabel); // adding elements into the frame
        loginFrame.add(passwordLabel);
        loginFrame.add(passwordField);
        loginFrame.add(idField);
        loginFrame.add(loginButton);
        loginFrame.add(text);

    }


//    checking any actions performing in the frame with ActionListener class
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==loginButton){
            String id = idField.getText();
            String password = String.valueOf(passwordField.getPassword());
            if (accountsInfo.containsKey(id)){
                if (accountsInfo.get(id).equals(password)){
                    text.setForeground(Color.GREEN);
                    text.setText("Success!");
                    AccountPage accountPage = new AccountPage();
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
    }
}
