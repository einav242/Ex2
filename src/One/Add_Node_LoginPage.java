package One;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Add_Node_LoginPage implements ActionListener {
        JFrame frame = new JFrame();
        JButton loginButton = new JButton("add");
        //JButton loginButton = new JButton("Back");

        JTextField userIDField = new JTextField();
        JPasswordField userPasswordField = new JPasswordField();

        JLabel userIDLabel = new JLabel("Node: ");
        JLabel messageLabel = new JLabel();

        Add_Node_LoginPage()
        {

            //  loginInfo = loginInfoOriginal;

            userIDLabel.setBounds(50,100,75,25);


            messageLabel.setBounds(125,250,250,35);
            messageLabel.setFont(new Font(null, Font.ITALIC,25));

            userIDField.setBounds(125,100,200,25);

            loginButton.setBounds(225,200,100,25);
            loginButton.setFocusable(false);
            loginButton.addActionListener(this);

            frame.add(userIDLabel);
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

        }
}
