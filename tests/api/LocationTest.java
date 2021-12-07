package api;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocationTest {

    @Test
    void x() {
        GeoLocation geo1 = new Location(35,32,0.0);
        GeoLocation geo2 = new Location(36,33,0.0);
        GeoLocation geo3 = new Location(37,34,0.0);
        assertEquals(35,geo1.x());
        assertEquals(36,geo2.x());
        assertEquals(37,geo3.x());
    }

    @Test
    void y() {
        GeoLocation geo1 = new Location(35,32,0.0);
        GeoLocation geo2 = new Location(36,33,0.0);
        GeoLocation geo3 = new Location(37,34,0.0);
        assertEquals(32,geo1.y());
        assertEquals(33,geo2.y());
        assertEquals(34,geo3.y());
    }

    @Test
    void z() {
        GeoLocation geo1 = new Location(35,32,0.0);
        GeoLocation geo2 = new Location(36,33,0.0);
        GeoLocation geo3 = new Location(37,34,0.0);
        assertEquals(0,geo1.z());
        assertEquals(0,geo2.z());
        assertEquals(0,geo3.z());
    }

    @Test
    void distance() {
        GeoLocation geo1 = new Location(35,32,0.0);
        GeoLocation geo2 = new Location(36,33,0.0);
        GeoLocation geo3 = new Location(40,41,0.0);
        assertEquals(Math.sqrt(2),geo1.distance(geo2));
        assertEquals((4*Math.sqrt(5)),geo2.distance(geo3));
        assertEquals(Math.sqrt(106),geo3.distance(geo1));
    }

    @Test
    void testToString() {
        GeoLocation geo1 = new Location(35,32,0.0);
        GeoLocation geo2 = new Location(36,33,0.0);
        GeoLocation geo3 = new Location(40,41,0.0);
        assertEquals("Location{x=35.0, y=32.0, z=0.0}",geo1.toString());
        assertEquals("Location{x=36.0, y=33.0, z=0.0}",geo2.toString());
        assertEquals("Location{x=40.0, y=41.0, z=0.0}",geo3.toString());
    }
}