package api;

import java.util.*;

public class DWGraph implements DirectedWeightedGraph{

    private HashMap<Integer,NodeData> nodes;
    private HashMap<Integer,HashMap<Integer, EdgeData>> edges;
    private int nodeSize;
    private int edgeSize;
    private  int mc;

    public DWGraph(){
        this.nodes = new HashMap<>();
        this.edges = new HashMap<>();
        this.nodeSize = 0;
        this.edgeSize = 0;
        this.mc = 0;
    }
    public DWGraph(DirectedWeightedGraph other)
    {
        this.nodes = new HashMap<>();
        this.edges = new HashMap<>();
        Iterator<NodeData> iter=other.nodeIter();
        if (other.nodeSize()!=0)
        {
            while (iter.hasNext()) {
                this.addNode(iter.next());
            }
        }
        Iterator<EdgeData> iter2=other.edgeIter();
        if(other.edgeSize()!=0)
        {
            while (iter2.hasNext()) {
                EdgeData temp=iter2.next();
                int src = temp.getSrc();
                int dest = temp.getDest();
                double w = temp.getWeight();
                this.connect(src, dest, w);
            }
        }
        this.nodeSize = other.nodeSize();
        this.edgeSize = other.edgeSize();
        this.mc = other.getMC();
    }
    public HashMap<Integer, NodeData> getNodes() {
        return nodes;
    }

    public HashMap<Integer, HashMap<Integer, EdgeData>> getEdges() {
        return edges;
    }

    @Override
    public NodeData getNode(int key) {
        if(!nodes.containsKey(key))
        {
            return null;
        }
        return nodes.get(key);
    }

    @Override
    public EdgeData getEdge(int src, int dest) {
        return edges.get(src).get(dest);
    }

    @Override
    public void addNode(NodeData n) {
        this.nodes.put(n.getKey(), n);
        this.edges.put(n.getKey(),new HashMap<>());
        this.nodeSize++;
        this.mc++;
    }

    @Override
    public void connect(int src, int dest, double w) {
        if(nodes.containsKey(src) && nodes.containsKey(dest) && w > 0 ) {
            EdgeData e = new Edge(src , dest , w);
            this.edges.get(src).put(dest,e);
            this.edgeSize++;
            this.mc++;
        }
    }

    @Override
    public Iterator<NodeData> nodeIter() {
        int temp_mc=this.mc;
        ArrayList<NodeData> d=new ArrayList<>();
        Collection<Integer> keys = this.nodes.keySet();
        for(int i : keys)
        {
            d.add(this.nodes.get(i));
        }
        Iterator<NodeData> iterator=d.iterator();
        if(mc!=temp_mc)
        {
            throw new RuntimeException();
        }
        return iterator;
    }

    @Override
    public Iterator<EdgeData> edgeIter() {
        int temp_mc=this.mc;
        ArrayList<EdgeData> d=new ArrayList<>();
        Collection<Integer> keys = this.edges.keySet();
        for(int i : keys)
        {
            Collection<Integer> keys1 = this.edges.get(i).keySet();
            for(int j : keys1)
            {
                d.add(this.edges.get(i).get(j));
            }
        }
        Iterator<EdgeData> iterator = d.iterator();
        if(mc!=temp_mc)
        {
            throw new RuntimeException();
        }
        return iterator;
    }


    @Override
    public Iterator<EdgeData> edgeIter(int node_id) {
        int temp_mc=this.mc;
        ArrayList<EdgeData> d=new ArrayList<>();
        Collection<Integer> keys = this.edges.get(node_id).keySet();
        for(int i : keys)
        {
            d.add(this.edges.get(node_id).get(i));
        }
        Iterator<EdgeData> iterator = d.iterator();
        if(mc!=temp_mc)
        {
            throw new RuntimeException();
        }
        return iterator;
    }

    @Override
    public NodeData removeNode(int key) {
        if(!this.nodes.containsKey(key)){
            return null;
        }
        HashMap h =this.edges.remove(key);
        this.edgeSize -= h.size();
        this.mc += h.size();
        Collection<Integer> keys = this.edges.keySet();
        for(int i : keys){
            if(this.edges.get(i).containsKey(key)){
                this.edges.get(i).remove(key);
                this.edgeSize--;
                this.mc++;
            }
        }
        this.nodeSize--;
        this.mc++;
        return this.nodes.remove(key);
    }

    @Override
    public EdgeData removeEdge(int src, int dest) {
        if (!this.nodes.containsKey(src) || !this.nodes.containsKey(dest)) {
            return null;
        }
        EdgeData e = this.edges.get(src).remove(dest);
        if(e != null){
            this.edgeSize--;
            this.mc++;
        }
        return e;
    }

    @Override
    public int nodeSize() {
        return this.nodeSize;
    }

    @Override
    public int edgeSize() {
        return this.edgeSize;
    }

    @Override
    public int getMC() {
        return this.mc;
    }
}
