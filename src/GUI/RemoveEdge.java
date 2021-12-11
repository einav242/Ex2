package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import api.*;
public class RemoveEdge implements ActionListener {
    DWGraph graph;
    JFrame frame = new JFrame();
    JButton loginButton = new JButton("remove");
    JButton backButton = new JButton("Back");

    JTextField src_Field = new JTextField();
    JTextField dest_Field = new JTextField();


    JLabel src_Label = new JLabel("Src: ");
    JLabel dest_Label = new JLabel("Dest: ");
    JLabel messageLabel = new JLabel();

    HashMap<Integer,Integer> loginInfo = new HashMap<Integer,Integer>();

     RemoveEdge(DirectedWeightedGraph graph) {
         this.graph=new DWGraph(graph);
         src_Label.setBounds(50,100,75,25);
         dest_Label.setBounds(50,150,75,25);

         messageLabel.setBounds(125,250,250,35);
         messageLabel.setFont(new Font(null, Font.ITALIC,25));

         src_Field.setBounds(125,100,200,25);
         dest_Field.setBounds(125,150,200,25);

         loginButton.setBounds(225,200,100,25);
         loginButton.setFocusable(false);
         loginButton.addActionListener(this);

         backButton.setBounds(300, 50, 100, 25);
         backButton.setFocusable(false);
         backButton.addActionListener(this);

         frame.add(src_Label);
         frame.add(dest_Label);
         frame.add(messageLabel);
         frame.add(src_Field);
         frame.add(dest_Field);
         frame.add(loginButton);
         frame.add(backButton);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setSize(420,420);
         frame.setLayout(null);
         frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton && (src_Field.getText().isEmpty() || dest_Field.getText().isEmpty()))
        {
            frame.dispose();
            RemoveEdge n=new RemoveEdge(this.graph);
        }
         else if(e.getSource() == loginButton)
        {
            int src=Integer.parseInt(src_Field.getText());
            int dest=Integer.parseInt(dest_Field.getText());
            frame.dispose();
            result_screen s;
            if(this.graph.getEdge(src,dest)!=null)
            {
                this.graph.removeEdge(src,dest);
                if(this.graph.getEdge(src,dest)==null) {
                    s = new result_screen(this.graph, "the edges removed", "",null,Color.green);
                }
                else {
                    s = new result_screen(this.graph,"try again!", "",null,Color.red);
                }
            }
            else
            {
                s = new result_screen(this.graph,"the edge is not in the graph", "",null,Color.red);
            }
        }

        if (e.getSource() == backButton) {
            frame.dispose();
            EditG well = new EditG(this.graph);
        }
    }
}
