package primitives;

import static primitives.Util.isZero;

public class Point3D {
    static Point3D ZERO=new Point3D(0,0,0);

    final private double _xCoordinate;
    final private double _yCoordinate;
    final private double _zCoordinate;

    /*static Point3D ZERO(0,0,0);*/

    public Point3D(Coordinate x,Coordinate y,Coordinate z) {
        _xCoordinate = x.get();
        _yCoordinate = y.get();
        _zCoordinate = z.get();
    }

    public Point3D(double x,double y,double z) {
        _xCoordinate = x;
        _yCoordinate = y;
        _zCoordinate = z;
    }

    public Point3D(Point3D point3D) {
        _xCoordinate = point3D._xCoordinate;
        _yCoordinate = point3D._yCoordinate;
        _zCoordinate = point3D._zCoordinate;
    }

    public double  getX(){return _xCoordinate;}

    public double  getY(){return _yCoordinate;}

    public double  getZ(){return _zCoordinate;}

    public Vector subtract(Point3D point){
        return new Vector(this.getX()-point.getX(),this.getY()-point.getY(),this.getZ()-point.getZ());
    }

    public Point3D add(Vector vectorToAdd){
        return new Point3D(_xCoordinate + vectorToAdd.get().getX(),
                           _yCoordinate + vectorToAdd.get().getY(),
                           _zCoordinate + vectorToAdd.get().getZ());
    }

    public double distanceSquared(Point3D point){
        double sumOfPows=(this.getX()-point.getX()) * (this.getX()-point.getX())+
                         (this.getY()-point.getY()) * (this.getY()-point.getY())+
                         (this.getZ()-point.getZ()) * (this.getZ()-point.getZ());
        return sumOfPows;
    }

    public double distance(Point3D point){
        return Math.pow(distanceSquared(point),0.5);
    }

    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Point3D)) return false;
        return (isZero(_xCoordinate - ((Point3D)obj)._xCoordinate)&&
                isZero(_yCoordinate - ((Point3D)obj)._yCoordinate)&&
                isZero(_zCoordinate - ((Point3D)obj)._zCoordinate));
    }

    public String toString() {
        return "X:" + _xCoordinate + " Y:" + _yCoordinate + " Z:" + _zCoordinate;
    }

}

