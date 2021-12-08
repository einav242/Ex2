package api.One;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Connect_T_Node_LoginPage implements ActionListener {
    JFrame frame = new JFrame();
    JButton loginButton = new JButton("Connect");
    JButton BackButton = new JButton("Back");

    JTextField srcIDField = new JTextField();
    JTextField destIDField = new JTextField();
    JTextField intIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();

    JLabel srcIDLabel = new JLabel("Src: ");
    JLabel destIDLabel = new JLabel("Dest: ");
    JLabel intIDLabel = new JLabel("Int: ");
    JLabel messageLabel = new JLabel();


    Connect_T_Node_LoginPage()
    {

        JLabel lblAdminLoginForm = new JLabel("Choose your choice:");
        lblAdminLoginForm.setBounds(45,50,300,25);
        lblAdminLoginForm.setForeground(Color.red);
        lblAdminLoginForm.setFont(new Font("Tacoma", Font.PLAIN, 16));

        //  loginInfo = loginInfoOriginal;

        srcIDLabel.setBounds(50,100,75,25);
        destIDLabel.setBounds(50,150,75,25);
        intIDLabel.setBounds(50,200,75,25);

        messageLabel.setBounds(125,250,250,35);
        messageLabel.setFont(new Font(null, Font.ITALIC,25));

        srcIDField.setBounds(125,100,200,25);
        destIDField.setBounds(125,150,200,25);
        intIDField.setBounds(125,200,200,25);

        loginButton.setBounds(225,250,100,25);
        loginButton.setFocusable(false);
     //   loginButton.addActionListener(this);

        BackButton.setBounds(100,250,100,25);
        BackButton.setFocusable(false);

        frame.add(lblAdminLoginForm);
        frame.add(srcIDLabel);
        frame.add(BackButton);
        frame.add(destIDField);
        frame.add(intIDField);
        frame.add(destIDLabel);
        frame.add(intIDLabel);
        frame.add(messageLabel);
        frame.add(srcIDField);
        frame.add(userPasswordField);
        frame.add(loginButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == BackButton){
            frame.dispose();
            //EditG well = new EditG();
        }
        else{
            messageLabel.setForeground(Color.red);
            messageLabel.setText("Not Good");
        }
    }
}
