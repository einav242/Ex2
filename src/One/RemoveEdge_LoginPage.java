package One;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class RemoveEdge_LoginPage implements ActionListener {

    JFrame frame = new JFrame();
    JButton loginButton = new JButton("remove");

    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();

    JLabel userIDLabel = new JLabel("Src: ");
    JLabel userPasswordLabel = new JLabel("Dest: ");
    JLabel messageLabel = new JLabel();

    HashMap<Integer,Integer> loginInfo = new HashMap<Integer,Integer>();

     RemoveEdge_LoginPage() {

       //  loginInfo = loginInfoOriginal;

         userIDLabel.setBounds(50,100,75,25);
         userPasswordLabel.setBounds(50,150,75,25);

         messageLabel.setBounds(125,250,250,35);
         messageLabel.setFont(new Font(null, Font.ITALIC,25));

         userIDField.setBounds(125,100,200,25);
         userPasswordField.setBounds(125,150,200,25);

         loginButton.setBounds(225,200,100,25);
         loginButton.setFocusable(false);
         loginButton.addActionListener(this);

         frame.add(userIDLabel);
         frame.add(userPasswordLabel);
         frame.add(messageLabel);
         frame.add(userIDField);
         frame.add(userPasswordField);
         frame.add(loginButton);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setSize(420,420);
         frame.setLayout(null);
         frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         /*
        if (e.getSource() == resetButton) {
            userIDField.setText("");
            userPasswordField.setText("");
        }

        if (e.getSource() == loginButton) {
            String userID = userIDField.getText();
            String password = String.valueOf(userPasswordField.getPassword());

            if (loginInfo.containsKey(userID)){
                if(loginInfo.get(userID).equals(password)) {
                    messageLabel.setForeground(Color.green);
                    messageLabel.setText("Login successful");
                    frame.dispose();
                    WelcomePage wel = new WelcomePage(userID);
                }
                else{
                    messageLabel.setForeground(Color.red);
                    messageLabel.setText("Wrong password");
                }
            }
            else {
                messageLabel.setForeground(Color.red);
                messageLabel.setText("username not found");
            }

        }*/
    }
}
