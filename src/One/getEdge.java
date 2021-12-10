package One;

import api.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class getEdge implements ActionListener {
    DWGraph graph;
    JFrame frame = new JFrame();
    JButton loginButton = new JButton("enter");
    JButton backButton = new JButton("Back");

    JTextField Field1 = new JTextField();
    JTextField Field2 = new JTextField();

    JLabel srcLabel = new JLabel("src: ");
    JLabel destLabel = new JLabel("dest: ");
    JLabel messageLabel = new JLabel();


    getEdge(DirectedWeightedGraph graph)
    {
        this.graph=new DWGraph(graph);
        srcLabel.setBounds(50,100,75,25);
        destLabel.setBounds(50,150,75,25);

        messageLabel.setBounds(125,250,250,35);
        messageLabel.setFont(new Font(null, Font.ITALIC,25));

        Field1.setBounds(125,100,200,25);
        Field2.setBounds(125,150,200,25);

        backButton.setBounds(300,50,100,25);
        backButton.setFocusable(false);
        backButton.addActionListener(this);

        loginButton.setBounds(225,200,100,25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);

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
        if (e.getSource() == loginButton && (Field1.getText().isEmpty() || Field2.getText().isEmpty()))
        {
            frame.dispose();
            getEdge n=new getEdge(this.graph);
        }
        else if(e.getSource() == loginButton) {
            int src=Integer.parseInt(Field1.getText());
            int dest=Integer.parseInt(Field2.getText());
            frame.dispose();
            result_screen s;
            if(this.graph.getNode(src)==null && this.graph.getNode(dest)==null)
            {
                s = new result_screen(this.graph,"the node is not in the graph","",null,Color.red);
            }
            else if(!this.graph.getEdges().get(src).containsKey(dest))
            {
                s = new result_screen(this.graph,"the edge is not in the graph", "",null,Color.red);
            }
            else {
                EdgeData ed=this.graph.getEdge(src,dest);
                String src1=Integer.toString(ed.getSrc());
                String dest1=Double.toString(ed.getDest());
                String w=Double.toString(ed.getWeight());
                s = new result_screen(this.graph,"src: "+src1+", "+"dest: "+dest1+", "+"weigh: "+w, "",null,Color.blue);
            }
        }
        if(e.getSource() == backButton) {
            frame.dispose();
            LoginPage l;
            l = new LoginPage(this.graph);
        }
    }
}






