package design5;

import design4.ComboPoint;
import design4.PointCP;

public class PerformanceTest 
{
	public static void main(String[] args)
	{
		double arg0 = 100;
		double arg1 = 999;
		
		double InitialTime = System.currentTimeMillis();
		double FinalTime;
		double DifferenceTime;
		
		for (int i = 0; i < 500000; i++)
		{
			AbstractPoint point = new CartesianPoint(arg0, arg1);
			AbstractPoint point2 = new PolarPoint (arg0, arg1);
			point.getRho();
			point.getTheta();
			point2.getX();
			point2.getY();
			point2.rotatePoint(100);
			point2.rotatePoint(100);
			point2.rotatePoint(100);
			point2.rotatePoint(60);
			point = new CartesianPoint(arg0, arg1);
			double x = getDistance(point);
			
		}
		
		FinalTime = System.currentTimeMillis();
		DifferenceTime = FinalTime - InitialTime;
		System.out.print(DifferenceTime);
	}
}
