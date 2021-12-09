package One;

import api.DWG_deserializer;

import javax.swing.*;
import java.awt.*;
import api.*;

public class myPanel extends JPanel {
    DWGraph graph;
    myPanel(DirectedWeightedGraph graph) {
        this.graph=new DWGraph(graph);
    this.setPreferredSize(new Dimension(420,420));
    }
    public void paint(Graphics g)
    {
        Graphics2D graphics2D= (Graphics2D)g;
        for(int i : this.graph.getEdges().keySet())
        {
            for(int j: this.graph.getEdges().get(i).keySet())
            {
                EdgeData e=this.graph.getEdges().get(i).get(j);
                NodeData n_src=this.graph.getNode(i);
                double x1=n_src.getLocation().x();
                double y1=n_src.getLocation().y();
                NodeData n_dest=this.graph.getNode(j);
                double x2=n_dest.getLocation().x();
                double y2=n_dest.getLocation().y();

            }
        }
        for (int i: this.graph.getNodes().keySet())
        {
            NodeData n=this.graph.getNode(i);
            double x=n.getLocation().x();
            double y=n.getLocation().y();
        }

    }

}
