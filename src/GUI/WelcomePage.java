package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import api.*;
public class WelcomePage implements ActionListener {
    DWGraph graph;
    JFrame frame = new JFrame();
    JLabel welcomeLabel = new JLabel("welcome!");
    JButton loginButton = new JButton("start");
    HashMap<Integer,Integer> loginInfo = new HashMap<Integer,Integer>();


    WelcomePage(HashMap<Integer,Integer> loginInfoOriginal, DirectedWeightedGraph graph){
        this.graph=new DWGraph(graph);
        loginInfo = loginInfoOriginal;
        welcomeLabel.setBounds(150,100,500,35);
        welcomeLabel.setFont(new Font(null,Font.PLAIN,45));
        welcomeLabel.setForeground(Color.orange);


        loginButton.setBounds(225,200,100,25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);

        frame.add(loginButton);
        frame.add(welcomeLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() ==loginButton)
        {
            frame.dispose();
            LoginPage loginPage = new LoginPage(graph);
        }
    }
}
