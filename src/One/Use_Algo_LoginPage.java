package One;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import api.*;
public class Use_Algo_LoginPage implements ActionListener {
    GraphAlgo graph;
    JFrame frame = new JFrame();
    JButton ConnButton = new JButton("isConnected ");
    JButton PathDistButton = new JButton("Short PathDist");
    JButton PathButton = new JButton("Short Path");
    JButton centerButton = new JButton("center");
    JButton tspButton = new JButton("TSP");
    JButton backButton = new JButton("Back");

    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel messageLabel = new JLabel();


    Use_Algo_LoginPage(DirectedWeightedGraph graph) {
        this.graph=new GraphAlgo(graph);
        JLabel lblAdminLoginForm = new JLabel("Choose your choice:");
        lblAdminLoginForm.setBounds(99,25,300,25);
        lblAdminLoginForm.setForeground(Color.red);
        lblAdminLoginForm.setFont(new Font("Tacoma", Font.PLAIN, 18));


        backButton.setBounds(300,50,100,25);
        backButton.setFocusable(false);
        backButton.addActionListener(this);


        ConnButton.setBounds(100,140,200,25);
        ConnButton.setFocusable(false);
        ConnButton.addActionListener(this);

        PathDistButton.setBounds(100,170,200,25);
        PathDistButton.setFocusable(false);
        PathDistButton.addActionListener(this);

        PathButton.setBounds(100,200,200,25);
        PathButton.setFocusable(false);
        PathButton.addActionListener(this);

        centerButton.setBounds(100,230,200,25);
        centerButton.setFocusable(false);
        centerButton.addActionListener(this);

        tspButton.setBounds(100,260,200,25);
        tspButton.setFocusable(false);
        tspButton.addActionListener(this);

        frame.add(lblAdminLoginForm);
        frame.add(tspButton);
        frame.add(centerButton);
        frame.add(PathButton);
        frame.add(PathDistButton);
        frame.add(ConnButton);
        frame.add(messageLabel);
        frame.add(userIDField);
        frame.add(userPasswordField);
        frame.add(backButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == ConnButton)
        {
            boolean t=this.graph.isConnected();
            result_screen s;
            if(t == true) {
                s = new result_screen(this.graph.getGraph(),"True", 1);
            }
            else
            {
                s = new result_screen(this.graph.getGraph(),"False", 0);
            }
        }
        if (e.getSource() == PathDistButton){
            frame.dispose();
            Short_Test_PathDist_LoginPage s = new Short_Test_PathDist_LoginPage(this.graph);
        }
        if (e.getSource() == PathButton){
            frame.dispose();
            Short_Test_Path_LoginPage sp = new Short_Test_Path_LoginPage();
        }
        if(e.getSource() == centerButton)
        {
            result_screen s;
            if(this.graph.center()!=null) {
                String str=Integer.toString(this.graph.center().getKey());
                s = new result_screen(this.graph.getGraph(),"the center is "+str, 1);
            }
            else
            {
                s = new result_screen(this.graph.getGraph(),"the graph is not connected", 0);
            }

        }
        if (e.getSource() == tspButton){
            frame.dispose();
            TSP_LoginPage tsp = new TSP_LoginPage();
        }
        if(e.getSource() == backButton)
        {
            frame.dispose();
            IDanPasswords idPasswords = new IDanPasswords();
            LoginPage l=new LoginPage(idPasswords.getLoginInfo(),graph.getGraph());
        }
    }
}
