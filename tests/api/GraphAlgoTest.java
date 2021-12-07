package api;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class GraphAlgoTest {

    private DirectedWeightedGraph graph_1() {

        DirectedWeightedGraph g0 = new DWGraph();
        DWGraph g = new DWGraph(g0);

        GeoLocation geo1 = new Location(35.19589389346247,32.10152879327731,0.0);
        GeoLocation geo2 = new Location(35.20319591121872,32.10318254621849,0.0);
        GeoLocation geo3 = new Location(35.20752617756255,32.1025646605042,0.0);
        GeoLocation geo4 = new Location(35.21007339305892,32.10107446554622,0.0);
        GeoLocation geo5 = new Location(35.21310882485876,32.104636394957986,0.0);
        GeoLocation geo6 = new Location(35.212111165456015,32.106235628571426,0.0);
        GeoLocation geo7 = new Location(335.20797194027441,32.104854472268904,0.0);
        GeoLocation geo8 = new Location(35.205764353510894,32.106326494117646,0.0);
        GeoLocation geo9 = new Location(35.20154022114608,32.10594485882353,0.0);

        NodeData n1 = new Node(0,geo1);
        NodeData n2 = new Node(1,geo2);
        NodeData n3 = new Node(2,geo3);
        NodeData n4 = new Node(3,geo4);
        NodeData n5 = new Node(4,geo5);
        NodeData n6 = new Node(5,geo6);
        NodeData n7 = new Node(6,geo7);
        NodeData n8 = new Node(7,geo8);
        NodeData n9 = new Node(8,geo9);

        g.addNode(n1);
        g.addNode(n2);
        g.addNode(n3);
        g.addNode(n4);
        g.addNode(n5);
        g.addNode(n6);
        g.addNode(n7);
        g.addNode(n8);
        g.addNode(n9);

        g.connect(0,1,3);
        g.connect(0,2,9);
        g.connect(0,3,4);
        g.connect(1,4,5);
        g.connect(2,5,2);
        g.connect(5,7,1);
        g.connect(5,8,3);
        g.connect(4,6,8);
        g.connect(6,0,3);
        g.connect(7,8,3);
        g.connect(3,8,3);

        return g;
    }
    private DirectedWeightedGraph graph_2() {

        DirectedWeightedGraph g0 = new DWGraph();
        DWGraph g = new DWGraph(g0);

        GeoLocation geo1 = new Location(35.19589389346247,32.10152879327731,0.0);
        GeoLocation geo2 = new Location(35.20319591121872,32.10318254621849,0.0);
        GeoLocation geo3 = new Location(35.20752617756255,32.1025646605042,0.0);
        GeoLocation geo4 = new Location(35.21007339305892,32.10107446554622,0.0);
        GeoLocation geo5 = new Location(35.21310882485876,32.104636394957986,0.0);

        NodeData n1 = new Node(0,geo1);
        NodeData n2 = new Node(1,geo2);
        NodeData n3 = new Node(2,geo3);
        NodeData n4 = new Node(3,geo4);
        NodeData n5 = new Node(4,geo5);


        g.addNode(n1);
        g.addNode(n2);
        g.addNode(n3);
        g.addNode(n4);
        g.addNode(n5);

        g.connect(0,1,1);
        g.connect(1,2,4);
        g.connect(2,0,2);
        g.connect(2,3,8);
        g.connect(3,0,2);
        g.connect(0,3,3);
        g.connect(2,4,1);
        g.connect(4,3,1);

        return g;
    }
    private DirectedWeightedGraph graph_3() {

        DirectedWeightedGraph g0 = new DWGraph();
        DWGraph g = new DWGraph(g0);

        GeoLocation geo1 = new Location(35.19589389346247,32.10152879327731,0.0);
        GeoLocation geo2 = new Location(35.20319591121872,32.10318254621849,0.0);
        GeoLocation geo3 = new Location(35.20752617756255,32.1025646605042,0.0);
        GeoLocation geo4 = new Location(35.21007339305892,32.10107446554622,0.0);
        GeoLocation geo5 = new Location(35.21310882485876,32.104636394957986,0.0);
        GeoLocation geo6 = new Location(35.212111165456015,32.106235628571426,0.0);
        GeoLocation geo7 = new Location(335.20797194027441,32.104854472268904,0.0);
        GeoLocation geo8 = new Location(35.205764353510894,32.106326494117646,0.0);
        GeoLocation geo9 = new Location(35.20154022114608,32.10594485882353,0.0);

        NodeData n1 = new Node(0,geo1);
        NodeData n2 = new Node(1,geo2);
        NodeData n3 = new Node(2,geo3);
        NodeData n4 = new Node(3,geo4);
        NodeData n5 = new Node(4,geo5);
        NodeData n6 = new Node(5,geo6);
        NodeData n7 = new Node(6,geo7);
        NodeData n8 = new Node(7,geo8);
        NodeData n9 = new Node(8,geo9);

        g.addNode(n1);
        g.addNode(n2);
        g.addNode(n3);
        g.addNode(n4);
        g.addNode(n5);
        g.addNode(n6);
        g.addNode(n7);
        g.addNode(n8);
        g.addNode(n9);

        g.connect(0,1,3);
        g.connect(0,2,9);
        g.connect(0,3,4);
        g.connect(1,4,5);
        g.connect(2,5,2);
        g.connect(5,7,1);
        g.connect(5,8,3);
        g.connect(4,6,8);
        g.connect(6,0,3);
        g.connect(7,8,3);
        g.connect(3,8,3);
        g.connect(8,6,3);

        return g;
    }
    @Test
    void init() {
        DirectedWeightedGraph g = new DWGraph();
        GraphAlgo g1 = new GraphAlgo(g);
        g1.init(g);
        assertEquals(g, g1.getGraph());
        DirectedWeightedGraph g2=graph_1();
        GraphAlgo g3 = new GraphAlgo(g2);
        g3.init(g2);
        assertEquals(g2, g3.getGraph());
    }

    @Test
    void getGraph() {
        DirectedWeightedGraph g = new DWGraph();
        GraphAlgo g1 = new GraphAlgo(g);
        assertEquals(g, g1.getGraph());
    }

    @Test
    void copy() {
        DirectedWeightedGraph g = graph_1();
        GraphAlgo g1 = new GraphAlgo(g);
        DirectedWeightedGraph g_copy=new DWGraph(g1.copy());
        Iterator<NodeData>iter=g_copy.nodeIter();
        Iterator<NodeData>iter1=g1.getGraph().nodeIter();
        while (iter.hasNext())
        {
            assertEquals(iter.next(),iter1.next());
        }
        Iterator<EdgeData>iter2=g_copy.edgeIter();
        Iterator<EdgeData>iter3=g1.getGraph().edgeIter();
        while (iter.hasNext())
        {
            assertEquals(iter2.next(),iter3.next());
        }
        assertEquals(g1.getGraph().nodeSize(),g_copy.nodeSize());
        assertEquals(g1.getGraph().edgeSize(),g_copy.edgeSize());
        assertEquals(g1.getGraph().getMC(),g_copy.getMC());
    }

    @Test
    void isConnected() {
        GraphAlgo g1 = new GraphAlgo(graph_1());
        assertEquals(false,g1.isConnected());
        GraphAlgo g2 = new GraphAlgo(graph_2());
        assertEquals(true,g2.isConnected());
        GraphAlgo g3 = new GraphAlgo(graph_2());
        assertEquals(true,g3.isConnected());
    }

    @Test
    void shortestPathDist() {
        GraphAlgo g1 = new GraphAlgo(graph_1());
        assertEquals(16,g1.shortestPathDist(0,6));
        assertEquals(-1,g1.shortestPathDist(8,6));
        GraphAlgo g2 = new GraphAlgo(graph_2());
        assertEquals(3,g2.shortestPathDist(0,3));
        assertEquals(6,g2.shortestPathDist(1,3));
        GraphAlgo g3 = new GraphAlgo(graph_3());
        assertEquals(10,g3.shortestPathDist(0,6));
        assertEquals(7,g3.shortestPathDist(0,8));
    }

    @Test
    void shortestPath() {
        DWGraph g01=new DWGraph(graph_1());
        GraphAlgo g1 = new GraphAlgo(g01);
        LinkedList<NodeData>l1=new LinkedList<>();
        l1.add(g01.getNodes().get(0));
        l1.add(g01.getNodes().get(1));
        l1.add(g01.getNodes().get(4));
        l1.add(g01.getNodes().get(6));
        assertEquals(l1,g1.shortestPath(0,6));
        DWGraph g02=new DWGraph(graph_2());
        GraphAlgo g2 = new GraphAlgo(g02);
        LinkedList<NodeData>l2=new LinkedList<>();
        l2.add(g02.getNodes().get(1));
        l2.add(g02.getNodes().get(2));
        l2.add(g02.getNodes().get(4));
        l2.add(g02.getNodes().get(3));
        assertEquals(l2,g2.shortestPath(1,3));
        DWGraph g03=new DWGraph(graph_3());
        GraphAlgo g3 = new GraphAlgo(g03);
        LinkedList<NodeData>l3=new LinkedList<>();
        l3.add(g03.getNodes().get(0));
        l3.add(g03.getNodes().get(3));
        l3.add(g03.getNodes().get(8));
        l3.add(g03.getNodes().get(6));
        assertEquals(l3,g3.shortestPath(0,6));
    }

    @Test
    void center() {
        GraphAlgo g1 = new GraphAlgo(graph_1());
        assertEquals(null,g1.center());
        GraphAlgo g2 = new GraphAlgo(graph_2());
        assertEquals(2,g2.center().getKey());
        GraphAlgo g3 = new GraphAlgo(graph_3());
        assertEquals(0,g3.center().getKey());
    }

    @Test
    void tsp() {
        DWGraph g01=new DWGraph(graph_1());
        GraphAlgo g1 = new GraphAlgo(g01);
        List<NodeData> l1 = new LinkedList<>();
        l1.add(g01.getNodes().get(0));
        l1.add(g01.getNodes().get(1));
        l1.add(g01.getNodes().get(2));
        l1.add(g01.getNodes().get(3));
        assertEquals(null,g1.tsp(l1));
        DWGraph g02=new DWGraph(graph_2());
        GraphAlgo g2 = new GraphAlgo(g02);
        List<NodeData> l2 = new LinkedList<>();
        l2.add(g02.getNodes().get(0));
        l2.add(g02.getNodes().get(1));
        l2.add(g02.getNodes().get(2));
        l2.add(g02.getNodes().get(3));
        List<NodeData> l02 = new LinkedList<>();
        l02.add(g02.getNodes().get(0));
        l02.add(g02.getNodes().get(1));
        l02.add(g02.getNodes().get(2));
        l02.add(g02.getNodes().get(4));
        l02.add(g02.getNodes().get(3));
        assertEquals(l02,g2.tsp(l2));
        DWGraph g03=new DWGraph(graph_3());
        GraphAlgo g3 = new GraphAlgo(g03);
        List<NodeData> l3 = new LinkedList<>();
        l3.add(g03.getNodes().get(0));
        l3.add(g03.getNodes().get(1));
        l3.add(g03.getNodes().get(2));
        l3.add(g03.getNodes().get(3));
        List<NodeData> l03 = new LinkedList<>();
        l03.add(g03.getNodes().get(1));
        l03.add(g03.getNodes().get(4));
        l03.add(g03.getNodes().get(6));
        l03.add(g03.getNodes().get(0));
        l03.add(g03.getNodes().get(3));
        l03.add(g03.getNodes().get(8));
        l03.add(g03.getNodes().get(6));
        l03.add(g03.getNodes().get(0));
        l03.add(g03.getNodes().get(2));
        assertEquals(l03,g3.tsp(l3));
    }

    @Test
    void save() {
        DWGraph g01=new DWGraph(graph_1());
        GraphAlgo g1 = new GraphAlgo(g01);
        DWGraph g02=new DWGraph(graph_2());
        GraphAlgo g2 = new GraphAlgo(g02);
        DWGraph g03=new DWGraph(graph_3());
        GraphAlgo g3 = new GraphAlgo(g03);
        assertEquals(true,g1.save("g1.json"));
        assertEquals(true,g2.save("g2.json"));
        assertEquals(true,g3.save("g3.json"));
    }

    @Test
    void load() {
    }
}