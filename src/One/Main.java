package One;

import api.DWGraph;
import api.DirectedWeightedGraph;

public class Main {

    public static void main(String[] args) {
        DirectedWeightedGraph graph=new DWGraph();
        myGraph idPasswords = new myGraph();

        WelcomePage welcomePage=new WelcomePage(idPasswords.getLoginInfo(),graph);
    }
}
