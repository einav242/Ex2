package api;

public class Edge implements EdgeData{

    private int srcId;
    private int destId;
    private double weight;
    private String info;
    private int tag;

    public Edge(int s , int d , double w ){
        this.srcId = s;
        this.destId = d;
        this.weight = w;
        this.info = "";
        this.tag = -1;
    }


    @Override
    public int getSrc() {
        return this.srcId;
    }

    @Override
    public int getDest() {
        return this.destId;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }

    @Override
    public String getInfo() {
        return this.info;
    }

    @Override
    public void setInfo(String s) {
        this.info = s;
    }

    @Override
    public int getTag() {
        return this.tag;
    }

    @Override
    public void setTag(int t) {
        this.tag = t ;
    }


}
