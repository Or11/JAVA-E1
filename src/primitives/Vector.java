package primitives;

import static primitives.Util.isZero;

public class Vector {
    Point3D vector;
    /*
    final double _yVector;
    final double _zVector;
    final double _xVector;
*/

    public Vector(Coordinate x,Coordinate y,Coordinate z){
        vector=new Point3D(x,y,z);
        zeroException();
        /*
        _xVector = x.get();
        _yVector = y.get();
        _zVector = z.get();
        */
    }


    public Vector(double x,double y,double z){
        vector=new Point3D(x,y,z);
        zeroException();
        /*
        _xVector = x;
        _yVector = y;
        _zVector = z;
        */
    }

    public Vector(Point3D point){
        vector=new Point3D(point);
        zeroException();
        /*
        _xVector = point.getX();
        _yVector = point.getY();
        _zVector = point.getZ();
        */
    }


    public Vector(Vector vec){
        vector= new Point3D(vec.vector);
        zeroException();
        /*
        _xVector = vector._xVector;
        _yVector = vector._yVector;
        _zVector = vector._zVector;
    */
    }


    public Vector get(){return this;}

    public Vector add(Vector vec){
        return new Vector( vector.add(vec));
    }

    public Vector subtract(Vector vec){
        return new Vector(vector.subtract(vec.vector));
    }

    public Vector scale(double scaler){
        return new Vector(vector.getX()*scaler,vector.getY()*scaler,vector.getZ()*scaler);
    }

  public double dotProduct(Vector vec){
        return (vec.vector.getX()*vector.getX()+vec.vector.getY()*vector.getY()+vec.vector.getZ()*vector.getZ());
    }

   public Vector crossProduct(Vector vec){
       return new Vector(this.vector.getY()*vec.vector.getZ() - this.vector.getZ()*vec.vector.getY(),
                         this.vector.getZ()*vec.vector.getX() - this.vector.getX()*vec.vector.getZ(),
                         this.vector.getX()*vec.vector.getY() - this.vector.getY()*vec.vector.getX());
   }

   public double lengthSquared(){
       return vector.distanceSquared(Point3D.ZERO);
   }

    public double length(){
       return Math.pow(this.lengthSquared(),0.5);
    }

    /**
     * the func normalize the current vector by dividing the vector in his length
     * @return the normalize vector
     */
    public Vector normalize(){
       vector=new Point3D(vector.getX()/this.length(),vector.getY()/this.length(),vector.getZ()/this.length());
       return this;
    }

    /**
     * the func normalize the current vector by using the normalize func
     * @return a new vector that is the normalize of the current vector
     */
    public Vector normalized(){
        Vector _normalizedVector=new Vector(this);
        return _normalizedVector.normalize();
    }

    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Vector)) return false;
        return (isZero(vector.getX() - ((Vector)obj).vector.getX())&&
                isZero(vector.getY() - ((Vector)obj).vector.getY())&&
                isZero(vector.getZ() - ((Vector)obj).vector.getZ()));
    }

    public void zeroException(){
        if(this.vector.equals(Point3D.ZERO)){
            throw new IllegalArgumentException ("Vector can't be (0,0,0)");
        }
    }

    public String toString() {
        return "X:" + vector.getX() + " Y:" + vector.getY() + " Z:" + vector.getZ();
    }
}
