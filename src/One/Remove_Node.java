package One;

import api.DWGraph;
import api.DirectedWeightedGraph;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class Remove_Node implements ActionListener {
    DWGraph graph;
    JFrame frame = new JFrame();
    JButton loginButton = new JButton("remove");
    JButton backButton = new JButton("Back");

    JTextField Field = new JTextField();
    JLabel messageLabel_t = new JLabel();
    JLabel userIDLabel = new JLabel("Node: ");
    JLabel messageLabel = new JLabel();
    

    Remove_Node(DirectedWeightedGraph graph)
    {
        this.graph=new DWGraph(graph);

        userIDLabel.setBounds(50,100,75,25);

        messageLabel_t.setBounds(125,250,250,35);
        messageLabel_t.setFont(new Font(null, Font.ITALIC,25));

        messageLabel.setBounds(125,250,250,35);
        messageLabel.setFont(new Font(null, Font.ITALIC,25));

        Field.setBounds(125,100,200,25);

        loginButton.setBounds(225,200,100,25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);

        backButton.setBounds(300, 50, 100, 25);
        backButton.setFocusable(false);
        backButton.addActionListener(this);

        frame.add(userIDLabel);
        frame.add(messageLabel);
        frame.add(Field);
        frame.add(loginButton);
        frame.add(backButton);
        frame.add(messageLabel_t);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == loginButton)
        {
            int key=Integer.parseInt(Field.getText());
            result_screen s;
            if(this.graph.getNodes().containsKey(key))
            {
                this.graph.removeNode(key);
                if(!this.graph.getNodes().containsKey(key)) {
                    s = new result_screen(this.graph, "the node removed", 1,"",null);
                }
                else {
                    s = new result_screen(this.graph,"try again!", 0,"",null);
                }
            }
            else
            {
                s = new result_screen(this.graph,"try again!", 0,"",null);
            }
        }
        if (e.getSource() == backButton) {
            frame.dispose();
            EditG well = new EditG(this.graph);
        }
    }
}
