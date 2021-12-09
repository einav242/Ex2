package One;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import api.*;
public class connected implements ActionListener {
    DWGraph graph;
    JFrame frame = new JFrame();
    JButton loginButton = new JButton("Connect");
    JButton backButton = new JButton("back");

    JTextField srcIDField = new JTextField();
    JTextField destIDField = new JTextField();
    JTextField wightIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();

    JLabel srcIDLabel = new JLabel("Src: ");
    JLabel destIDLabel = new JLabel("Dest: ");
    JLabel wightIDLabel = new JLabel("wight: ");
    JLabel messageLabel = new JLabel();

    connected(DirectedWeightedGraph graph)
    {
        this.graph=new DWGraph(graph);
        JLabel lblAdminLoginForm = new JLabel("Choose your choice:");
        lblAdminLoginForm.setBounds(45,50,300,25);
        lblAdminLoginForm.setForeground(Color.red);
        lblAdminLoginForm.setFont(new Font("Tacoma", Font.PLAIN, 16));

        srcIDLabel.setBounds(50,100,75,25);
        destIDLabel.setBounds(50,150,75,25);
        wightIDLabel.setBounds(50,200,75,25);

        messageLabel.setBounds(125,250,250,35);
        messageLabel.setFont(new Font(null, Font.ITALIC,25));

        srcIDField.setBounds(125,100,200,25);
        destIDField.setBounds(125,150,200,25);
        wightIDField.setBounds(125,200,200,25);

        loginButton.setBounds(225,250,100,25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);

        backButton.setBounds(300,50,100,25);
        backButton.setFocusable(false);
        backButton.addActionListener(this);

        frame.add(lblAdminLoginForm);
        frame.add(srcIDLabel);
        frame.add(backButton);
        frame.add(destIDField);
        frame.add(wightIDField);
        frame.add(destIDLabel);
        frame.add(wightIDLabel);
        frame.add(messageLabel);
        frame.add(srcIDField);
        frame.add(userPasswordField);
        frame.add(loginButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() ==  loginButton)
        {
            int src=Integer.parseInt(srcIDField.getText());
            int dest=Integer.parseInt(destIDField.getText());
            double w=Double.parseDouble(wightIDField.getText());
            result_screen s;
            if(this.graph.getNodes().containsKey(src) && this.graph.getNodes().containsKey(dest)) {
                this.graph.connect(src, dest, w);
                EdgeData ed = new Edge(src, dest, w);
                frame.dispose();
                if (this.graph.getEdges().get(src).containsKey(dest)) {
                    s = new result_screen(this.graph, "the edge added", 1,"",null);
                } else {
                    s = new result_screen(this.graph, "try again!", 0,"",null);
                }
            }
            else {
                s = new result_screen(this.graph, "try again!", 0,"",null);
            }

        }
        if (e.getSource() == backButton){
            frame.dispose();
            EditG well = new EditG(this.graph);
        }
        else{
            messageLabel.setForeground(Color.red);
            messageLabel.setText("Not Good");
        }
    }
}
