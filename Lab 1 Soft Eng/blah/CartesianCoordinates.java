package blah;
public class CartesianCoordinates extends PointCP {
	public CartesianCoordinates(double X, double Y) {
		super(blah.AbstractPoint.CARTESIAN, X, Y);
	}
	
	public String toString()
	{
		return "Stored as Cartesian" + getX() + "," + getY() + "/n Converted to Polar ["  + getRho() + " , " + getTheta() + "]";
	}
}