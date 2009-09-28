package design5;

public abstract class AbstractPoint
{
	public static final int CARTESIAN = 0;
	public static final int POLAR = 1;
	protected int typeCoord;
	protected double xOrRho;
	protected double yOrTheta;
	public AbstractPoint(int typeCoord, double xOrRho, double yOrTheta)
	{
		if (typeCoord != CARTESIAN && typeCoord != POLAR)
			throw new IllegalArgumentException();
		this.typeCoord = typeCoord;
		this.xOrRho = xOrRho;
		this.yOrTheta = yOrTheta;
	}
	public int getType() {
		return typeCoord;
	}
	public double getX()
	{
		if(typeCoord == CARTESIAN) 
			return xOrRho;
		else 
			return (Math.cos(Math.toRadians(yOrTheta)) * xOrRho);
	}
	
	public double getY()
	{
		if(typeCoord == CARTESIAN) 
			return yOrTheta;
		else 
			return (Math.sin(Math.toRadians(yOrTheta)) * xOrRho);
	}

	public double getRho()
	{
		if(typeCoord == POLAR) 
			return xOrRho;
		else 
			return (Math.sqrt(Math.pow(xOrRho, 2) + Math.pow(yOrTheta, 2)));
	}

	public double getTheta()
	{
		if(typeCoord == POLAR)
			return yOrTheta;
		else 
			return Math.toDegrees(Math.atan2(yOrTheta, xOrRho));
	}
	
	public double getDistance(CartesianPoint pointB)
	{
		// Obtain differences in X and Y, sign is not important as these values
		// will be squared later.
		double deltaX = getX() - pointB.getX();
		double deltaY = getY() - pointB.getY();
	 
		return Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
	}
	
	/**
	* 
	*/
	public void convertStorageToPolar()
	{
		if(typeCoord != POLAR)
		{
			//Calculate RHO and THETA
			double temp = getRho();
			yOrTheta = getTheta();
			xOrRho = temp;
   
			typeCoord = POLAR;  //Change coord type identifier
		}
	}
		
	/**
	* 
	*/
	public void convertStorageToCartesian()
	{
		if(typeCoord != CARTESIAN)
		{
			//Calculate X and Y
			double temp = getX();
			yOrTheta = getY();
			xOrRho = temp;

			typeCoord = CARTESIAN;	//Change coord type identifier
		}

	}
	
	public abstract AbstractPoint rotatePoint(double rotation);
	
	public abstract String toString();
}