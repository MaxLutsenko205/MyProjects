import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class AccountPage implements ActionListener {
    Storage storage = new Storage();
    JFrame accountFrame = new JFrame();
    JLabel helloLabel = new JLabel();
    JButton infoButton = new JButton("Info");
    JButton logoutButton = new JButton("Logout");

    AccountPage(String name){
        accountFrame.setSize(400,500);
        accountFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        accountFrame.setLayout(null);
        accountFrame.setVisible(true);

        helloLabel.setText("Hello "+name);
        helloLabel.setBounds(0, 50, 400, 25);
        helloLabel.setHorizontalAlignment(JLabel.CENTER);

        infoButton.setBounds(25, 425, 100, 25);
        infoButton.setFocusable(false);
        infoButton.addActionListener(this);
        logoutButton.setBounds(125, 425, 100, 25);
        logoutButton.setFocusable(false);
        logoutButton.addActionListener(this);

        accountFrame.add(helloLabel);
        accountFrame.add(infoButton);
        accountFrame.add(logoutButton);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==infoButton){
            // getting information about clint from database (name, bill)
            infoButton.setBackground(Color.CYAN);
        }
        else if (e.getSource()==logoutButton) {
            VerificationPage verificationPage = new VerificationPage(storage.getClientsData());
            accountFrame.dispose();
        }
    }
}
