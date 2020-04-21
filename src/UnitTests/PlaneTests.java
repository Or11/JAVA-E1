package UnitTests;

import geometries.Plane;
import org.junit.Test;
import primitives.Point3D;
import primitives.Vector;

import static org.junit.Assert.*;

/**
 * Testing Planes
 * @author Or Efrati
 *
 */
public class PlaneTests {

    /**
     * Test method for
     * {@link geometries.Plane#Plane(Point3D, Point3D, Point3D)}.
     */
    @Test
    public void testFirstConstructor() {
        // ============ Equivalence Partitions Tests ==============

        // TC01: Correct 3 points
        try {
            new Plane(new Point3D(0, 0, 1), new Point3D(1, 0, 0),
                    new Point3D(0, 1, 0));
        } catch (IllegalArgumentException e) {
            fail("Failed constructing a correct plane");
        }

        // TC02: 3 points that exist on the same vector
        try {
            new Plane(new Point3D(1, 1, 1), new Point3D(2, 2, 2), new Point3D(3, 3, 3));
            fail("Constructed a vector as plane");
        } catch (IllegalArgumentException e) {}
    }

    /**
     * Test method for
     * {@link geometries.Plane#Plane(Vector, Point3D)}.
     */
    @Test
    public void testSecondConstructor() {
        // ============ Equivalence Partitions Tests ==============
        // TC01: Correct vector and point
        try {
            new Plane(new Vector(1, 1, 1), new Point3D(0, 1, 0));
        } catch (IllegalArgumentException e) {
            fail("Failed constructing a correct plane");
        }
    }

    /**
     * Test method for {@link geometries.Plane#getNormal()}
     */
    @Test
    public void testGetNormal() {
        // ============ Equivalence Partitions Tests ==============
        // TC01: get normal of plane that initialized with 3 points
        Plane plane1 = new Plane(new Point3D(0, 0, 1), new Point3D(1, 0, 0), new Point3D(0, 1, 0));
        double sqrt3 = Math.sqrt(1d / 3);
        assertEquals("Bad normal to plane that initialized with 3 points", new Vector(sqrt3, sqrt3, sqrt3), plane1.getNormal());
    }
}