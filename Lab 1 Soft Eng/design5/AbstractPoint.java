package design5;

public abstract class AbstractPoint
{
	public static final int CARTESIAN = 0;
	public static final int POLAR = 1;
	char typeCoord;
	double xOrRho;
	double yOrTheta;
	public AbstractPoint(char typeCoord, double xOrRho, double yOrTheta)
	{
		if (typeCoord != design5.AbstractPoint.CARTESIAN || typeCoord != design5.AbstractPoint.POLAR)
			throw new IllegalArgumentException();
		this.typeCoord = typeCoord;
		this.xOrRho = xOrRho;
		this.yOrTheta = yOrTheta;
	}
	public double getX()
	{
		if(typeCoord == design5.AbstractPoint.CARTESIAN) 
			return xOrRho;
		else 
			return (Math.cos(Math.toRadians(yOrTheta)) * xOrRho);
	}
	
	public double getY()
	{
		if(typeCoord == design5.AbstractPoint.CARTESIAN) 
			return yOrTheta;
		else 
			return (Math.sin(Math.toRadians(yOrTheta)) * xOrRho);
	}

	public double getRho()
	{
		if(typeCoord == design5.AbstractPoint.POLAR) 
			return xOrRho;
		else 
			return (Math.sqrt(Math.pow(xOrRho, 2) + Math.pow(yOrTheta, 2)));
	}

	public double getTheta()
	{
		if(typeCoord == design5.AbstractPoint.POLAR)
			return yOrTheta;
		else 
			return Math.toDegrees(Math.atan2(yOrTheta, xOrRho));
	}
	
	public double getDistance(CartesianCoordinates pointB)
	{
		// Obtain differences in X and Y, sign is not important as these values
		// will be squared later.
		double deltaX = getX() - pointB.getX();
		double deltaY = getY() - pointB.getY();
	 
		return Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
	}
	
	public abstract AbstractPoint rotatePoint(double rotation);
	
	public abstract String toString();
}