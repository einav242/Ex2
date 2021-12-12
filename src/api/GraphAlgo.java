package api;

import java.io.*;
import java.net.http.HttpHeaders;
import java.util.*;

import com.google.gson.*;


public class GraphAlgo implements DirectedWeightedGraphAlgorithms {
    private DWGraph gr;

    public GraphAlgo(DirectedWeightedGraph g) {
        this.init(g);
    }
    public GraphAlgo() {
        this.gr=new DWGraph();
    }
    private int getBiggest() {
        int max=Integer.MIN_VALUE;
        for(int i: this.gr.getNodes().keySet())
        {
            if(max<this.gr.getNodes().get(i).getKey())
            {
                max=this.gr.getNodes().get(i).getKey();
            }
        }
        return max+1;
    }

    @Override
    public void init(DirectedWeightedGraph g) {
        this.gr = (DWGraph) g;
    }

    @Override
    public DirectedWeightedGraph getGraph() {
        return this.gr;
    }

    @Override
    public DirectedWeightedGraph copy() {
        DirectedWeightedGraph other = new DWGraph(this.gr);
        return other;
    }

    @Override
    public boolean isConnected() {
        if (this.gr.nodeSize() == 0) {
            return true;
        }
        boolean v[] = new boolean[getBiggest()];
        List<Integer> q = new LinkedList<>();
        q.add(this.gr.getNodes().get(0).getKey());
        while (!q.isEmpty()) {
            int temp = q.remove(0);
            Collection<Integer> keys = this.gr.getEdges().get(temp).keySet();
            for (int i : keys) {
                if (v[i] == true) {
                    continue;
                }
                q.add(i);
                v[i] = true;
            }
        }
        for (int i = 0; i < v.length; i++) {
            if (v[i] == false) {
                return false;
            }
            v[i] = false;
        }
        HashMap<Integer, HashMap<Integer, EdgeData>> h = this.revers();
        q.add(this.gr.getNodes().get(0).getKey());
        while (!q.isEmpty()) {
            int temp = q.remove(0);
            Collection<Integer> keys = h.get(temp).keySet();
            for (int i : keys) {
                if (v[i] == true) {
                    continue;
                }
                q.add(i);
                v[i] = true;
            }
        }
        for (int i = 0; i < v.length; i++) {
            if (v[i] == false) {
                return false;
            }
        }
        return true;
    }
    private HashMap<Integer,HashMap<Integer, EdgeData>> revers() {
        HashMap<Integer,HashMap<Integer, EdgeData>> h=new HashMap<>();
        Collection<Integer> keys=this.gr.getEdges().keySet();
        for(int i : keys)
        {
            h.put(i,new HashMap<>());
        }
        for(int i : keys)
        {
            Collection<Integer> keys2=this.gr.getEdges().get(i).keySet();
            for(int j : keys2)
            {
                int src=this.gr.getEdges().get(i).get(j).getDest();
                int dest=this.gr.getEdges().get(i).get(j).getSrc();
                double w=this.gr.getEdges().get(i).get(j).getWeight();
                EdgeData e=new Edge(src,dest,w);
                h.get(src).put(dest,e);
            }
        }
        return h;

    }

    @Override
    public double shortestPathDist(int src, int dest) {
        path_arr(src);
        if(this.gr.getNode(dest)==null|| this.gr.getNode(dest).getWeight() == Integer.MAX_VALUE || this.gr.getNode(dest).getWeight()==0)
        {
            return  -1;
        }
        return this.gr.getNode(dest).getWeight();
    }

    @Override
    public List<NodeData> shortestPath(int src, int dest) {
        List<NodeData>l=new LinkedList<>();
        path_arr(src);
        if(this.gr.getNode(dest)==null|| this.gr.getNode(dest).getWeight() == Integer.MAX_VALUE || this.gr.getNode(dest).getWeight()==0)
        {
            return  l;
        }
        int j=this.gr.getNode(dest).getTag();
        l.add(0,this.gr.getNode(dest));
        while (j!=src)
        {
            l.add(0,this.gr.getNode(j));
            j=this.gr.getNode(j).getTag();
        }
        l.add(0,this.gr.getNode(src));
        return l;
    }

