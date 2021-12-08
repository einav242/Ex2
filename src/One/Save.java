package One;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import api.*;
public class Save implements ActionListener {
    DWGraph graph;
    JFrame frame = new JFrame();
    JButton loginButton = new JButton("enter");
    //  JButton loginButton = new JButton("Back");

    JTextField Field = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();

    JLabel userIDLabel = new JLabel("Name File: ");
    JLabel messageLabel = new JLabel();


    Save(DirectedWeightedGraph graph)
    {

        //  loginInfo = loginInfoOriginal;
        this.graph=new DWGraph(graph);
        userIDLabel.setBounds(50,100,75,25);


        messageLabel.setBounds(125,250,250,35);
        messageLabel.setFont(new Font(null, Font.ITALIC,25));

        Field.setBounds(125,100,200,25);

        loginButton.setBounds(225,200,100,25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);

        frame.add(userIDLabel);
        frame.add(messageLabel);
        frame.add(Field);
        frame.add(userPasswordField);
        frame.add(loginButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == loginButton)
        {
            GraphAlgo algo=new GraphAlgo(this.graph);
            String file=Field.getText();
            algo.save(file);
        }
    }
}
