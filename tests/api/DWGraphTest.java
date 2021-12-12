package api;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class DWGraphTest {
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
    void getNodes() {
        DWGraph g1 = new DWGraph(graph_1());
        Iterator<NodeData>iter1=g1.nodeIter();
        for (int i : g1.getNodes().keySet())
        {
            assertEquals(iter1.next(),g1.getNodes().get(i));
        }
        DWGraph g2 = new DWGraph(graph_2());
        Iterator<NodeData>iter2=g2.nodeIter();
        for (int i : g2.getNodes().keySet())
        {
            assertEquals(iter2.next(),g2.getNodes().get(i));
        }
        DWGraph g3 = new DWGraph(graph_3());
        Iterator<NodeData>iter3=g3.nodeIter();
        for (int i : g3.getNodes().keySet())
        {
            assertEquals(iter3.next(),g3.getNodes().get(i));
        }
        assertEquals(null,g3.getNodes().get(10));

    }

    @Test
    void getEdges() {
        DWGraph g1 = new DWGraph(graph_1());
        Iterator<EdgeData>iter1=g1.edgeIter();
        for (int i : g1.getEdges().keySet())
        {
            for (int j: g1.getEdges().get(i).keySet())
            {
                assertEquals(iter1.next(),g1.getEdges().get(i).get(j));
            }
        }
        DWGraph g2 = new DWGraph(graph_2());
        Iterator<EdgeData>iter2=g2.edgeIter();
        for (int i : g2.getEdges().keySet())
        {
            for (int j: g2.getEdges().get(i).keySet())
            {
                assertEquals(iter2.next(),g2.getEdges().get(i).get(j));
            }
        }
        DWGraph g3 = new DWGraph(graph_3());
        Iterator<EdgeData>iter3=g3.edgeIter();
        for (int i : g3.getEdges().keySet())
        {
            for (int j: g3.getEdges().get(i).keySet())
            {
                assertEquals(iter3.next(),g3.getEdges().get(i).get(j));
            }
        }
        assertEquals(null,g3.getEdges().get(8).get(2));
    }

    @Test
    void getNode() {
        DWGraph g1 = new DWGraph(graph_1());
        DWGraph g2 = new DWGraph(graph_2());
        DWGraph g3 = new DWGraph(graph_3());
        for (int i : g1.getNodes().keySet())
        {
            assertEquals(g1.getNodes().get(i),g1.getNode(i));
        }
        for (int i : g2.getNodes().keySet())
        {
            assertEquals(g2.getNodes().get(i),g2.getNode(i));
        }
        for (int i : g3.getNodes().keySet())
        {
            assertEquals(g3.getNodes().get(i),g3.getNode(i));
        }
    }

    @Test
    void getEdge() {
        DWGraph g1 = new DWGraph(graph_1());
        for (int i : g1.getEdges().keySet())
        {
            for (int j: g1.getEdges().get(i).keySet())
            {
                assertEquals(g1.getEdges().get(i).get(j),g1.getEdge(i,j));
            }
        }
        DWGraph g2 = new DWGraph(graph_2());
        for (int i : g2.getEdges().keySet())
        {
            for (int j: g2.getEdges().get(i).keySet())
            {
                assertEquals(g2.getEdges().get(i).get(j),g2.getEdge(i,j));
            }
        }
        DWGraph g3 = new DWGraph(graph_3());
        for (int i : g3.getEdges().keySet())
        {
            for (int j: g3.getEdges().get(i).keySet())
            {
                assertEquals(g3.getEdges().get(i).get(j),g3.getEdge(i,j));
            }
        }
    }

    @Test
    void addNode() {
        DWGraph g1 = new DWGraph(graph_1());
        DWGraph g2 = new DWGraph(graph_2());
        DWGraph g3 = new DWGraph(graph_3());
        GeoLocation geo1 = new Location(35.19589389346247,32.10152879327731,0.0);
        GeoLocation geo2 = new Location(35.20319591121872,32.10318254621849,0.0);
        GeoLocation geo3 = new Location(35.20752617756255,32.1025646605042,0.0);
        NodeData n1 = new Node(10,geo1);
        NodeData n2 = new Node(11,geo2);
        NodeData n3 = new Node(12,geo3);
        g1.addNode(n1);
        g2.addNode(n2);
        g3.addNode(n3);
        assertEquals(true,g1.getNodes().containsValue(n1));
        assertEquals(true,g2.getNodes().containsValue(n2));
        assertEquals(true,g3.getNodes().containsValue(n3));
    }

    @Test
    void connect() {
        DWGraph g1 = new DWGraph(graph_1());
        DWGraph g2 = new DWGraph(graph_2());
        DWGraph g3 = new DWGraph(graph_3());
        GeoLocation geo1 = new Location(35.19589389346247,32.10152879327731,0.0);
        GeoLocation geo2 = new Location(35.20319591121872,32.10318254621849,0.0);
        GeoLocation geo3 = new Location(35.20752617756255,32.1025646605042,0.0);
        NodeData n1 = new Node(10,geo1);
        NodeData n2 = new Node(11,geo2);
        NodeData n3 = new Node(12,geo3);
        g1.addNode(n1);
        EdgeData e1=new Edge(n1.getKey(),0,4);
        g1.connect(e1.getSrc(),e1.getDest(),e1.getWeight());
        g2.addNode(n2);
        EdgeData e2=new Edge(n2.getKey(),0,5);
        g2.connect(e2.getSrc(),e2.getDest(),e2.getWeight());
        g3.addNode(n3);
        EdgeData e3=new Edge(n3.getKey(),0,7);
        g3.connect(e3.getSrc(),e3.getDest(),e3.getWeight());

        assertEquals(true,g1.getEdges().get(10).containsKey(0));
        assertEquals(true,g2.getEdges().get(11).containsKey(0));
        assertEquals(true,g3.getEdges().get(12).containsKey(0));
    }

    @Test
    void nodeIter() {
        DWGraph g1 = new DWGraph(graph_1());
        Iterator<NodeData>iter1=g1.nodeIter();
        for (int i : g1.getNodes().keySet())
        {
            assertEquals(g1.getNodes().get(i),iter1.next());
        }
        DWGraph g2 = new DWGraph(graph_2());
        Iterator<NodeData>iter2=g2.nodeIter();
        for (int i : g2.getNodes().keySet())
        {
            assertEquals(g2.getNodes().get(i),iter2.next());
        }
        DWGraph g3 = new DWGraph(graph_3());
        Iterator<NodeData>iter3=g3.nodeIter();
        for (int i : g3.getNodes().keySet())
        {
            assertEquals(g3.getNodes().get(i),iter3.next());
        }
    }

    @Test
    void edgeIter() {
        DWGraph g1 = new DWGraph(graph_1());
        Iterator<EdgeData>iter1=g1.edgeIter();
        for (int i : g1.getEdges().keySet())
        {
            for (int j: g1.getEdges().get(i).keySet())
            {
                assertEquals(g1.getEdges().get(i).get(j),iter1.next());
            }
        }
        DWGraph g2 = new DWGraph(graph_2());
        Iterator<EdgeData>iter2=g2.edgeIter();
        for (int i : g2.getEdges().keySet())
        {
            for (int j: g2.getEdges().get(i).keySet())
            {
                assertEquals(g2.getEdges().get(i).get(j),iter2.next());
            }
        }
        DWGraph g3 = new DWGraph(graph_3());
        Iterator<EdgeData>iter3=g3.edgeIter();
        for (int i : g3.getEdges().keySet())
        {
            for (int j: g3.getEdges().get(i).keySet())
            {
                assertEquals(g3.getEdges().get(i).get(j),iter3.next());
            }
        }
    }

    @Test
    void testEdgeIter() {
        DWGraph g1 = new DWGraph(graph_1());
        Iterator<EdgeData>iter1=g1.edgeIter(0);
        for (int i : g1.getEdges().get(0).keySet())
        {
            assertEquals(g1.getEdges().get(0).get(i),iter1.next());
        }
        DWGraph g2 = new DWGraph(graph_2());
        Iterator<EdgeData>iter2=g2.edgeIter(0);
        for (int i : g2.getEdges().get(0).keySet())
        {
            assertEquals(g2.getEdges().get(0).get(i),iter2.next());
        }
        DWGraph g3 = new DWGraph(graph_3());
        Iterator<EdgeData>iter3=g3.edgeIter(0);
        for (int i : g3.getEdges().get(0).keySet())
        {
            assertEquals(g3.getEdges().get(0).get(i),iter3.next());
        }
    }

    @Test
    void removeNode() {
        DWGraph g1 = new DWGraph(graph_1());
        DWGraph g2 = new DWGraph(graph_2());
        DWGraph g3 = new DWGraph(graph_3());
        g1.removeNode(0);
        g2.removeNode(0);
        g3.removeNode(0);
        assertEquals(false,g1.getNodes().containsKey(0));
        assertEquals(false,g1.getEdges().containsKey(0));
        assertEquals(false,g2.getNodes().containsKey(0));
        assertEquals(false,g2.getEdges().containsKey(0));
        assertEquals(false,g3.getNodes().containsKey(0));
        assertEquals(false,g3.getEdges().containsKey(0));
    }

    @Test
    void removeEdge() {
        DWGraph g1 = new DWGraph(graph_1());
        DWGraph g2 = new DWGraph(graph_2());
        DWGraph g3 = new DWGraph(graph_3());
        g1.removeEdge(0,1);
        g2.removeEdge(1,2);
        g3.removeEdge(0,3);
        assertEquals(false,g1.getEdges().get(0).containsKey(1));
        assertEquals(false,g2.getEdges().get(1).containsKey(2));
        assertEquals(false,g3.getEdges().get(0).containsKey(3));
    }

    @Test
    void nodeSize() {
        DWGraph g1 = new DWGraph(graph_1());
        DWGraph g2 = new DWGraph(graph_2());
        DWGraph g3 = new DWGraph(graph_3());
        assertEquals(9,g1.nodeSize());
        assertEquals(5,g2.nodeSize());
        assertEquals(9,g3.nodeSize());
    }

    @Test
    void edgeSize() {
        DWGraph g1 = new DWGraph(graph_1());
        DWGraph g2 = new DWGraph(graph_2());
        DWGraph g3 = new DWGraph(graph_3());
        assertEquals(11,g1.edgeSize());
        assertEquals(8,g2.edgeSize());
        assertEquals(12,g3.edgeSize());
    }

    @Test
    void getMC() {
    }
}