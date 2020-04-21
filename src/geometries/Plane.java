package geometries;

import primitives.Point3D;
import primitives.Vector;

public class Plane implements Geometry {

    Point3D _p;
    Vector _normal;

    public Plane(Vector vec, Point3D point) {
        _normal = vec;
        _p = point;
    }

    public Plane(Point3D point1, Point3D point2, Point3D point3){
        _p = point1;
        Vector v1 = new Vector(point1.subtract(point2));
        Vector v2 = new Vector(point3.subtract(point2));

        if (v1.onSameVector(v2)) {
            throw new IllegalArgumentException("These 3 points are on the same vector");
        }
        _normal = v1.crossProduct(v2).normalized().scale(-1);
    }


    /**
     * the func calculate the normal
     * @return
     */
    @Override
    public Vector getNormal(Point3D point) {
        return null;
    }

    public Vector getNormal() {
        return this._normal;
    }
}
