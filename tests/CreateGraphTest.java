import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import api.*;

import java.util.Iterator;
import java.util.LinkedList;

class CreateGraphTest {

    @Test
    void rand() {
        CreateGraph createGraph1=new CreateGraph(1000,1000);
        GraphAlgo algo= (GraphAlgo) createGraph1.rand();
        //algo.isConnected();
       // algo.center();
        Iterator<NodeData>iter=algo.getGraph().nodeIter();
        int i= (int) (Math.random()*algo.getGraph().nodeSize());
        int j=0;
        LinkedList<NodeData>l=new LinkedList<>();

        NodeData n1 = null;
        while (iter.hasNext() && j<i)
        {
            n1=iter.next();
            l.add(n1);
            i++;
        }
//        i= (int) (Math.random()*algo.getGraph().nodeSize());
//        j=0;
//        NodeData n2=null;
//        while (iter.hasNext() && j<i)
//        {
//            n2=iter.next();
//            i++;
//        }
//        algo.shortestPath(n1.getKey(),n2.getKey());
//        l.add(n1);
//        l.add(n2);
        //algo.shortestPathDist(n1.getKey(),n2.getKey());
        algo.tsp(l);
    }
}