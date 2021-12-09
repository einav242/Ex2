package One;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import api.*;
public class Short_PathDist implements ActionListener {
    GraphAlgo algo;
    JFrame frame = new JFrame();
    JButton loginButton = new JButton("enter");
    JButton backButton = new JButton("back");
    JTextField Field1 = new JTextField();
    JTextField Field2 = new JTextField();

    JLabel srcLabel = new JLabel("Src: ");
    JLabel destLabel = new JLabel("Dest: ");
    JLabel messageLabel = new JLabel();

    HashMap<Integer,Integer> loginInfo = new HashMap<Integer,Integer>();

    Short_PathDist(GraphAlgo algo) {

        this.algo=algo;
        srcLabel.setBounds(50,100,75,25);
        destLabel.setBounds(50,150,75,25);

        messageLabel.setBounds(125,250,250,35);
        messageLabel.setFont(new Font(null, Font.ITALIC,25));

        Field1.setBounds(125,100,200,25);
        Field2.setBounds(125,150,200,25);

        loginButton.setBounds(225,200,100,25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);

        backButton.setBounds(300,50,100,25);
        backButton.setFocusable(false);
        backButton.addActionListener(this);

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
        if(e.getSource() == loginButton) {
            int src = Integer.parseInt(Field1.getText());
            int dest = Integer.parseInt(Field2.getText());
            result_screen s;
            if (this.algo.getGraph().getNode(src) == null || this.algo.getGraph().getNode(dest) == null) {
                s = new result_screen(this.algo.getGraph(), "try again", 0,"",null);
            }
            else {
                double dist = this.algo.shortestPathDist(src, dest);
                String d = Double.toString(dist);
                if (dist != -1) {
                    s = new result_screen(this.algo.getGraph(), "the distance is " + d, 1,"",null);
                } else {
                    s = new result_screen(this.algo.getGraph(), "there is no path", 0,"",null);
                }
            }
        }
        if(e.getSource() == backButton)
        {
            frame.dispose();
            Use_Algo_LoginPage u=new Use_Algo_LoginPage(this.algo.getGraph());
        }

    }
}
