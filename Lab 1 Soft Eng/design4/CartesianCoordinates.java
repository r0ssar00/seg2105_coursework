package design4;
public class CartesianCoordinates extends AbstractPoint {
	public CartesianCoordinates(double X, double Y) {
		super(design3.AbstractPoint.CARTESIAN, X, Y);
	}
	
	public AbstractPoint rotatePoint(double rotation)
	{
		double radRotation = Math.toRadians(rotation);
		double X = getX();
		double Y = getY();
     
		return new CartesianCoordinates((Math.cos(radRotation) * X) - (Math.sin(radRotation) * Y),
							(Math.sin(radRotation) * X) + (Math.cos(radRotation) * Y));
	}
	
	public String toString()
	{
		return "Stored as Cartesian" + getX() + "," + getY() + "/n Converted to Polar ["  + getRho() + " , " + getTheta() + "]";
	}
}