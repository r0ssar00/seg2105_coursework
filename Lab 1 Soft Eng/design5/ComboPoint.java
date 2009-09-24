package design5;
public class ComboPoint extends AbstractPoint
{
	int typeCoord;
	double xOrRho, yOrTheta;
	public ComboPoint(int typeCoord, double xOrRho, double yOrTheta)
	{
		super(typeCoord, xOrRho, yOrTheta);
		this.xOrRho = xOrRho;
		this.yOrTheta = yOrTheta;
		this.typeCoord = typeCoord;
	}
	
	public double getX()
	{
		if (typeCoord==design3.AbstractPoint.CARTESIAN)
		{
			return super.getX();
		} else
		{
			return xOrRho;
		}
	}
	
	public double getY()
	{
		if (typeCoord==design3.AbstractPoint.CARTESIAN)
		{
			return super.getY();
		} else
		{
			return yOrTheta;
		}
	}
	
	public double getRho()
	{
		if (typeCoord==design3.AbstractPoint.POLAR)
		{
			return super.getRho();
		} else
		{
			return xOrRho;
		}
	}
	
	public double getTheta()
	{
		if (typeCoord==design3.AbstractPoint.POLAR)
		{
			return super.getTheta();
		} else
		{
			return yOrTheta;
		}
	}
	
	public AbstractPoint rotatePoint(double rotation)
	{
		if (typeCoord==design3.AbstractPoint.POLAR)
		{
			return new PolarCoordinates(getRho(), ((getTheta()+rotation) % 360));
		} else
		{
			return new CartesianCoordinates(getX(), getY()).rotatePoint(rotation);
		}
	}
	
	public String toString()
	{
		return "Stored as Polar" + getRho() + "," + getTheta() + "/n Stored as Cartesian ["  + getX() + " , " + getY() + "]";
	}
}