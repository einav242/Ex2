package GUI;

import api.DirectedWeightedGraph;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import api.*;
public class LoginPage implements ActionListener {
    DWGraph graph;
    JFrame frame = new JFrame();
    JButton showGraphButton = new JButton("Show Graph");
    JButton loginButton = new JButton("Load Graph");
    JButton saveButton = new JButton("Save Graph");
    JButton editButton = new JButton("Edit Graph");
    JButton algoButton = new JButton("Use Algorithm");

    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel messageLabel = new JLabel();



     LoginPage(DirectedWeightedGraph graph) {
         this.graph=new DWGraph(graph);
         JLabel lblAdminLoginForm = new JLabel("Choose your choice:");
         lblAdminLoginForm.setBounds(99,50,300,25);
         lblAdminLoginForm.setForeground(Color.red);
         lblAdminLoginForm.setFont(new Font("Tacoma", Font.PLAIN, 18));


         loginButton.setBounds(100,100,200,25);
         loginButton.setFocusable(false);
         loginButton.addActionListener(this);

         saveButton.setBounds(100,150,200,25);
         saveButton.setFocusable(false);
         saveButton.addActionListener(this);

         editButton.setBounds(100,200,200,25);
         editButton.setFocusable(false);
         editButton.addActionListener(this);

         algoButton.setBounds(100,250,200,25);
         algoButton.setFocusable(false);
         algoButton.addActionListener(this);

         showGraphButton.setBounds(100,300,200,25);
         showGraphButton.setFocusable(false);
         showGraphButton.addActionListener(this);

         frame.add(lblAdminLoginForm);
         frame.add(algoButton);
         frame.add(saveButton);
         frame.add(editButton);
         frame.add(messageLabel);
         frame.add(userIDField);
         frame.add(userPasswordField);
         frame.add(loginButton);
         frame.add(showGraphButton);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setSize(420,420);
         frame.setLayout(null);
         frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == saveButton){
            frame.dispose();
            Save s = new Save(this.graph);
        }
        if(e.getSource() == loginButton){
            frame.dispose();
            Load l = new Load(this.graph);
        }
        if(e.getSource() == algoButton){
            frame.dispose();
            Use_Algo_LoginPage log = new Use_Algo_LoginPage(this.graph);
        }
        if (e.getSource() == editButton) {
            frame.dispose();
            EditG well = new EditG(this.graph);
        }
        if(e.getSource()==showGraphButton)
        {
            frame.dispose();
            LinkedList<NodeData>l=new LinkedList<>();
            Show s=new Show(this.graph,l,-1);
        }
        else{
            messageLabel.setForeground(Color.red);
            messageLabel.setText("Not Good");
        }
    }

}
