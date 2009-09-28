package design3;
public class CartesianCoordinates extends design3.PointCP {
    public CartesianCoordinates(double X, double Y) 
    {
        super('C', X, Y);
    }
    
    public String toString()
    {
        return "Stored as Cartesian" + getX() + "," + getY() + "/n Converted to Polar ["  + getRho() + " , " + getTheta() + "]";
    }
}