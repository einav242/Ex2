package GUI;
import api.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.JFrame;

import javax.swing.*;


public class Show  extends JFrame implements ActionListener{
    DWGraph graph;
    myPanel panel;
    JButton backButton = new JButton("Back");

    public Show(DirectedWeightedGraph g ,LinkedList l)
    {
        this.graph=new DWGraph(g);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.panel=new myPanel(graph,l);
        backButton.setBounds(500,30,65,25);
        backButton.setFocusable(false);
        backButton.addActionListener(this);
        this.add(backButton);
        this.add(panel);
        this.pack();
        this.setLayout(null);
        this.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == backButton)
        {
            this.dispose();
            LoginPage l=new LoginPage(graph);
        }
    }
}
