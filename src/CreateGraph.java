import api.DirectedWeightedGraphAlgorithms;

import java.util.Random;
import api.*;
public class CreateGraph {
    private int N_num;
    private int E_num;

    public CreateGraph(int N_num, int E_num){
        this.N_num = N_num;
        this.E_num = E_num;
    }

    public DirectedWeightedGraphAlgorithms rand(){
       GraphAlgo algo = new GraphAlgo();
        Random random = new Random();
        for (int i = 0; i < this.N_num; i++) {
            double x = 35 + random.nextDouble();
            double y = 32 + random.nextDouble();
            GeoLocation location = new Location(x, y, 0.0);
            NodeData node = new Node(i, location);
            algo.getGraph().addNode(node);
        }
        for (int i = 0; i < this.N_num; i++) {
            for (int j = 0; j < this.E_num; j++) {
                int Dest = random.nextInt(this.N_num);
                double Weight = 1 + random.nextDouble();
                algo.getGraph().connect(i, Dest, Weight);
            }
        }
        return algo;
    }

}
