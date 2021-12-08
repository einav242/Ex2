package One;

import api.DWGraph;
import api.DirectedWeightedGraph;

public class Main {

    public static void main(String[] args) {
        DirectedWeightedGraph graph=new DWGraph();
        IDanPasswords idPasswords = new IDanPasswords();

        LoginPage loginPage = new LoginPage(idPasswords.getLoginInfo(),graph);

    }
}
