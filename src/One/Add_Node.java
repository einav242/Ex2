package One;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import api.*;
public class Add_Node implements ActionListener {
    DWGraph graph;
    JFrame frame = new JFrame();
    JButton loginButton = new JButton("enter");
    JButton backButton = new JButton("Back");

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

    HashMap<Integer, Integer> loginInfo = new HashMap<Integer, Integer>();

    Add_Node(DirectedWeightedGraph graph) {
        this.graph = new DWGraph(graph);
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

        loginButton.setBounds(225, 210, 100, 25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);

        backButton.setBounds(300, 50, 100, 25);
        backButton.setFocusable(false);
        backButton.addActionListener(this);

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
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            int id = Integer.parseInt(Field1.getText());
            double x = Double.parseDouble(Field2.getText());
            double y = Double.parseDouble(Field3.getText());
            double z = Double.parseDouble(Field4.getText());
            GeoLocation location=new Location(x,y,z);
            NodeData nodeData=new Node(id,location);
            this.graph.addNode(nodeData);
            frame.dispose();
            result_screen s;
                if(this.graph.getNodes().containsKey(id)) {
                    s = new result_screen(this.graph,"the node added", 1);
                }
                else
                {
                    s = new result_screen(this.graph,"try again!", 0);
                }
            }
            if (e.getSource() == backButton) {
                frame.dispose();
                EditG well = new EditG(this.graph);
            }
        }
    }

