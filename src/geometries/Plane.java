package geometries;

import primitives.Point3D;
import primitives.Vector;

public class Plane implements Geometry{

    Point3D _p;
    Vector _normal;

    public Plane(Vector vec,Point3D point){
        _normal=vec;
        _p = point;
    }

    public Plane(Point3D point1,Point3D point2,Point3D point3){
        _p = point1;
        Vector v1=new Vector(point1.subtract(point2));
        Vector v2=new Vector(point3.subtract(point2));
        _normal = v1.crossProduct(v2);
    }

    /**
     * the func calculate the normal
     * @return
     */
    public Vector getNormal() {
        return null;
    }
    @Override
    public Vector getNormal(Point3D point) {
        return null;

    }
}
