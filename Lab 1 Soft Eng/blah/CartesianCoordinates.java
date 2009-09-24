package blah;
public class CartesianCoordinates extends AbstractPoint {
	public CartesianCoordinates(double X, double Y) {
		super(blah.AbstractPoint.CARTESIAN, X, Y);
	}
	
	public double getDistance(AbstractPoint pointB)
	{
		return 1;
	}
	
	public AbstractPoint rotatePoint(double rotation)
	{
		CartesianCoordinates q = new CartesianCoordinates(2, 3);
		return q;
	}
	
	public String toString()
	{
		return "Stored as Cartesian" + getX() + "," + getY() + "/n Converted to Polar ["  + getRho() + " , " + getTheta() + "]";
	}
}