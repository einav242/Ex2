package GUI;

import api.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.LinkedList;

public class myPanel extends JPanel{
    DWGraph graph;
    LinkedList l;
    double s_x;
    double s_y;
    DecimalFormat df2;

    myPanel(DirectedWeightedGraph graph, LinkedList l) {
        this.df2 = new DecimalFormat("#.##");
        this.setPreferredSize(new Dimension(800, 800));
        this.graph = new DWGraph(graph);
        double min_x = min_x();
        double min_y = min_y();
        double max_x = max_x();
        double max_y = max_y();
        double abs_x = Math.abs(max_x - min_x);
        double abs_y = Math.abs(max_y - min_y);
        this.s_x = (800 / abs_x);
        this.s_y = (800 / abs_y);
        this.l = l;
    }

    public void paint(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;
        for (int i : this.graph.getEdges().keySet()) {
            for (int j : this.graph.getEdges().get(i).keySet()) {
                EdgeData e = this.graph.getEdge(i, j);
                NodeData n_src = this.graph.getNode(i);
                int x1 = (int) ((n_src.getLocation().x() - min_x()) * this.s_x);
                int y1 = (int) ((n_src.getLocation().y() - min_y()) * this.s_y);
                NodeData n_dest = this.graph.getNode(j);
                int x2 = (int) ((n_dest.getLocation().x() - min_x()) * this.s_x);
                int y2 = (int) ((n_dest.getLocation().y() - min_y()) * this.s_y);
                if (l!=null && l.contains( this.graph.getNode(i)) && l.contains((this.graph.getNode(j))))
                {
                    graphics2D.setStroke(new BasicStroke(5));
                    graphics2D.setPaint(Color.red);
                }
                else {
                    graphics2D.setStroke(new BasicStroke(0));
                    graphics2D.setPaint(Color.BLACK);
                }
                g.drawLine(x1, y1, x2, y2);
                if (n_src.getTag() == 0 && n_dest.getTag() == 0) {
                    graphics2D.setPaint(Color.red);
                    graphics2D.setStroke(new BasicStroke(3));
                    graphics2D.drawString(df2.format(e.getWeight()), (x1 + x2) / 2, (y1 + y2) / 2);
                    graphics2D.setStroke(new BasicStroke(0));
                    n_src.setTag(n_src.getTag() + 1);
                    n_dest.setTag(n_dest.getTag() + 1);
                }
                else {
                    graphics2D.setPaint(Color.red);
                    graphics2D.setStroke(new BasicStroke(3));
                    int sum = 10*(n_src.getTag() + n_dest.getTag());
                    graphics2D.drawString(df2.format(e.getWeight()), (x1 + x2 - sum) / 2, (y1 + y2-sum) / 2);
                    graphics2D.setStroke(new BasicStroke(0));
                    n_src.setTag(n_src.getTag() + 1);
                    n_dest.setTag(n_dest.getTag() + 1);
                }
            }
        }
            for (int i : this.graph.getNodes().keySet()) {
                NodeData n = this.graph.getNode(i);
                int x = (int) ((n.getLocation().x() - min_x()) * this.s_x);
                int y = (int) ((n.getLocation().y() - min_y()) * this.s_y);
                graphics2D.setPaint(Color.BLUE);
                graphics2D.setStroke(new BasicStroke(3));
                graphics2D.drawOval(x-3 , y-3 , 10, 10);
                graphics2D.setStroke(new BasicStroke(3));
                graphics2D.drawString("" + i, x - 8, y + 15);
                String x_loc=Double.toString(n.getLocation().x());
                String y_loc=Double.toString(n.getLocation().y());
                String z_loc=Double.toString(n.getLocation().z());
                graphics2D.setPaint(Color.green);
                graphics2D.drawString("("+x_loc + ","+y_loc+","+z_loc+")", x+3, y+15 );
            }
    }
        private double min_x()
        {
            double min = Double.MAX_VALUE;
            int ans = -1;
            for (int i : this.graph.getNodes().keySet()) {
                if (this.graph.getNode(i).getLocation().x() < min) {
                    min = this.graph.getNode(i).getLocation().x();
                }
            }
            return min;
        }
        private double min_y ()
        {
            double min = Double.MAX_VALUE;
            for (int i : this.graph.getNodes().keySet()) {
                if (this.graph.getNode(i).getLocation().y() < min) {
                    min = this.graph.getNode(i).getLocation().y();
                }
            }
            return min;
        }
        private double max_x ()
        {
            double max = Double.MIN_VALUE;
            for (int i : this.graph.getNodes().keySet()) {
                if (this.graph.getNode(i).getLocation().x() > max) {
                    max = this.graph.getNode(i).getLocation().x();
                }
            }
            return max;
        }
        private double max_y ()
        {
            double max = Double.MIN_VALUE;
            for (int i : this.graph.getNodes().keySet()) {
                if (this.graph.getNode(i).getLocation().y() > max) {
                    max = this.graph.getNode(i).getLocation().y();
                }
            }
            return max;
        }

}



