package design4;

public class ComboPoint extends PointCP
{
	char typeCoord;
	double xOrRho, yOrTheta;
	public ComboPoint(char typeCoord, double xOrRho, double yOrTheta)
	{
		super(typeCoord, xOrRho, yOrTheta);
		this.xOrRho = xOrRho;
		this.yOrTheta = yOrTheta;
		this.typeCoord = typeCoord;
	}
	
	public double getX()
	{
		if (typeCoord=='P')
		{
			return super.getX();
		} 
		else
		{
			return xOrRho;
		}
	}
	
	public double getY()
	{
		if (typeCoord=='C')
		{
			return super.getY();
		} 
		else
		{
			return yOrTheta;
		}
	}
	
	public double getRho()
	{
		if (typeCoord=='P')
		{
			return super.getRho();
		} 
		else
		{
			return xOrRho;
		}
	}
	
	public double getTheta()
	{
		if (typeCoord=='C')
		{
			return super.getTheta();
		} 
		else
		{
			return yOrTheta;
		}
	}
	
	public PointCP rotatePoint(double rotation)
	{
		if (typeCoord=='P')
		{
			return new PointCP(typeCoord, getRho(), ((getTheta()+rotation) % 360));
		} 
		else
		{
			return new PointCP(typeCoord, getX(), getY()).rotatePoint(rotation);
		}
	}
	
	public String toString()
	{
		return "Stored as Polar" + getRho() + "," + getTheta() + "/n Stored as Cartesian ["  + getX() + " , " + getY() + "]";
	}
}