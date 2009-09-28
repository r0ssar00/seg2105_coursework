package design5;
public class PolarPoint extends AbstractPoint 
{
	public PolarPoint(double Rho, double Theta) 
	{
		super('P', Rho, Theta);
	}
	
	public AbstractPoint rotatePoint(double rotation)
	{
		return new PolarPoint(xOrRho, ((yOrTheta+rotation) % 360));
	}
	
	public String toString()
	{
		return "Stored as Polar" + getRho() + "," + getTheta() + "/n Converted to Cartesian ["  + getX() + " , " + getY() + "]";
	}
}