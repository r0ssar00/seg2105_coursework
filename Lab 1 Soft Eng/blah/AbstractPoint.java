abstract class AbstractPoint
{
	public static final int CARTESIAN = 0;
	public static final int POLAR = 1;
	int typeCoord;
	int xOrRho;
	int yOrTheta;
	public AbstractPoint(int typeCoord, int xOrRho, int yOrTheta)
	{
		if (typeCoord != AbstractPoint.CARTESIAN || typeCoord != AbstractPoint.POLAR)
			throw new IllegalArgumentException();
		this.typeCoord = typeCoord;
		this.xOrRho = xOrRho;
		this.yOrTheta = yOrTheta;
	}
	public double getX()
	{
		if(typeCoord == AbstractPoint.CARTESIAN) 
			return xOrRho;
		else 
			return (Math.cos(Math.toRadians(yOrTheta)) * xOrRho);
	}
	
	public double getY()
	{
		if(typeCoord == AbstractPoint.CARTESIAN) 
			return yOrTheta;
		else 
			return (Math.sin(Math.toRadians(yOrTheta)) * xOrRho);
	}

	public double getRho()
	{
		if(typeCoord == AbstractPoint.POLAR) 
			return xOrRho;
		else 
			return (Math.sqrt(Math.pow(xOrRho, 2) + Math.pow(yOrTheta, 2)));
	}

	public double getTheta()
	{
		if(typeCoord == AbstractPoint.POLAR)
			return yOrTheta;
		else 
			return Math.toDegrees(Math.atan2(yOrTheta, xOrRho));
	}
	
	public abstract double getDistance(AbstractPoint pointB);
	
	public AbstractPoint rotatePoint(double rotation)
	{
		double radRotation = Math.toRadians(rotation);
		double X = getX();
		double Y = getY();
	     
		return new AbstractPoint(AbstractPoint.CARTESIAN,(Math.cos(radRotation) * X) - (Math.sin(radRotation) * Y),
		(Math.sin(radRotation) * X) + (Math.cos(radRotation) * Y));
	}
	
	public abstract String toString();
}