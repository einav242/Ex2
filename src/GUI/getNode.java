package GUI;

import api.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    public class getNode implements ActionListener {
        DWGraph graph;
        JFrame frame = new JFrame();
        JButton loginButton = new JButton("enter");
        JButton backButton = new JButton("Back");

        JTextField Field = new JTextField();

        JLabel userIDLabel = new JLabel("Node key: ");
        JLabel messageLabel = new JLabel();


        getNode(DirectedWeightedGraph graph)
        {
            this.graph=new DWGraph(graph);
            userIDLabel.setBounds(50,100,75,25);

            messageLabel.setBounds(125,250,250,35);
            messageLabel.setFont(new Font(null, Font.ITALIC,25));

            Field.setBounds(125,100,200,25);

            backButton.setBounds(300,50,100,25);
            backButton.setFocusable(false);
            backButton.addActionListener(this);

            loginButton.setBounds(225,200,100,25);
            loginButton.setFocusable(false);
            loginButton.addActionListener(this);

            frame.add(userIDLabel);
            frame.add(messageLabel);
            frame.add(Field);
            frame.add(loginButton);
            frame.add(backButton);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(420,420);
            frame.setLayout(null);
            frame.setVisible(true);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == loginButton && Field.getText().isEmpty())
            {
                frame.dispose();
                getNode n=new getNode(this.graph);
            }
             else if(e.getSource() == loginButton) {
                int key=Integer.parseInt(Field.getText());
                frame.dispose();
                result_screen s;
                if(this.graph.getNode(key)==null)
                {
                    s = new result_screen(this.graph,"the node is not in the graph", "",null,Color.red);
                }
                else {
                    NodeData n=this.graph.getNode(key);
                    String id=Integer.toString(n.getKey());
                    String loc_x=Double.toString(n.getLocation().x());
                    String loc_y=Double.toString(n.getLocation().y());
                    String loc_z=Double.toString(n.getLocation().z());
                    s = new result_screen(this.graph,"id: "+id+", "+"x: "+loc_x+", "+"y: "+loc_y+" ,\n"+"z: "+loc_z,"",null,Color.blue);
                }
            }
            if(e.getSource() == backButton) {
                frame.dispose();
                LoginPage l;
                l = new LoginPage(this.graph);
                }
            }
        }





