package UnitTests;

import org.junit.Test;
import primitives.Vector;

import static java.lang.System.out;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static primitives.Util.isZero;

/**
 * Unit tests for primitives.Vector class
 * @author Or Efarti
 */

public class VectorTests {

    Vector v1 = new Vector(1, 2, 3);
    Vector v2 = new Vector(-2, -4, -6);
    Vector v3 = new Vector(0, 3, -2);

    /**
     * Test method for{@link primitives.Vector#add(Vector)}}
     */
    @Test
    public void testAdd(){
        // ============ Equivalence Partitions Tests ==============
        assertEquals("Vector add isn't correct",new Vector(2,3,4),new Vector(1,1,2).add(new Vector(1,2,2)));
    }

    /**
     * Test method for{@Link primitives.Vector#Substract()(primitives.Vector)}
     */
    @Test
    public void testSubstract(){
        // ============ Equivalence Partitions Tests ==============
        assertEquals("Vector add isn't correct",new Vector(1,1,2),new Vector(2,3,4).subtract(new Vector(1,2,2)));
    }


    /**
     * Test method for{@link primitives.Vector#dotProduct(Vector)}
     */
    @Test
    public void testdotProduct() {
        // ============ Equivalence Partitions Tests ==============
        assertEquals("dotProduct() for orthogonal vectors is not zero",0, v1.dotProduct(v3),0);
        // ============ Equivalence Partitions Tests ==============
        assertEquals("dotProduct() wrong value", -28,v1.dotProduct(v2),0);
    }

    /**
     * Test method for {@link primitives.Vector#crossProduct(primitives.Vector)}.
     */
    @Test
    public void testcrossProduct() {
        // ============ Equivalence Partitions Tests ==============
        Vector vr = v1.crossProduct(v3);
        //if (!isZero(vr.length() - v1.length() * v3.length()))
           assertNotEquals("ERROR: crossProduct() wrong result length",0,vr.length() - v1.length() * v3.length());
    }

    /**
     * Test method for {@link primitives.Vector#lengthSquared()(primitives.Vector)}.
     */
    @Test
    public void testlengthSquared() {
        // ============ Equivalence Partitions Tests ==============
        Vector _v=new Vector(1, 2, 3);
        assertEquals("Wrong squared length", 14, _v.lengthSquared(),0);
    }

    /**
     * Test method for{@Link primitives.Vector#length()(primitives.Vector)}
     */
    @Test
    public void testlength() {
        // ============ Equivalence Partitions Tests ==============
        Vector _v=new Vector(0, 3, 4);
        assertEquals("Wrong squared length", 5, _v.length(),0);
    }

    /**
     * Test method for{@Link primitives.Vector#normalize()(primitives.Vector)}
     */
    @Test
    public void testnormalize() {
        // ============ Equivalence Partitions Tests ==============
        Vector vNormalize = v1.normalize();
        assertEquals("normalize() function creates a new vector",v1,vNormalize);

        assertEquals("normalize() result is not a unit vector",1, vNormalize.length(),0);
    }

    /**
     * Test method for{@Link primitives.Vector#normalized()(primitives.Vector)}
     */

}