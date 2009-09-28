package design5;
public class CartesianPoint extends AbstractPoint 
{
	public CartesianPoint(double X, double Y) 
	{
		super(AbstractPoint.CARTESIAN, X, Y);
	}
	
	public void convertStorageToPolar() {}
	public void convertStorageToCartesian() {}
	
	public AbstractPoint rotatePoint(double rotation)
	{
		double radRotation = Math.toRadians(rotation);
		double X = getX();
		double Y = getY();
     
		return new CartesianPoint((Math.cos(radRotation) * X) - (Math.sin(radRotation) * Y),
							(Math.sin(radRotation) * X) + (Math.cos(radRotation) * Y));
	}
	
	public String toString()
	{
		return "Stored as Cartesian" + getX() + "," + getY() + "/n Converted to Polar ["  + getRho() + " , " + getTheta() + "]";
	}
}