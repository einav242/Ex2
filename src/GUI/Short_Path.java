package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.LinkedList;

import api.*;
public class Short_Path implements ActionListener {
    GraphAlgo algo;
    JFrame frame = new JFrame();
    JButton loginButton = new JButton("enter");
    JButton backButton = new JButton("Back");

    JTextField Field1 = new JTextField();
    JTextField Field2 = new JTextField();

    JLabel srcLabel = new JLabel("Src: ");
    JLabel destLabel = new JLabel("Dest: ");
    JLabel messageLabel = new JLabel();

    HashMap<Integer,Integer> loginInfo = new HashMap<Integer,Integer>();

    Short_Path(GraphAlgo algo) {

        this.algo=algo;

        srcLabel.setBounds(50,100,75,25);
        destLabel.setBounds(50,150,75,25);

        messageLabel.setBounds(125,250,250,35);
        messageLabel.setFont(new Font(null, Font.ITALIC,25));

        Field1.setBounds(125,100,200,25);
        Field2.setBounds(125,150,200,25);

        loginButton.setBounds(225,200,100,25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);

        backButton.setBounds(300,50,100,25);
        backButton.setFocusable(false);
        backButton.addActionListener(this);

        frame.add(srcLabel);
        frame.add(destLabel);
        frame.add(messageLabel);
        frame.add(Field1);
        frame.add(Field2);
        frame.add(loginButton);
        frame.add(backButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);
    }


        @Override
    public void actionPerformed(ActionEvent e) {
            result_screen s;
            if(e.getSource()==loginButton && (Field1.getText().isEmpty() || Field2.getText().isEmpty()))
        {
            frame.dispose();
            Short_Path sh=new Short_Path(this.algo);
        }
        else if(e.getSource()==loginButton)
        {
            int src = Integer.parseInt(Field1.getText());
            int dest = Integer.parseInt(Field2.getText());
            frame.dispose();
            if(this.algo.getGraph().getNode(src)==null || this.algo.getGraph().getNode(dest)==null)
            {
                s = new result_screen(this.algo.getGraph(),"the node is not in the graph", "",null,Color.red);
            }
            else {
                LinkedList<NodeData> l1 = (LinkedList<NodeData>) this.algo.shortestPath(src,dest);
                frame.dispose();
                Show show=new Show(this.algo.getGraph(),l1,-1);
            }
        }
            if(e.getSource() == backButton)
            {
                frame.dispose();
                LoginPage l=new LoginPage(this.algo.getGraph());
            }

    }
}
