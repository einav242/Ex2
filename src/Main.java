import api.*;
import com.google.gson.*;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args){
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

        List<NodeData> l2 = new LinkedList<>();
        l2.add(g.getNodes().get(0));
        l2.add(g.getNodes().get(1));
        l2.add(g.getNodes().get(2));
        l2.add(g.getNodes().get(3));
        GraphAlgo g2 = new GraphAlgo(g);
        g2.tsp(l2);

    }
}


