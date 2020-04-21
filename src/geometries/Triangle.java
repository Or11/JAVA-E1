package geometries;

import primitives.Point3D;
import primitives.Vector;

public class Triangle extends Polygon {

    public Triangle(Point3D p1, Point3D p2, Point3D p3) {
        super(p1, p2, p3);
        if (!canCreateTriangle(p1, p2, p3)) {
            throw new IllegalArgumentException("Cannot create a triangle from these 3 points");
        }
    }

    private boolean canCreateTriangle(Point3D p1, Point3D p2, Point3D p3) {
        Vector sideOfTriangle = (new Vector(p1)).add(new Vector(p2));
        return !sideOfTriangle.onSameVector(new Vector(p3));
    }
}
