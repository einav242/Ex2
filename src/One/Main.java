package One;

import api.DWGraph;
import api.DirectedWeightedGraph;

public class Main {

    public static void main(String[] args) {
        DirectedWeightedGraph graph=new DWGraph();
        WelcomePage welcomePage=new WelcomePage(graph);
    }
}
