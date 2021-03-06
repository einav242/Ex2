package api;

public class Location implements GeoLocation {

    private double x,y,z;

    public Location(double x ,double y , double z ){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Location(GeoLocation other){
        this.x = other.x();
        this.y = other.y();
        this.z = other.z();
    }

    @Override
    public double x() {
        return this.x;
    }

    @Override
    public double y() {
        return this.y;
    }

    @Override
    public double z() {
        return this.z;
    }

    @Override
    public double distance(GeoLocation g){
        double d  = Math.pow(g.x()-this.x,2)+Math.pow(g.y()-this.y,2) +Math.pow(g.z()-this.z,2);
        return Math.sqrt(d);
    }

    @Override
    public String toString() {
        return "Location{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
