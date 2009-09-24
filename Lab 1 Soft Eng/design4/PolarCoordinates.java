package design4;
public class PolarCoordinates extends AbstractPoint {
	public PolarCoordinates(double Rho, double Theta) {
		super(AbstractPoint.POLAR, Rho, Theta);
	}
	
	public AbstractPoint rotatePoint(double rotation)
	{
		return new PolarCoordinates(xOrRho, ((yOrTheta+rotation) % 360));
	}
	
	public String toString()
	{
		return "Stored as Polar" + getRho() + "," + getTheta() + "/n Converted to Cartesian ["  + getX() + " , " + getY() + "]";
	}
}