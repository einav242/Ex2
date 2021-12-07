package api;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {

    @Test
    void getKey() {
        GeoLocation geo1 = new Location(35.19589389346247,32.10152879327731,0.0);
        GeoLocation geo2 = new Location(35.20319591121872,32.10318254621849,0.0);
        GeoLocation geo3 = new Location(35.20752617756255,32.1025646605042,0.0);
        NodeData n1 = new Node(0,geo1);
        NodeData n2 = new Node(1,geo2);
        NodeData n3 = new Node(2,geo3);
        assertEquals(0,n1.getKey());
        assertEquals(1,n2.getKey());
        assertEquals(2,n3.getKey());
    }

    @Test
    void getLocation() {
        GeoLocation geo1 = new Location(35.19589389346247,32.10152879327731,0.0);
        GeoLocation geo2 = new Location(35.20319591121872,32.10318254621849,0.0);
        GeoLocation geo3 = new Location(35.20752617756255,32.1025646605042,0.0);
        NodeData n1 = new Node(0,geo1);
        NodeData n2 = new Node(1,geo2);
        NodeData n3 = new Node(2,geo3);
        assertEquals(geo1.x(),n1.getLocation().x());
        assertEquals(geo1.y(),n1.getLocation().y());
        assertEquals(geo1.z(),n1.getLocation().z());
        assertEquals(geo2.x(),n2.getLocation().x());
        assertEquals(geo2.y(),n2.getLocation().y());
        assertEquals(geo2.z(),n2.getLocation().z());
        assertEquals(geo3.x(),n3.getLocation().x());
        assertEquals(geo3.y(),n3.getLocation().y());
        assertEquals(geo3.z(),n3.getLocation().z());
    }

    @Test
    void setLocation() {
        GeoLocation geo1 = new Location(35.19589389346247,32.10152879327731,0.0);
        GeoLocation geo2 = new Location(35.20319591121872,32.10318254621849,0.0);
        GeoLocation geo3 = new Location(35.20752617756255,32.1025646605042,0.0);
        NodeData n1 = new Node(0,geo1);
        NodeData n2 = new Node(1,geo2);
        NodeData n3 = new Node(2,geo3);
        n1.setLocation(geo2);
        n2.setLocation(geo3);
        n3.setLocation(geo1);
        assertEquals(geo2.x(),n1.getLocation().x());
        assertEquals(geo2.y(),n1.getLocation().y());
        assertEquals(geo2.z(),n1.getLocation().z());
        assertEquals(geo3.x(),n2.getLocation().x());
        assertEquals(geo3.y(),n2.getLocation().y());
        assertEquals(geo3.z(),n2.getLocation().z());
        assertEquals(geo1.x(),n3.getLocation().x());
        assertEquals(geo1.y(),n3.getLocation().y());
        assertEquals(geo1.z(),n3.getLocation().z());
    }

    @Test
    void getWeight() {
        GeoLocation geo1 = new Location(35.19589389346247,32.10152879327731,0.0);
        GeoLocation geo2 = new Location(35.20319591121872,32.10318254621849,0.0);
        GeoLocation geo3 = new Location(35.20752617756255,32.1025646605042,0.0);
        NodeData n1 = new Node(0,geo1);
        NodeData n2 = new Node(1,geo2);
        NodeData n3 = new Node(2,geo3);
        assertEquals(0,n1.getWeight());
        assertEquals(0,n2.getWeight());
        assertEquals(0,n3.getWeight());
    }

    @Test
    void setWeight() {
        GeoLocation geo1 = new Location(35.19589389346247,32.10152879327731,0.0);
        GeoLocation geo2 = new Location(35.20319591121872,32.10318254621849,0.0);
        GeoLocation geo3 = new Location(35.20752617756255,32.1025646605042,0.0);
        NodeData n1 = new Node(0,geo1);
        NodeData n2 = new Node(1,geo2);
        NodeData n3 = new Node(2,geo3);
        n1.setWeight(3.0);
        n2.setWeight(5.0);
        n3.setWeight(6.0);
        assertEquals(3,n1.getWeight());
        assertEquals(5,n2.getWeight());
        assertEquals(6,n3.getWeight());
    }

    @Test
    void getInfo() {
        GeoLocation geo1 = new Location(35.19589389346247,32.10152879327731,0.0);
        GeoLocation geo2 = new Location(35.20319591121872,32.10318254621849,0.0);
        GeoLocation geo3 = new Location(35.20752617756255,32.1025646605042,0.0);
        NodeData n1 = new Node(0,geo1);
        NodeData n2 = new Node(1,geo2);
        NodeData n3 = new Node(2,geo3);
        assertEquals("white",n1.getInfo());
        assertEquals("white",n2.getInfo());
        assertEquals("white",n3.getInfo());
    }

    @Test
    void setInfo() {
        GeoLocation geo1 = new Location(35.19589389346247,32.10152879327731,0.0);
        GeoLocation geo2 = new Location(35.20319591121872,32.10318254621849,0.0);
        GeoLocation geo3 = new Location(35.20752617756255,32.1025646605042,0.0);
        NodeData n1 = new Node(0,geo1);
        NodeData n2 = new Node(1,geo2);
        NodeData n3 = new Node(2,geo3);
        n1.setInfo("grey");
        n2.setInfo("red");
        n3.setInfo("black");
        assertEquals("grey",n1.getInfo());
        assertEquals("red",n2.getInfo());
        assertEquals("black",n3.getInfo());
    }

    @Test
    void getTag() {
        GeoLocation geo1 = new Location(35.19589389346247,32.10152879327731,0.0);
        GeoLocation geo2 = new Location(35.20319591121872,32.10318254621849,0.0);
        GeoLocation geo3 = new Location(35.20752617756255,32.1025646605042,0.0);
        NodeData n1 = new Node(0,geo1);
        NodeData n2 = new Node(1,geo2);
        NodeData n3 = new Node(2,geo3);
        assertEquals(0,n1.getTag());
        assertEquals(0,n2.getTag());
        assertEquals(0,n3.getTag());
    }

    @Test
    void setTag() {
        GeoLocation geo1 = new Location(35.19589389346247,32.10152879327731,0.0);
        GeoLocation geo2 = new Location(35.20319591121872,32.10318254621849,0.0);
        GeoLocation geo3 = new Location(35.20752617756255,32.1025646605042,0.0);
        NodeData n1 = new Node(0,geo1);
        NodeData n2 = new Node(1,geo2);
        NodeData n3 = new Node(2,geo3);
        n1.setTag(1);
        n2.setTag(2);
        n3.setTag(3);
        assertEquals(1,n1.getTag());
        assertEquals(2,n2.getTag());
        assertEquals(3,n3.getTag());
    }

    @Test
    void testToString() {
        GeoLocation geo1 = new Location(35.19589389346247,32.10152879327731,0.0);
        GeoLocation geo2 = new Location(35.20319591121872,32.10318254621849,0.0);
        GeoLocation geo3 = new Location(35.20752617756255,32.1025646605042,0.0);
        NodeData n1 = new Node(0,geo1);
        NodeData n2 = new Node(1,geo2);
        NodeData n3 = new Node(2,geo3);
        assertEquals("Node{key=0, location=Location{x=35.19589389346247, y=32.10152879327731, z=0.0}}",n1.toString());
        assertEquals("Node{key=1, location=Location{x=35.20319591121872, y=32.10318254621849, z=0.0}}",n2.toString());
        assertEquals("Node{key=2, location=Location{x=35.20752617756255, y=32.1025646605042, z=0.0}}",n3.toString());
    }
}