    private double path_arr(int src) {
        Collection<Integer> keys = this.gr.getNodes().keySet();
        for (int i : keys) {
            if (this.gr.getEdges().get(src).containsKey(i)) {
                this.gr.getNode(i).setWeight(this.gr.getEdges().get(src).get(i).getWeight());
            } else {
                this.gr.getNode(i).setWeight(Integer.MAX_VALUE);
            }
            this.gr.getNodes().get(i).setInfo("white");
            this.gr.getNode(i).setTag(-1);
        }
        this.gr.getNode(src).setTag(0);
        this.gr.getNode(src).setWeight(0);
        int i = src;
        int l = 0;
        while (l < this.gr.nodeSize()) {
            if (this.gr.getNode(i).getInfo() != "white") {
                l++;
                continue;
            }
            this.gr.getNodes().get(i).setInfo("black");
            Collection<Integer> keys2 = this.gr.getEdges().get(i).keySet();
            for (int j : keys2) {
                int k = this.gr.getNodes().get(j).getKey();
                double temp_j = this.gr.getNode(j).getWeight();
                double temp_i = this.gr.getNode(i).getWeight();
                if (temp_i != Integer.MAX_VALUE) {
                    this.gr.getNode(j).setWeight(min(temp_j, temp_i + gr.getEdges().get(i).get(j).getWeight()));

                    if (temp_j != this.gr.getNode(j).getWeight() || i == src) {
                        this.gr.getNode(j).setTag(i);
                    }
                }
            }
            i = minVal();
            l++;
        }
        double _max=Integer.MIN_VALUE;
        for(int m :this.gr.getNodes().keySet())
        {
            if(this.gr.getNode(m).getWeight()>_max)
            {
                _max=this.gr.getNode(m).getWeight();
            }
        }
        return _max;
    }
    private int minVal() {
        double min=Integer.MAX_VALUE;
        int temp=-1;
        Iterator<NodeData> iter=this.gr.nodeIter();
        while (iter.hasNext())
        {
            NodeData temp1=iter.next();
            if(temp1.getInfo()=="white")
            {
                if(temp1.getWeight()<min)
                {
                    min=temp1.getWeight();
                    temp=temp1.getKey();
                }
            }
        }
        if (temp == -1)
        {
            Iterator<NodeData> iter2=this.gr.nodeIter();
            while (iter2.hasNext())
            {
                NodeData temp2=iter2.next();
                if(temp2.getInfo()=="white")
                {
                    temp=temp2.getKey();
                    break;
                }
            }
        }
        return temp;
    }
    private double min(double x,double y) {
        if(x<y)
            return x;
        return y;
    }

    @Override
    public NodeData center() {
        if(!isConnected())
        {
            return null;
        }
        double min=Double.MAX_VALUE;
        int k=-1;
        Collection<Integer> keys=this.gr.getNodes().keySet();
        for(int i : keys)
        {
            double temp=path_arr(i);
            if(temp<min)
            {
                min=temp;
                k=i;
            }
        }
        return this.gr.getNode(k);
    }

    @Override
    public List<NodeData> tsp(List<NodeData> cities) {
        if (cities.size() == 0){
            return null;
        }
        if (cities.size() == 1){
            return cities;
        }
        List<NodeData> ans = new ArrayList<>();
        NodeData n1= cities.get(0);
        int k;
        while (cities.size()!=0)
        {
            double min=Double.MAX_VALUE;
             k=-1;
            List<NodeData>list_temp;
            for(NodeData n2 : cities)
            {
                if(n1 == n2)
                {
                    continue;
                }
                list_temp=help_tsp(n1.getKey(),n2.getKey());
                double temp=list_temp.get(0).getWeight();
                list_temp.remove(0);
                if(temp<min && temp!=-1)
                {
                    min=temp;
                    k= n2.getKey();
                }
            }
            if(min== Integer.MAX_VALUE)
            {
                return null;
            }
            list_temp=this.shortestPath(n1.getKey(),k);
            for(NodeData n_temp: list_temp)
            {
                if(n_temp==this.gr.getNode(k))
                {
                    continue;
                }
                ans.add(n_temp);
            }
            if(cities.size()==1)
            {
                ans.add(n1);
            }
            cities.remove(n1);
            n1=this.gr.getNode(k);
        }
        return ans;
    }
    private List<NodeData>help_tsp(int src,int dest) {
        List<NodeData>l=this.shortestPath(src,dest);
        if(l==null)
        {
            return null;
        }
        NodeData t=new Node();
        t.setWeight(this.gr.getNode(dest).getWeight());
        l.add(0,t);
        return l;
    }

    @Override
    public boolean save(String file) {
        JsonObject jsonOb = new JsonObject();
        jsonOb.add("Edges", this.save_edge());
        jsonOb.add("Nodes", this.save_node());

        //make json
        Gson gson = new GsonBuilder().setPrettyPrinting().create(); // pretty print
        String json = gson.toJson(jsonOb); // the object that we want to change to json

        //Write JSON to file
        try
        {
            FileWriter myWriter = new FileWriter(new File(file));
            myWriter.write(json);
            myWriter.close();
        }
        catch (IOException e) {
            System.out.println("error");
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public JsonArray save_edge() {
        JsonArray jsonAr1 = new JsonArray();
        Iterator<EdgeData> iter = this.gr.edgeIter();
        while (iter.hasNext()) {
            EdgeData e = iter.next();
            JsonObject b1 = new JsonObject();
            b1.addProperty("src", e.getSrc());
            b1.addProperty("w", e.getWeight());
            b1.addProperty("dest", e.getDest());
            jsonAr1.add(b1);
        }
        return jsonAr1;
    }
    public JsonArray save_node() {
        JsonArray jsonAr2 = new JsonArray();
        Iterator<NodeData> iter2 = this.gr.nodeIter();
        while (iter2.hasNext()) {
            NodeData nd = iter2.next();
            JsonObject b2 = new JsonObject();
            b2.addProperty("pos", nd.getLocation().x() + "," + nd.getLocation().y() + "," + nd.getLocation().z());
            b2.addProperty("id", nd.getKey());
            jsonAr2.add(b2);
        }
        return jsonAr2;
    }

    @Override
    public boolean load(String file) {
        try {
            GsonBuilder builder = new GsonBuilder();
            builder.registerTypeAdapter(DWGraph.class, new DWG_deserializer());
            Gson gson = builder.create();

            FileReader reader = new FileReader(file);
            DirectedWeightedGraph graph = gson.fromJson(reader, DWGraph.class);
            init(graph);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}


