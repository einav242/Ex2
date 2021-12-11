package GUI;

import api.*;
import api.DirectedWeightedGraph;

public class Main {
    public Main(DirectedWeightedGraph graph) {
        myGraph graph1 = new myGraph();
        WelcomePage welcomePage=new WelcomePage(graph1.getLoginInfo(),graph);
    }
}
