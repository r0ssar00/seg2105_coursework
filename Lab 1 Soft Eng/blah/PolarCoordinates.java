package blah;
public class PolarCoordinates extends AbstractPoint {
	public PolarCoordinates(double Rho, double Theta) {
		super(blah.AbstractClass.POLAR, Rho, Theta);
	}
	
	public abstract double getDistance(AbstractPoint pointB)
	{
	}
	
	public abstract AbstractPoint rotatePoint(double rotation)
	{
		return new PolarCoordinates(xOrRho, ((yOrTheta+rotation) % 360));
	}
	
	public String toString()
	{
		return "Stored as Polar" + getRho() + "," + getTheta() + "/n Converted to Cartesian ["  + getX() + " , " + getY() + "]";
	}
}