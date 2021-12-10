package One;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;
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

    JLabel idLabel = new JLabel(" Node id: ");
    JLabel messageLabel = new JLabel();
    JLabel error_m = new JLabel();

    HashMap<Integer, Integer> loginInfo = new HashMap<Integer, Integer>();

    TSP(GraphAlgo algo,LinkedList<NodeData> l) {
        this.algo = algo;
        this.l=l;
        idLabel.setBounds(50, 100, 75, 25);

        messageLabel.setBounds(125, 250, 250, 35);
        messageLabel.setFont(new Font(null, Font.ITALIC, 25));

        Field1.setBounds(125, 100, 200, 25);

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
        frame.add(messageLabel);
        frame.add(Field1);
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
        if (e.getSource() == loginButton && Field1.getText().isEmpty() && this.l.size()==0)
        {
            frame.dispose();
            TSP n=new TSP(this.algo,this.l);
        }
        else if (e.getSource() == nextButton) {
            int id = Integer.parseInt(Field1.getText());
            NodeData nodeData = this.algo.getGraph().getNode(id);
            frame.dispose();
            result_screen s;
            if (this.algo.getGraph().getNode(id) == null) {
                s = new result_screen(this.algo.getGraph(),"the node is not in the graph", "tsp",this.l,Color.red);

            }
            else {
                add(nodeData);
                s = new result_screen(this.algo.getGraph(), "the node was added to the list",  "tsp", this.l,Color.green);
                System.out.println(l);
            }
        }
        if(e.getSource() == loginButton && this.l.size()!=0)
        {
            List l1 =this.algo.tsp(this.l);
            if(l1==null)
            {
                frame.dispose();
                result_screen s;
                s = new result_screen(this.algo.getGraph(),"the nodes are not connected", "",this.l,Color.red);
            }
            else
            {
                frame.dispose();
                Iterator<NodeData> iter=l1.iterator();
                LinkedList<NodeData> lk=new LinkedList();
                while (iter.hasNext())
                {
                    lk.add(iter.next());
                }
                Show show=new Show(this.algo.getGraph(),lk);
            }
        }
        if(e.getSource() == backButton)
        {
            frame.dispose();
            LoginPage l=new LoginPage(this.algo.getGraph());
        }
    }

    private void add(NodeData n)
    {
        this.l.add(n);
    }
}


