package One;
import api.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.JFrame;

import javax.swing.*;


public class Show  extends JFrame implements ActionListener{
    DWGraph graph;
    myPanel panel;
    JButton backButton = new JButton("Back");

    public Show(DirectedWeightedGraph g ,LinkedList<NodeData>l)
    {
        this.graph=new DWGraph(g);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.panel=new myPanel(graph,l);
        this.add(panel);
        this.pack();
        this.setLayout(null);
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
//        if(e.getSource() == backButton)
//        {
//            this.dispose();
//            myGraph idPasswords = new myGraph();
//            LoginPage l=new LoginPage(graph);
//        }
    }
}
