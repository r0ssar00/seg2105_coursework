// This file contains material supporting section 2.9 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 
package design5;
import java.io.*;

/**
 * This class prompts the user for a set of coordinates, and then 
 * converts them from polar to cartesian or vice-versa.
 *
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Dr Timothy C. Lethbridge
 * @author Paul Holden
 * @version July 2000
 */
public class PointCPTest
{
  //Class methods *****************************************************

  /**
   * This method is responsible for the creation of the PointCP
   * object.  This can be done in two ways; the first, by using the
   * command line and running the program using <code> java 
   * PointCPTest &lt;coordtype (c/p)&gt; &lt;X/RHO&gt; &lt;Y/THETA&gt;
   * </code> and the second by getting the program to prompt the user.
   * If the user does not enter a valid sequence at the command line,
   * the program will prompte him or her.
   *
   * @param args[0] The coordinate type.  P for polar and C for
   *                cartesian.
   * @param args[1] The value of X or RHO.
   * @param args[2] The value of Y or THETA.
   */
   private void printf(String s) {
   	System.out.println(s);
   }
  public static void main(String[] args)
  {
	  AbstractPoint point;
	  AbstractPoint point2 = null;
	  
    System.out.println("Cartesian-Polar Coordinates Conversion Program");

    // Check if the user input coordinates from the command line
    // If he did, create the PointCP object from these arguments.
    // If he did not, prompt the user for them.
    try
    {
    	int arg0 = Integer.valueOf(args[0]);
    	double arg1 = Double.valueOf(args[1]).doubleValue();
    	double arg2 = Double.valueOf(args[2]).doubleValue();
    	if (arg0 == AbstractPoint.CARTESIAN)
    	{
    		printf("CART");
    		point = new CartesianPoint(arg1, arg2);
    		printf("CSETI");
    		setInput(point, point2);
    	}
    	else if (arg0 == AbstractPoint.POLAR)
    	{
    		printf("POL");
        	point = new PolarPoint(arg1, arg2);
    		printf("PSETI");
    		setInput(point, point2);
    	}
        else 
        {
        	printf("NEI");
        	point = getInput();
        	point2 = getInput();
        }
    }
    catch(Exception e)
    {
      // This isn't really needed: e.printStackTrace();
      // If we arrive here, it is because either there were no
      // command line arguments, or they were invalid
      if(args.length != 0)
        System.out.println("Invalid arguments on command line");

      try
      {
        point = getInput();
        setInput(point, point2);
      }
      catch(IOException ex)
      {
        System.out.println("Error getting input. Ending program.");
        return;
      }
    }
    System.out.println("\nYou entered:\n" + point);
    System.out.println("\nAfter asking to store as Cartesian:\n" + point);
    point.convertStorageToPolar();
    System.out.println("\nAfter asking to store as Polar:\n" + point2);
  }

  /**
   * This method obtains input from the user and verifies that
   * it is valid.  When the input is valid, it returns a PointCP
   * object.
   *
   * @return A PointCP constructed using information obtained 
   *         from the user.
   * @throws IOException If there is an error getting input from
   *         the user.
   */
  private static AbstractPoint getInput() throws IOException
  {
    byte[] buffer = new byte[1024];  //Buffer to hold byte input
    boolean isOK = false;  // Flag set if input correct
    String theInput = "";  // Input information
    
    //Information to be passed to the constructor
    char coordType = 'A'; // Temporary default, to be set to P or C
    double a = 0.0;
    double b = 0.0;

    // Allow the user to enter the three different arguments
    for (int i = 0; i < 3; i++)
    {
      while (!(isOK))
      {
        isOK = true;  //flag set to true assuming input will be valid
          
        // Prompt the user
        if (i == 0) // First argument - type of coordinates
        {
          System.out.print("Enter the type of Coordinates you "
            + "are inputting ((C)artesian / (P)olar): ");
        }
        else // Second and third arguments
        {
          System.out.print("Enter the value of " 
            + (coordType == 'C' 
              ? (i == 1 ? "X " : "Y ")
              : (i == 1 ? "Rho " : "Theta ")) 
            + "using a decimal point(.): ");
        }

        // Get the user's input
        System.in.read(buffer);
        theInput = new String(buffer).trim();

        // Verify the user's input
        try
        {
          if (i == 0) // First argument -- type of coordinates
          {
            if (!((theInput.toUpperCase().charAt(0) == 'C') 
              || (theInput.toUpperCase().charAt(0) == 'P')))
            {
              //Invalid input, reset flag so user is prompted again
              isOK = false;
            }
            else
            {
              coordType = theInput.toUpperCase().charAt(0);
            }
          }
          else  // Second and third arguments
          {
            //Convert the input to double values
            if (i == 1)
              a = Double.valueOf(theInput).doubleValue();
            else
              b = Double.valueOf(theInput).doubleValue();
          }
        }
        catch(Exception e)
        {
          System.out.println("Incorrect input.");
          isOK = false;  //Reset flag as so not to end while loop
        }
      }

      //Reset flag so while loop will prompt for other arguments
      isOK = false;
    }
    //Return a new object
    if (coordType == 'C')
    	return (new CartesianPoint(a, b));
    else
    	return (new PolarPoint(a, b));
  }
  
  private static void setInput(AbstractPoint point, AbstractPoint point2)
  {
	  if (point.getType() == AbstractPoint.CARTESIAN)
		  point2 = new PolarPoint(point.getRho(), point.getTheta());
	  else
		  point2 = new CartesianPoint(point.getX(), point.getY());
  }
  
}
