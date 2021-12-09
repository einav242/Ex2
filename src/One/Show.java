package One;
import api.*;
import java.awt.*;
import java.util.LinkedList;
import javax.swing.JFrame;

import javax.swing.*;


public class Show  extends JFrame{
    DWGraph graph;
    myPanel panel;
    myPanel_List panel_list;
    public Show(DirectedWeightedGraph g , String text, LinkedList<NodeData>l)
    {

        this.graph=new DWGraph(g);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        if(text=="list")
        {
            this.panel_list= new myPanel_List(graph,l);
            this.add(panel_list);
        }
        else {
            this.panel=new myPanel(graph);
            this.add(panel);
        }
        this.pack();
        this.setLayout(null);
        this.setVisible(true);
    }


}
