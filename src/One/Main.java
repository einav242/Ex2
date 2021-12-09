package One;

import api.*;
import api.DirectedWeightedGraph;

public class Main {

    public static void main(String[] args) {
        DirectedWeightedGraph graph=new DWGraph();
        myGraph graph1 = new myGraph();
        GraphAlgo algo=new GraphAlgo(graph);
        algo.load("G1.json");

        WelcomePage welcomePage=new WelcomePage(graph1.getLoginInfo(),algo.getGraph());
    }
}
