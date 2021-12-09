package One;

import api.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class EditG implements ActionListener {
        DirectedWeightedGraph graph;
        JFrame frame = new JFrame();
        JButton addButton = new JButton("Add Node");
        JButton connectButton = new JButton("Connect Two Node");
        JButton removeN_Button = new JButton("Remove Node");
        JButton removeE_Button = new JButton("Remove Edge");
        JButton getN_Button = new JButton("get Node");
        JButton getE_Button = new JButton("get Edge");
        JButton backButton = new JButton("Back");

        JTextField userIDField = new JTextField();
        JPasswordField userPasswordField = new JPasswordField();
        JLabel messageLabel = new JLabel();

        HashMap<Integer,Integer> loginInfo = new HashMap<Integer,Integer>();

        EditG(DirectedWeightedGraph graph){
            this.graph=new DWGraph(graph);
            JLabel lblAdminLoginForm = new JLabel("Choose Your Edit To The Graph");
            lblAdminLoginForm.setBounds(85,50,300,25);
            lblAdminLoginForm.setForeground(Color.GRAY);
            lblAdminLoginForm.setFont(new Font("Tacoma", Font.PLAIN, 16));

            backButton.setBounds(300,30,100,25);
            backButton.setFocusable(false);
            backButton.addActionListener(this);

            addButton.setBounds(100,100,200,25);
            addButton.setFocusable(false);
            addButton.addActionListener(this);

            connectButton.setBounds(100,150,200,25);
            connectButton.setFocusable(false);
            connectButton.addActionListener(this);

            removeN_Button.setBounds(100,200,200,25);
            removeN_Button.setFocusable(false);
            removeN_Button.addActionListener(this);

            removeE_Button.setBounds(100,250,200,25);
            removeE_Button.setFocusable(false);
            removeE_Button.addActionListener(this);

            getE_Button.setBounds(100,300,200,25);
            getE_Button.setFocusable(false);
            getE_Button.addActionListener(this);

            getN_Button.setBounds(100,350,200,25);
            getN_Button.setFocusable(false);
            getN_Button.addActionListener(this);

            frame.add(lblAdminLoginForm);
            frame.add(removeE_Button);
            frame.add(connectButton);
            frame.add(removeN_Button);
            frame.add(messageLabel);
            frame.add(userIDField);
            frame.add(userPasswordField);
            frame.add(addButton);
            frame.add(backButton);
            frame.add(getE_Button);
            frame.add(getN_Button);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(420,420);
            frame.setLayout(null);
            frame.setVisible(true);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == addButton) {
                frame.dispose();
                Add_Node lo = new Add_Node(this.graph);
            }
            if(e.getSource() == connectButton){
                frame.dispose();
                connected lo = new connected(this.graph);
            }
            if(e.getSource() == removeN_Button){
                frame.dispose();
                Remove_Node lo = new Remove_Node(this.graph);
            }
            if (e.getSource() == removeE_Button) {
                frame.dispose();
                RemoveEdge lo = new RemoveEdge(this.graph);
            }

            if(e.getSource() == backButton)
            {
                frame.dispose();
                myGraph idPasswords = new myGraph();
                LoginPage l=new LoginPage(graph);
            }
            if(e.getSource() == getN_Button)
            {
                frame.dispose();
                getNode g=new getNode(this.graph);
            }
            if(e.getSource() == getE_Button)
            {
                frame.dispose();
                getEdge ed=new getEdge(this.graph);
            }
        }

    }

