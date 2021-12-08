package One;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TSP_LoginPage implements ActionListener {

    JFrame frame = new JFrame();
    JButton removeButton = new JButton("remove");
    //  JButton loginButton = new JButton("Back");

    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();

    JLabel citiesLabel = new JLabel("cities: ");
    JLabel messageLabel = new JLabel();


   TSP_LoginPage()
    {

        //  loginInfo = loginInfoOriginal;

        citiesLabel.setBounds(50,100,75,25);


        messageLabel.setBounds(125,250,250,35);
        messageLabel.setFont(new Font(null, Font.ITALIC,25));

        userIDField.setBounds(125,100,200,25);

        removeButton.setBounds(225,200,100,25);
        removeButton.setFocusable(false);
        removeButton.addActionListener(this);

        frame.add(citiesLabel);
        frame.add(messageLabel);
        frame.add(userIDField);
        frame.add(userPasswordField);
        frame.add(removeButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
