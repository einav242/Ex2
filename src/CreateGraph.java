import api.DirectedWeightedGraphAlgorithms;

import java.util.Random;
import api.*;
public class CreateGraph {
    private int N_num;
    private int E_num;
    private DWGraph graph;

    public CreateGraph(int N_num, int E_num){
         this.graph=new DWGraph();
        this.N_num = N_num;
        this.E_num = E_num;
    }

    public void rand(String file){
       GraphAlgo algo = new GraphAlgo();
        Random random = new Random();
        for (int i = 0; i < this.N_num; i++) {
            double x = 30 + random.nextDouble();
            double y = 29 + random.nextDouble();
            GeoLocation location = new Location(x, y, 0.0);
            NodeData node = new Node(i, location);
            this.graph.addNode(node);
        }
        for (int i : this.graph.getNodes().keySet()) {
            for (int j=0;j<this.graph.nodeSize();j++ ) {
                int Dest = random.nextInt(this.N_num);
                double Weight = 1 + random.nextDouble();
                this.graph.connect(i, Dest, Weight);
            }
        }
        algo.init(graph);
        algo.save(file);
    }

}

