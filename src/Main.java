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
    public static void main(String[] args) throws FileNotFoundException {
//        Gson t = new Gson();
//        Map<String, Object> map = t.fromJson(new FileReader("data/G1.json"), Map.class);
//        System.out.println(map);
        DirectedWeightedGraph g0 = new DWGraph();
        DWGraph g = new DWGraph(g0);
        GeoLocation geo1 = new Location(35.19589389346247, 32.10152879327731, 0.0);
        GeoLocation geo2 = new Location(35.20319591121872, 32.10318254621849, 0.0);
        GeoLocation geo3 = new Location(35.20752617756255, 32.1025646605042, 0.0);
        GeoLocation geo4 = new Location(35.21007339305892, 32.10107446554622, 0.0);
        GeoLocation geo5 = new Location(35.21310882485876, 32.104636394957986, 0.0);
        GeoLocation geo6 = new Location(35.212111165456015, 32.106235628571426, 0.0);
        GeoLocation geo7 = new Location(335.20797194027441, 32.104854472268904, 0.0);
        GeoLocation geo8 = new Location(35.205764353510894, 32.106326494117646, 0.0);
        GeoLocation geo9 = new Location(35.20154022114608, 32.10594485882353, 0.0);

        NodeData n1 = new Node(0, geo1);
        NodeData n2 = new Node(1, geo2);
        NodeData n3 = new Node(2, geo3);
        NodeData n4 = new Node(3, geo4);
        NodeData n5 = new Node(4, geo5);
        NodeData n6 = new Node(5, geo6);
        NodeData n7 = new Node(6, geo7);
        NodeData n8 = new Node(7, geo8);
        NodeData n9 = new Node(8, geo9);

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

//        g.connect(0,1,1);
//        g.connect(1,2,4);
//        g.connect(2,0,2);
//        g.connect(2,3,8);
//        g.connect(3,0,2);
//        g.connect(0,3,3);
//        g.connect(2,4,1);
//        g.connect(4,3,1);


        //DWGraph g2=new DWGraph(g);
        DirectedWeightedGraphAlgorithms alg = new GraphAlgo(g);
        alg.save("bar.json");
        DirectedWeightedGraph g3=alg.copy();
        System.out.println(alg.isConnected());
        //System.out.println(alg.shortestPathDist(0,6));
           System.out.println("center: "+alg.center());
        List<NodeData>l=alg.shortestPath(1,3);
        System.out.println(l.size());
        for(int i=0;i<l.size();i++)
        {
            System.out.println(l.get(i)+"->");
        }
        DirectedWeightedGraphAlgorithms alg2 = new GraphAlgo(g);
        //alg2.load("G1.json");
        List<NodeData> l1 = new LinkedList<>();
        l1.add(n1);
        l1.add(n2);
        l1.add(n3);
        l1.add(n4);

        List<NodeData> l2 = alg.tsp(l1);
        System.out.println(l2.size());
        for(int i=0;i<l2.size();i++)
       {
           System.out.println(l2.get(i)+"->");
       }
    }

    }


