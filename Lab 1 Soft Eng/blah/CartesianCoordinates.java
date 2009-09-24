package blah;
public class CartesianCoordinates extends AbstractPoint {
	public CartesianCoordinates(double X, double Y) {
		super(blah.AbstractPoint.CARTESIAN, X, Y);
	}
	
	public abstract double getDistance(AbstractPoint pointB)
	{
	}
	
	public abstract AbstractPoint rotatePoint(double rotation)
	{
	}
	
	public String toString()
	{
		return "Stored as Cartesian" + getX() + "," + getY() + "/n Converted to Polar ["  + getRho() + " , " + getTheta() + "]";
	}
}