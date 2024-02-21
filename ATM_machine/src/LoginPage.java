import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class LoginPage implements ActionListener {
    HashMap<String,String> accountsInfo = new HashMap<String,String>();
    JFrame loginFrame = new JFrame();
    JLabel idLabel = new JLabel("Login:");
    JLabel passwordLabel = new JLabel("Password:");
    JTextField idField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("Confirm");
    JLabel text = new JLabel();
    LoginPage(HashMap<String,String> accountsInfo){
        this.accountsInfo = accountsInfo;

        loginFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        loginFrame.setSize(400,500);
        loginFrame.setLayout(null);
        loginFrame.setVisible(true);

        idLabel.setBounds(75, 100, 85, 25);
        passwordLabel.setBounds(75,150, 85, 25);

        idField.setBounds(150, 100, 125, 25);
        passwordField.setBounds(150, 150, 125, 25);

        loginButton.setBounds(150, 200, 100, 25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);

        text.setBounds(100,225, 200, 25);
        text.setHorizontalAlignment(JLabel.CENTER);

        loginFrame.add(idLabel);
        loginFrame.add(passwordLabel);
        loginFrame.add(passwordField);
        loginFrame.add(idField);
        loginFrame.add(loginButton);
        loginFrame.add(text);

    }

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
