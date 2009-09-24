package blah;
public class PolarCoordinates extends PointCP {
	public PolarCoordinates(double X, double Y) {
		super(blah.AbstractClass.POLAR, X, Y);
	}
	
	public String toString()
	{
		return "Stored as Cartesian" + getX() + "," + getY() + "/n Converted to Polar ["  + getRho() + " , " + getTheta() + "]";
	}
}