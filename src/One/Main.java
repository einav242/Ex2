package One;

import api.*;
import api.DirectedWeightedGraph;

public class Main {
    public Main(DirectedWeightedGraph graph) {
        myGraph graph1 = new myGraph();
        WelcomePage welcomePage=new WelcomePage(graph1.getLoginInfo(),graph);
    }

    public static void main(String[] g) {
        DirectedWeightedGraph graph=new DWGraph();
        myGraph graph1 = new myGraph();
        GraphAlgo algo=new GraphAlgo(graph);
        algo.load("G2.json");

        WelcomePage welcomePage=new WelcomePage(graph1.getLoginInfo(),algo.getGraph());
    }

}
