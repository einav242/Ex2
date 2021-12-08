package api.One;
import api.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Scanner;

public class Remove_Node implements ActionListener {
    DWGraph graph;
    JFrame frame = new JFrame();
    JButton loginButton = new JButton("remove");
  //  JButton loginButton = new JButton("Back");

    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();

    JLabel userIDLabel = new JLabel("Node: ");
    JLabel messageLabel = new JLabel();
    Scanner sc=new Scanner(System.in);
    int key=sc.nextInt();
    

    Remove_Node(DirectedWeightedGraph graph)
    {
        this.graph=new DWGraph(graph);
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
        if(e.getSource() == loginButton)
        {
            if(this.graph.getNodes().containsKey(this.key))
            {
                this.graph.removeNode(this.key);
                messageLabel.setForeground(Color.red);
                messageLabel.setText("Wrong password");
            }

        }
    }
}
