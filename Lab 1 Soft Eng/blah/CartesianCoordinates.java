package blah;
public class CartesianCoordinates extends PointCP {
	public CartesianCoordinates(double X, double Y) {
		super('C', X, Y);
	}
	public void convertStorageToPolar() {}
	public void convertStorageToCartesian() {}
	
	public String toString()
	{
		return "Stored as Cartesian" + getX() + "," + getY() + "/n Converted to Polar ["  + getRho() + " , " + getTheta() + "]";
	}
}