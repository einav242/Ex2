package One;

import api.DirectedWeightedGraph;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import api.*;
public class LoginPage implements ActionListener {
    DWGraph graph;
    JFrame frame = new JFrame();
    JButton loginButton = new JButton("Load Graph");
    JButton saveButton = new JButton("Save Graph");
    JButton editButton = new JButton("Edit Graph");
    JButton algoButton = new JButton("Use Algorithm");

    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel messageLabel = new JLabel();

    HashMap<Integer,Integer> loginInfo = new HashMap<Integer,Integer>();

     LoginPage(HashMap <Integer,Integer> loginInfoOriginal, DirectedWeightedGraph graph) {
         this.graph=new DWGraph(graph);
         loginInfo = loginInfoOriginal;
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

         frame.add(lblAdminLoginForm);
         frame.add(algoButton);
         frame.add(saveButton);
         frame.add(editButton);
         frame.add(messageLabel);
         frame.add(userIDField);
         frame.add(userPasswordField);
         frame.add(loginButton);
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
        else{
            messageLabel.setForeground(Color.red);
            messageLabel.setText("Not Good");
        }
        /*
        if (e.getSource() == loginButton) {
            String userID = userIDField.getText();
            String password = String.valueOf(userPasswordField.getPassword());

            if (loginInfo.containsKey(userID)){
                if(loginInfo.get(userID).equals(password)) {
                    messageLabel.setForeground(Color.green);
                    messageLabel.setText("Login successful");
                    frame.dispose();
                    WelcomePage wel = new WelcomePage(userID);
                }
                else{
                    messageLabel.setForeground(Color.red);
                    messageLabel.setText("Wrong password");
                }
            }
            else {
                messageLabel.setForeground(Color.red);
                messageLabel.setText("username not found");
            }

        }
        */
    }

}
