package One;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import api.*;
public class WelcomePage implements ActionListener {
    DWGraph graph;
    JFrame frame = new JFrame();
    JLabel welcomeLabel = new JLabel("Hi bar");
    JButton loginButton = new JButton("start");


        WelcomePage(){
        welcomeLabel.setBounds(0,0,200,35);
        welcomeLabel.setFont(new Font(null,Font.PLAIN,25));
        welcomeLabel.setText("Hello " );

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
    WelcomePage(DirectedWeightedGraph graph)
    {
        this.graph=new DWGraph(graph);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() ==loginButton)
        {
            IDanPasswords idPasswords = new IDanPasswords();
            LoginPage loginPage = new LoginPage(idPasswords.getLoginInfo(),graph);
        }
    }
}
