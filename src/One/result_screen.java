package One;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import api.*;
public class result_screen implements ActionListener {
    DWGraph graph;
    JFrame frame = new JFrame();
    JLabel messageLabel = new JLabel();
    JButton backButton = new JButton("Back");
    String goTo;
    LinkedList<NodeData>l;

    result_screen(DirectedWeightedGraph graph, String text, int key, String goTo, LinkedList<NodeData>l)
    {
        this.graph=new DWGraph(graph);
        this.goTo=goTo;
        this.l=l;
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
        if (this.goTo == "tsp") {
            frame.dispose();
            GraphAlgo g = new GraphAlgo(this.graph);
            TSP t = new TSP(g, l);
        } else {
            frame.dispose();
            myGraph idPasswords = new myGraph();
            LoginPage l = new LoginPage(graph);
        }
    }

    }


