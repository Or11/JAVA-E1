package geometries;

import primitives.Point3D;
import primitives.Vector;

public abstract interface Geometry {

    public Vector getNormal(Point3D point);
}
