import api.DWGraph;
import api.DirectedWeightedGraph;
import api.DirectedWeightedGraphAlgorithms;
import api.GraphAlgo;

/**
 * This class is the main class for Ex2 - your implementation will be tested using this class.
 */
public class Ex2 {


    public static void main(String[] args) {
        if(args.length==0)
        {
            DirectedWeightedGraph g=getGrapg("G1.json");
            DirectedWeightedGraphAlgorithms algo=getGrapgAlgo("G1.json");
            Ex2.runGUI("G1.json");
        }
        else {
            DirectedWeightedGraph g = getGrapg(args[0]);
            DirectedWeightedGraphAlgorithms algo = getGrapgAlgo(args[0]);
            Ex2.runGUI(args[0]);
        }
    }
    /**
     * This static function will be used to test your implementation
     * @param json_file - a json file (e.g., G1.json - G3.gson)
     * @return
     */
    public static DirectedWeightedGraph getGrapg(String json_file) {
        DirectedWeightedGraph g = new DWGraph();
        GraphAlgo g1 = new GraphAlgo(g);
        g1.load(json_file);
        DirectedWeightedGraph ans = g1.copy();
        return ans;
    }
    /**
     * This static function will be used to test your implementation
     * @param json_file - a json file (e.g., G1.json - G3.gson)
     * @return
     */
    public static DirectedWeightedGraphAlgorithms getGrapgAlgo(String json_file) {
        DirectedWeightedGraph g = new DWGraph();
        GraphAlgo g1 = new GraphAlgo(g);
        g1.load(json_file);
        DirectedWeightedGraphAlgorithms ans = g1;
        return ans;
    }
    /**
     * This static function will run your GUI using the json fime.
     * @param json_file - a json file (e.g., G1.json - G3.gson)
     *
     */
    public static void runGUI(String json_file) {
        DirectedWeightedGraphAlgorithms alg = getGrapgAlgo(json_file);
        new GUI.Main(alg.getGraph());
    }
}