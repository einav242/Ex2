package One;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class Use_Algo_LoginPage implements ActionListener {
    JFrame frame = new JFrame();
    JButton initButton = new JButton("Init");
    JButton getGButton = new JButton("Get Graph");
    JButton copyButton = new JButton("Copy");
    JButton ConnButton = new JButton("check Is Your Graph Connected ? ");
    JButton PathDistButton = new JButton("Short Test PathDist");
    JButton PathButton = new JButton("Short Test Path");
    JButton centerButton = new JButton("center");
    JButton tspButton = new JButton("TSP");

    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel messageLabel = new JLabel();


    Use_Algo_LoginPage() {

        JLabel lblAdminLoginForm = new JLabel("Choose your choice:");
        lblAdminLoginForm.setBounds(99,25,300,25);
        lblAdminLoginForm.setForeground(Color.red);
        lblAdminLoginForm.setFont(new Font("Tacoma", Font.PLAIN, 18));

        initButton.setBounds(100,50,200,25);
        initButton.setFocusable(false);
        initButton.addActionListener(this);

        getGButton.setBounds(100,80,200,25);
        getGButton.setFocusable(false);
        getGButton.addActionListener(this);

        copyButton.setBounds(100,110,200,25);
        copyButton.setFocusable(false);
        copyButton.addActionListener(this);

        ConnButton.setBounds(100,140,200,25);
        ConnButton.setFocusable(false);
        ConnButton.addActionListener(this);

        PathDistButton.setBounds(100,170,200,25);
        PathDistButton.setFocusable(false);
        PathDistButton.addActionListener(this);

        PathButton.setBounds(100,200,200,25);
        PathButton.setFocusable(false);
        PathButton.addActionListener(this);

        centerButton.setBounds(100,230,200,25);
        centerButton.setFocusable(false);
        centerButton.addActionListener(this);

        tspButton.setBounds(100,260,200,25);
        tspButton.setFocusable(false);
        tspButton.addActionListener(this);

        frame.add(lblAdminLoginForm);
        frame.add(tspButton);
        frame.add(centerButton);
        frame.add(PathButton);
        frame.add(PathDistButton);
        frame.add(ConnButton);
        frame.add(getGButton);
        frame.add(copyButton);
        frame.add(messageLabel);
        frame.add(userIDField);
        frame.add(userPasswordField);
        frame.add(initButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == initButton){
            frame.dispose();
            Init_LoginPage in = new Init_LoginPage();
        }
        if (e.getSource() == PathDistButton){
            frame.dispose();
            Short_Test_PathDist_LoginPage s = new Short_Test_PathDist_LoginPage();
        }
        if (e.getSource() == PathButton){
            frame.dispose();
            Short_Test_Path_LoginPage sp = new Short_Test_Path_LoginPage();
        }
        if (e.getSource() == tspButton){
            frame.dispose();
            TSP_LoginPage tsp = new TSP_LoginPage();
        }
    }
}
