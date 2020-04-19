package UnitTests;

import org.junit.Test;
import primitives.Vector;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Unit tests for primitives.Vector class
 * @author Or Efarti
 */

public class VectorTests {

    Vector v1 = new Vector(1, 2, 3);
    Vector v2 = new Vector(-2, -4, -6);
    Vector v3 = new Vector(0, 3, -2);

    /**
     * Test method for{@Link primitives.Vector#dotProduct()(primitives.Vector)}
     */
    @Test
    public void TestdotProduct() {
        // ============ Equivalence Partitions Tests ==============
        assertEquals("dotProduct() for orthogonal vectors is not zero",v1.dotProduct(v3),0,0);
        // ============ Equivalence Partitions Tests ==============
        assertEquals("dotProduct() wrong value",v1.dotProduct(v2) ,28,0);
   /*

        // test Cross-Product
        try { // test zero vector
            v1.crossProduct(v2);
            out.println("ERROR: crossProduct() for parallel vectors does not throw an exception");
        } catch (Exception e) {
        }
        Vector vr = v1.crossProduct(v3);
        if (!isZero(vr.length() - v1.length() * v3.length())) {
            out.println("ERROR: crossProduct() wrong result length");
            if (!isZero(vr.dotProduct(v1)) || !isZero(vr.dotProduct(v3)))
                out.println("ERROR: crossProduct() result is not orthogonal to its operands");
        }
*/
    }

    /**
     * Test method for {@link primitives.Vector#crossProduct(primitives.Vector)}.
     */
    @Test
    public void TestcrossProduct() {
        // ============ Equivalence Partitions Tests ==============
        Vector vr = v1.crossProduct(v3);
        assertEquals("crossProduct() wrong result length",vr,v1.length() * v3.length());
    }

    /**
     * Test method for {@link primitives.Vector#lengthSquared()(primitives.Vector)}.
     */
    @Test
    public void TestlengthSquared() {
        // ============ Equivalence Partitions Tests ==============
        Vector _v=new Vector(1, 2, 3);
        assertEquals("Wrong squared length", 14, _v.lengthSquared(),0);
    }

    /**
     * Test method for{@Link primitives.Vector#length()(primitives.Vector)}
     */
    @Test
    public void Testlength() {
        // ============ Equivalence Partitions Tests ==============
        Vector _v=new Vector(0, 3, 4);
        assertEquals("Wrong squared length", 5, _v.lengthSquared(),0);
    }

    /*Vector vCopyNormalize = vCopy.normalize();

		if (!isZero(vCopyNormalize.length() - 1))
			out.println("ERROR: normalize() result is not a unit vector");
		Vector u = v.normalized();
		if (u == v)
			out.println("ERROR: normalizated() function does not create a new vector");
		*/

    /**
     * Test method for{@Link primitives.Vector#normalize()(primitives.Vector)}
     */
    @Test
    public void normalize() {
        // ============ Equivalence Partitions Tests ==============
        Vector vNormalize = v1.normalize();
        assertEquals("normalize() function creates a new vector",v1,vNormalize);

        assertEquals("normalize() result is not a unit vector",1, vNormalize.length(),0);
    }

    /**
     * Test method for{@Link primitives.Vector#normalized()(primitives.Vector)}
     */
    @Test
    public void normalized() {
    }

}