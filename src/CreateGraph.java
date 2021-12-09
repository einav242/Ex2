import api.DirectedWeightedGraphAlgorithms;

import java.util.Random;
import api.*;
public class CreateGraph {
    private int N_num;
    private int E_num;



    public CreateGraph(int nodes, int edges){
        this.N_num = nodes;
        this.E_num = edges;
    }

    public DirectedWeightedGraphAlgorithms generate(){
       GraphAlgo algo = new GraphAlgo();
        Random r = new Random();
        for (int i = 0; i < this.N_num; i++) {
            double x = 35 + r.nextDouble();
            double y = 32 + r.nextDouble();
            GeoLocation location = new Location(x, y, 0.0);
            NodeData node = new Node(i, location);
            algo.getGraph().addNode(node);
        }

        for (int i = 0; i < this.N_num; i++) {
            for (int j = 0; j < this.E_num; j++) {
                int Dest = r.nextInt(this.N_num);
                double Weight = 1 + r.nextDouble();
                algo.getGraph().connect(i, Dest, Weight);
            }
        }
        return algo;
    }

}
