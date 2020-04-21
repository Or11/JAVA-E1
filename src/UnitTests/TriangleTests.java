package UnitTests;

import geometries.Triangle;
import org.junit.Test;
import primitives.Point3D;

import static org.junit.Assert.*;

/**
 * Testing Triangle
 * @author Or Efrati
 *
 */
public class TriangleTests {
    /**
     * Test method for
     * {@link geometries.Triangle#Triangle(Point3D, Point3D, Point3D)}.
     */
    @Test
    public void testConstructor() {
        // ============ Equivalence Partitions Tests ==============
        // TC01: Correct 3 points that can create a triangle
        try {
            new Triangle(new Point3D(0, 0, 1), new Point3D(1, 0, 0), new Point3D(0, 1, 0));
        } catch (IllegalArgumentException e) {
        }

        // TC01: 3 points that cannot create a triangle
        try {
            new Triangle(new Point3D(1, 1, 1), new Point3D(2, 2, 2), new Point3D(3, 3, 3));
            fail("Constructed a vector as triangle");
        } catch (IllegalArgumentException e) {}
    }

    /**
     * Test method for{@Link primitives.Triangle#getNormal()(primitives.Vector)}
     */
    @Test
    public void getNormal() {

    }
}