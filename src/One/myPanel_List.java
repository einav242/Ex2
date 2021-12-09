package One;

import api.DWGraph;
import api.DirectedWeightedGraph;
import api.EdgeData;
import api.NodeData;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

    public class myPanel_List extends JPanel {
        DWGraph graph;
        LinkedList<NodeData> l;
        myPanel_List(DirectedWeightedGraph graph ,LinkedList<NodeData>l) {
            this.graph=new DWGraph(graph);
            this.setPreferredSize(new Dimension(420,420));
            this.l=l;

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
                    if(l.contains(this.graph.getNode(i)) && l.contains(this.graph.getNode(j)))
                    {

                    }

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


