package One;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import api.*;
public class result_screen implements ActionListener {
    DWGraph graph;
    JFrame frame = new JFrame();
    JLabel messageLabel = new JLabel();
    JButton backButton = new JButton("Back");

    result_screen(DirectedWeightedGraph graph, String text, int key)
    {
        this.graph=new DWGraph(graph);
        messageLabel.setBounds(75,100,300,35);
        messageLabel.setFont(new Font(null, Font.ITALIC,25));
        if(key==1) {
            messageLabel.setForeground(Color.green);
        }
        else {
            messageLabel.setForeground(Color.red);
        }
        messageLabel.setText(text);

        backButton.setBounds(300,50,100,25);
        backButton.setFocusable(false);
        backButton.addActionListener(this);

        frame.add(messageLabel);
        frame.add(backButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.dispose();
        IDanPasswords idPasswords = new IDanPasswords();
        LoginPage l=new LoginPage(idPasswords.getLoginInfo(),graph);
        }
    }


