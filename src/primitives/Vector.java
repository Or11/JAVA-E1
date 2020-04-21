package primitives;

import static primitives.Util.isZero;

public class Vector {
    private Point3D vector;

    public Vector(Coordinate x, Coordinate y, Coordinate z){
        vector = new Point3D(x,y,z);
        zeroException();
    }

    public Vector(double x, double y, double z) {
        vector = new Point3D(x,y,z);
        zeroException();
    }

    public Vector(Point3D point) {
        vector = new Point3D(point);
        zeroException();
    }

    public Vector(Vector vec) {
        vector = new Point3D(vec.get());
        zeroException();
    }

    public Point3D get() { return vector; }

    public Vector add(Vector vec){
        return new Vector( vector.add(vec));
    }

    public Vector subtract(Vector vec){
        return new Vector(vector.subtract(vec.get()));
    }

    public Vector scale(double scaler) {
        return new Vector(vector.getX() * scaler,vector.getY() * scaler,vector.getZ() * scaler);
    }

    public double dotProduct(Vector vec){
        return (vec.get().getX() * vector.getX() + vec.get().getY() * vector.getY() + vec.get().getZ() * vector.getZ());
    }

    public Vector crossProduct(Vector vec){
        return new Vector(this.vector.getY() * vec.get().getZ() - this.vector.getZ() * vec.get().getY(),
                         this.vector.getZ() * vec.get().getX() - this.vector.getX() * vec.get().getZ(),
                         this.vector.getX() * vec.get().getY() - this.vector.getY() * vec.get().getX());
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
    public Vector normalize() {
       vector = new Point3D(vector.getX() / this.length(),vector.getY() / this.length(),vector.getZ() / this.length());
       return this;
    }

    /**
     * the func normalize the current vector by using the normalize func
     * @return a new vector that is the normalize of the current vector
     */
    public Vector normalized() {
        Vector _normalizedVector = new Vector(this);
        return _normalizedVector.normalize();
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Vector)) return false;
        return (isZero(vector.getX() - ((Vector)obj).get().getX()) &&
                isZero(vector.getY() - ((Vector)obj).get().getY()) &&
                isZero(vector.getZ() - ((Vector)obj).get().getZ()));
    }

    public void zeroException() {
        if (this.vector.equals(Point3D.ZERO)) {
            throw new IllegalArgumentException ("Vector can't be (0,0,0)");
        }
    }

    public String toString() {
        return "X:" + vector.getX() + " Y:" + vector.getY() + " Z:" + vector.getZ();
    }

    public boolean onSameVector(Vector another) {
        return this.scale((double)(another.get().getX() / vector.getX() )).equals(another);
    }
}
