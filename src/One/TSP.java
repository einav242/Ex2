package One;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import api.*;
public class TSP implements ActionListener {
    GraphAlgo algo;
    LinkedList<NodeData> l;
    JFrame frame = new JFrame();
    JButton loginButton = new JButton("finish");
    JButton backButton = new JButton("Back");
    JButton nextButton = new JButton("add Node");

    JTextField Field1 = new JTextField();
    JTextField Field2 = new JTextField();
    JTextField Field3 = new JTextField();
    JTextField Field4 = new JTextField();

    JLabel idLabel = new JLabel("id: ");
    JLabel locationLabel = new JLabel("location: ");
    JLabel xLabel = new JLabel("x: ");
    JLabel yLabel = new JLabel("y: ");
    JLabel zLabel = new JLabel("z: ");
    JLabel messageLabel = new JLabel();
    JLabel error_m = new JLabel();

    HashMap<Integer, Integer> loginInfo = new HashMap<Integer, Integer>();

    TSP(GraphAlgo algo,LinkedList<NodeData> l) {
        this.algo = algo;
        this.l=l;
        idLabel.setBounds(50, 100, 75, 25);
        locationLabel.setBounds(50, 150, 75, 25);
        xLabel.setBounds(110, 150, 75, 25);
        yLabel.setBounds(110, 175, 75, 25);
        zLabel.setBounds(110, 200, 75, 25);


        messageLabel.setBounds(125, 250, 250, 35);
        messageLabel.setFont(new Font(null, Font.ITALIC, 25));


        Field1.setBounds(125, 100, 200, 25);
        Field2.setBounds(125, 150, 100, 25);
        Field3.setBounds(125, 175, 100, 25);
        Field4.setBounds(125, 200, 100, 25);

        loginButton.setBounds(225, 300, 100, 25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);


        backButton.setBounds(300, 50, 100, 25);
        backButton.setFocusable(false);
        backButton.addActionListener(this);

        nextButton.setBounds(75, 300, 100, 25);
        nextButton.setFocusable(false);
        nextButton.addActionListener(this);


        frame.add(idLabel);
        frame.add(locationLabel);
        frame.add(xLabel);
        frame.add(yLabel);
        frame.add(zLabel);
        frame.add(messageLabel);
        frame.add(Field1);
        frame.add(Field2);
        frame.add(Field3);
        frame.add(Field4);
        frame.add(loginButton);
        frame.add(backButton);
        frame.add(nextButton);
        frame.add(error_m);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nextButton) {
            int id = Integer.parseInt(Field1.getText());
            double x = Double.parseDouble(Field2.getText());
            double y = Double.parseDouble(Field3.getText());
            double z = Double.parseDouble(Field4.getText());
            GeoLocation location = new Location(x, y, z);
            NodeData nodeData = new Node(id, location);
            frame.dispose();
            result_screen s;
            if (this.algo.getGraph().getNode(id) == null) {
                s = new result_screen(this.algo.getGraph(),"the node is not in the graph", 0,"tsp",this.l);
            }
            else {
                this.l.add(nodeData);
                s = new result_screen(this.algo.getGraph(), "the node is added to the list", 1, "tsp", this.l);
            }
        }
        if(e.getSource() == loginButton)
        {
            frame.dispose();
            result_screen s;
            if(this.l.size()==0)
            {
                s = new result_screen(this.algo.getGraph(),"the list is empty", 0,"tsp",this.l);
            }
            else if(this.algo.tsp(this.l)==null)
            {
                s = new result_screen(this.algo.getGraph(),"the node are not connected", 0,"tsp",this.l);
            }
            else {
                LinkedList<NodeData> l1 = (LinkedList<NodeData>) this.algo.tsp(this.l);
                frame.dispose();
                Show show=new Show(this.algo.getGraph(),"list",l1);
            }
        }
    }
}


