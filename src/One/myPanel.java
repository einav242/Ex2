package One;

import api.*;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.LinkedList;

public class myPanel extends JPanel {
    DWGraph graph;
    LinkedList<NodeData> l;
    double s_x;
    double s_y;
    DecimalFormat df2;
    myPanel(DirectedWeightedGraph graph ,LinkedList<NodeData>l) {
         this.df2 = new DecimalFormat("#.##");
        this.setPreferredSize(new Dimension(900,900));
        this.graph=new DWGraph(graph);
        double min_x=min_x();
        double min_y=min_y();
        double max_x=max_x();
        double max_y=max_y();
        double abs_x=Math.abs(max_x-min_x);
        double abs_y=Math.abs(max_y-min_y);
        System.out.println(abs_x);
        this.s_x=(900/abs_x);
        this.s_y=(900/abs_y);
        this.l=l;
    }
    public void paint(Graphics g)
    {
        Graphics2D graphics2D= (Graphics2D)g;
        for(int i : this.graph.getEdges().keySet())
        {
            for(int j: this.graph.getEdges().get(i).keySet())
            {
                EdgeData e=this.graph.getEdge(i,j);
                NodeData n_src=this.graph.getNode(i);
                int x1= (int) ((n_src.getLocation().x()-min_x())*this.s_x);
                int y1= (int) ((n_src.getLocation().y()-min_y())*this.s_y);
                NodeData n_dest=this.graph.getNode(j);
                int x2= (int) ((n_dest.getLocation().x()-min_x())*this.s_x);
                int y2= (int) ((n_dest.getLocation().y()-min_y())*this.s_y);
                if(l.contains(this.graph.getNode(i)) && l.contains(this.graph.getNode(j)))
                {
                    graphics2D.setStroke(new BasicStroke(5));
                    graphics2D.setPaint(Color.red);
                }
                else{
                    graphics2D.setStroke(new BasicStroke(0));
                    graphics2D.setPaint(Color.BLACK);
                }
                graphics2D.drawLine(x1,y1,x2,y2);
                if(e.getTag()==-1) {
                    graphics2D.setPaint(Color.red);
                    graphics2D.setStroke(new BasicStroke(3));
                    graphics2D.drawString(df2.format(e.getWeight()), (x1 + x2) / 2, (y1 + y2) / 2);
                    graphics2D.setStroke(new BasicStroke(0));
                    e.setTag(0);
                }
            }
        }
        for (int i: this.graph.getNodes().keySet())
        {
            NodeData n=this.graph.getNode(i);
            int x= (int) ((n.getLocation().x()-min_x())*this.s_x);
            int y= (int) ((n.getLocation().y()-min_y())*this.s_y);
            graphics2D.setPaint(Color.BLUE);
            graphics2D.drawRect(x-10,y-10,20,20);
            graphics2D.drawString(""+i,x-2,y+5);
        }
    }
    private double min_x()
    {
        double min=Double.MAX_VALUE;
        int ans=-1;
        for(int i: this.graph.getNodes().keySet())
        {
            if(this.graph.getNode(i).getLocation().x()<min)
            {
                min=this.graph.getNode(i).getLocation().x();
            }
        }
        return min;
    }
    private double min_y()
    {
        double min=Double.MAX_VALUE;
        for(int i: this.graph.getNodes().keySet())
        {
            if(this.graph.getNode(i).getLocation().y()<min)
            {
                min=this.graph.getNode(i).getLocation().y();
            }
        }
        return min;
    }
    private double max_x()
    {
        double max=Double.MIN_VALUE;
        for(int i: this.graph.getNodes().keySet())
        {
            if(this.graph.getNode(i).getLocation().x()>max)
            {
                max=this.graph.getNode(i).getLocation().x();
            }
        }
        return max;
    }
    private double max_y()
    {
        double max=Double.MIN_VALUE;
        for(int i: this.graph.getNodes().keySet())
        {
            if(this.graph.getNode(i).getLocation().y()>max)
            {
                max=this.graph.getNode(i).getLocation().y();
            }
        }
        return max;
    }
}


