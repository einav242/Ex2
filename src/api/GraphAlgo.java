package api;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;


public class GraphAlgo implements DirectedWeightedGraphAlgorithms {
    private DWGraph gr;

    public GraphAlgo(DirectedWeightedGraph g) {
        this.init(g);
    }

    @Override
    public void init(DirectedWeightedGraph g) {
        this.gr = new DWGraph(g);
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
        boolean v[] = new boolean[this.gr.nodeSize()];
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
    public HashMap<Integer,HashMap<Integer, EdgeData>> revers() {
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
        double d[]=new double[this.gr.nodeSize()];
        Collection<Integer> keys=this.gr.getNodes().keySet();
        for(int i : keys)
        {
            if(this.gr.getEdges().get(src).containsKey(i))
            {
                d[i]=this.gr.getEdges().get(src).get(i).getWeight();
            }
            else
            {
                d[i]=Integer.MAX_VALUE;
            }
            this.gr.getNodes().get(i).setTag(0);
        }
        d[src]=0;
        int i=src;
        while (white())
        {
            this.gr.getNodes().get(i).setTag(2);
            Collection<Integer> keys2=this.gr.getEdges().get(i).keySet();
            for(int j : keys2)
            {
                int k=this.gr.getNodes().get(j).getKey();
                if(d[i]!=Integer.MAX_VALUE)
                {
                    d[k] = min(d[k], d[i] + gr.getEdges().get(i).get(j).getWeight());
                }
            }
            i=minVal(d);
        }
        if(d[dest] == Integer.MAX_VALUE || d[dest]==0)
        {
            return  -1;
        }
        return d[dest];
    }

    private boolean white()
    {
        Iterator<NodeData> iter=this.gr.nodeIter();
        while (iter.hasNext())
        {
            if (iter.next().getTag()!=2)
            {
                return true;
            }
        }
        return false;
    }

    private int minVal(double d[])
    {
        double min=Integer.MAX_VALUE;
        int temp=-1;
        Iterator<NodeData> iter=this.gr.nodeIter();
        while (iter.hasNext())
        {
            NodeData temp1=iter.next();
            if(temp1.getTag()!=2)
            {
                int k=temp1.getKey();
                if(d[k]<min)
                {
                    min=d[k];
                    temp=k;
                }
            }
        }
        if (temp == -1)
        {
            Iterator<NodeData> iter2=this.gr.nodeIter();
            while (iter2.hasNext())
            {
                NodeData temp2=iter2.next();
                if(temp2.getTag()!=2)
                {
                    temp=temp2.getKey();
                    break;
                }
            }
        }
        return temp;
    }

    private double min(double x,double y)
    {
        if(x<y)
            return x;
        return y;
    }

    @Override
    public List<NodeData> shortestPath(int src, int dest) {
        List<NodeData>l=new LinkedList<>();
        if(this.shortestPathDist(src,dest) ==-1)
        {
            return l;
        }
        int arr[]=path_arr(src);
        int arr2[]=new int[arr.length];
        for (int i=0;i<arr2.length;i++)
        {
            arr2[i]=-1;
        }
        arr2[arr2.length-1]=dest;
        int j=dest;
        for(int i=arr2.length-2;i>=0;i--)
        {
            if(j == src)
            {
                arr2[i]=arr[j];
                break;
            }
            arr2[i]=arr[j];
            j=arr[j];
        }
        int i=0;
        while(arr2[i]!=src)
        {
            i++;
        }
        while(arr2[i]==src && i<arr2.length)
        {
            i++;
        }
        l.add(this.gr.getNode(src));
        while (i<arr2.length)
        {
            l.add(this.gr.getNode(arr2[i]));
            i++;
        }
        return l;
    }
    private int[] path_arr(int src)
    {
        double d[]=new double[this.gr.nodeSize()];
        int f[]=new int[this.gr.nodeSize()];
        Collection<Integer> keys=this.gr.getNodes().keySet();
        for(int i : keys)
        {
            if(this.gr.getEdges().get(src).containsKey(i))
            {
                d[i]=this.gr.getEdges().get(src).get(i).getWeight();
            }
            else
            {
                d[i]=Integer.MAX_VALUE;
            }
            this.gr.getNodes().get(i).setTag(0);
            f[i]=-1;
        }
        d[src]=0;
        int i=src;
        while (white())
        {
            this.gr.getNodes().get(i).setTag(2);
            Collection<Integer> keys2=this.gr.getEdges().get(i).keySet();
            for(int j : keys2)
            {
                int k=this.gr.getNodes().get(j).getKey();
                double temp=d[k];
                if(d[i]!=Integer.MAX_VALUE)
                {
                    d[k] = min(d[k], d[i] + gr.getEdges().get(i).get(j).getWeight());
                    if(d[k]!=temp || i==src)
                    {
                        f[k]=i;
                    }
                }
            }
            i=minVal(d);
        }
        return f;
    }


    @Override
    public NodeData center() {
        if(!this.isConnected())
        {
            return null;
        }
        double min=Integer.MAX_VALUE;
        int k=-1;
        Iterator<NodeData> iter=this.gr.nodeIter();
        while (iter.hasNext())
        {
            iter.next().setTag(0);
        }
        Iterator<NodeData> iter1=this.gr.nodeIter();
        while (iter1.hasNext())
        {
            NodeData n=iter1.next();
            double max_val=maxVal(n.getKey(),Integer.MIN_VALUE);
            if(max_val< min)
            {
                min=max_val;
                k=n.getKey();
            }
            n.setTag(0);
        }
        return this.gr.getNodes().get(k);
    }
    private double maxVal(int x,double max)
    {
        double d[]=new double[this.gr.nodeSize()];
        Collection<Integer> keys=this.gr.getNodes().keySet();
        for(int i : keys)
        {
            d[i]=this.shortestPathDist(x,i);
        }
        for(int j=0;j<d.length;j++)
        {
            if(d[j]>max)
            {
                max=d[j];
            }
        }
        if(max == -1)
        {
            max=Integer.MAX_VALUE;
        }
        return max;
    }

    @Override
    public List<NodeData> tsp(List<NodeData> cities) {
        if (cities.size() == 0)
            return null;
        for(int i=0; i<cities.size(); i++){
            for (int j=0; j<cities.size(); j++)
            {
                if (shortestPathDist(cities.get(i).getKey(),cities.get(j).getKey()) == -1 && i!=j)
                {
                    return null;
                }
            }
        }
            List<NodeData> ans = new ArrayList<>();
            List<NodeData> temp = new ArrayList<>();
            double temp_Dist = Double.MAX_VALUE;
            int d = 0;
            int start = minStart(cities);
            int i = 0;
            while (cities.size()!=0)
            {
                double min = Double.MAX_VALUE;
                for (int j = 0; j < cities.size(); j++)
                {
                    if (ans.size()!=0)
                        start = ans.get(ans.size() - 1).getKey();
                    else {
                        if (i > 0)
                            start = cities.get(i).getKey();
                    }
                    temp_Dist = shortestPathDist(start, cities.get(j).getKey());
                    if (temp_Dist < min && start!=cities.get(j).getKey()) {
                        min = temp_Dist;
                        temp = shortestPath(start, cities.get(j).getKey());
                        d = cities.get(j).getKey();
                    }
                }
                i++;
                for (int j =0 ; j < temp.size(); j++)
                {
                    if(ans.size()!=0 && ans.get(ans.size()-1).getKey() == temp.get(j).getKey() )
                    {
                        continue;
                    }
                    ans.add(temp.get(j));
                }
                cities.remove(this.gr.getNode(d));
            }
            if(next(ans) == true)
            {
                NodeData n=ans.get(0);
                ans.remove(n);
            }
            return ans;
    }
    public boolean next(List<NodeData> cities)
    {
        NodeData node=cities.get(0);
        cities.remove(node);
        for(NodeData n: cities)
        {
            if(n.getKey() == node.getKey())
            {
                cities.add(0,node);
                return true;
            }
        }
        cities.add(0,node);
        return false;
    }
    public int minStart(List<NodeData> cities) {
        int temp=-1;
        double w;
        double min=Double.MAX_VALUE;
        for(NodeData i : cities)
        {
            double sum=0;
            for(NodeData j: cities)
            {
                w=this.shortestPathDist(i.getKey(),j.getKey());
                sum+=w;
            }
            if(sum<min)
            {
                min=sum;
                temp=i.getKey();
            }
        }
        return temp;

    }

        private double[][] creatArr(List<NodeData> cities)
    {
        double arr[][]=new double[cities.size()][cities.size()];
        for(int i=0;i<cities.size();i++)
        {
            for (int j=0;j<cities.size();j++)
            {
                if(this.gr.getEdges().get(cities.get(i).getKey()).containsKey(cities.get(j).getKey()))
                {
                    arr[i][j]=this.gr.getEdges().get(i).get(j).getWeight();
                }
                else if(i!=j)
                {
                    arr[i][j]=Integer.MAX_VALUE;
                }
                else if (i == j)
                {
                    arr[i][j]=0;
                }
            }
        }
        return arr;
    }

    @Override
    public boolean save(String file) {
        JsonObject jsonOb = new JsonObject();

        JsonArray jsonAr1 = new JsonArray();
        Iterator<EdgeData>iter=this.gr.edgeIter();
        while (iter.hasNext()) {
            EdgeData ed = iter.next();
            JsonObject cnt1 = new JsonObject();
            cnt1.addProperty("src ", ed.getSrc());
            cnt1.addProperty("w ", ed.getWeight());
            cnt1.addProperty("dest ", ed.getDest());
            jsonAr1.add(cnt1);
        }
        jsonOb.add("Edges", jsonAr1);

        JsonArray jsonAr2 = new JsonArray();
        Iterator<NodeData>iter2=this.gr.nodeIter();
        while (iter2.hasNext()) {
            NodeData nd = iter2.next();
            JsonObject cnt2 = new JsonObject();
            cnt2.addProperty("pos ", nd.getLocation().x() + "," + nd.getLocation().y() + "," + nd.getLocation().z());
            cnt2.addProperty("id", nd.getKey());
            jsonAr2.add(cnt2);
        }
        jsonOb.add("Nodes", jsonAr2);

        //make json
        Gson gson = new GsonBuilder().setPrettyPrinting().create(); // pretty print
        String json = gson.toJson(jsonOb); // the object that we want to change to json

        //Write JSON to file
        try {
            PrintWriter myWriter = new PrintWriter(new File(file));
            myWriter.write(json);
            myWriter.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("error");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean load(String file){
        return true;
    }

}
