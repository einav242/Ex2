package api;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EdgeTest {

    @Test
    void getSrc() {
        EdgeData e1=new Edge(0,1,3);
        EdgeData e2=new Edge(5,8,5);
        EdgeData e3=new Edge(2,4,4);
        assertEquals(0,e1.getSrc());
        assertEquals(5,e2.getSrc());
        assertEquals(2,e3.getSrc());
    }

    @Test
    void getDest() {
        EdgeData e1=new Edge(0,1,3);
        EdgeData e2=new Edge(5,8,5);
        EdgeData e3=new Edge(2,4,4);
        assertEquals(1,e1.getDest());
        assertEquals(8,e2.getDest());
        assertEquals(4,e3.getDest());
    }

    @Test
    void getWeight() {
        EdgeData e1=new Edge(0,1,3);
        EdgeData e2=new Edge(5,8,5);
        EdgeData e3=new Edge(2,4,4);
        assertEquals(3,e1.getWeight());
        assertEquals(5,e2.getWeight());
        assertEquals(4,e3.getWeight());
    }

    @Test
    void getInfo() {
        EdgeData e1=new Edge(0,1,3);
        EdgeData e2=new Edge(5,8,5);
        EdgeData e3=new Edge(2,4,4);
        assertEquals("",e1.getInfo());
        assertEquals("",e2.getInfo());
        assertEquals("",e3.getInfo());
    }

    @Test
    void setInfo() {
        EdgeData e1=new Edge(0,1,3);
        EdgeData e2=new Edge(5,8,5);
        EdgeData e3=new Edge(2,4,4);
        e1.setInfo("white");
        e2.setInfo("grey");
        e3.setInfo("black");
        assertEquals("white",e1.getInfo());
        assertEquals("grey",e2.getInfo());
        assertEquals("black",e3.getInfo());
    }

    @Test
    void getTag() {
        EdgeData e1=new Edge(0,1,3);
        EdgeData e2=new Edge(5,8,5);
        EdgeData e3=new Edge(2,4,4);
        assertEquals(-1,e1.getTag());
        assertEquals(-1,e2.getTag());
        assertEquals(-1,e3.getTag());
    }

    @Test
    void setTag() {
        EdgeData e1=new Edge(0,1,3);
        EdgeData e2=new Edge(5,8,5);
        EdgeData e3=new Edge(2,4,4);
        e1.setTag(2);
        e2.setTag(3);
        e3.setTag(4);
        assertEquals(2,e1.getTag());
        assertEquals(3,e2.getTag());
        assertEquals(4,e3.getTag());
    }
}