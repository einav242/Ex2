package One;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Init_LoginPage implements ActionListener {

    JFrame frame = new JFrame();
    JButton enterButton = new JButton("enter");
    //  JButton loginButton = new JButton("Back");

    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();

    JLabel init_G_Label = new JLabel("init graph: ");
    JLabel messageLabel = new JLabel();


    Init_LoginPage()
    {

        //  loginInfo = loginInfoOriginal;

        init_G_Label.setBounds(50,100,75,25);


        messageLabel.setBounds(125,250,250,35);
        messageLabel.setFont(new Font(null, Font.ITALIC,25));

        userIDField.setBounds(125,100,200,25);

        enterButton.setBounds(225,200,100,25);
        enterButton.setFocusable(false);
        enterButton.addActionListener(this);

        frame.add(init_G_Label);
        frame.add(messageLabel);
        frame.add(userIDField);
        frame.add(userPasswordField);
        frame.add(enterButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
