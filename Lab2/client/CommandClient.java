/*
  ChatClient only handles a basic connection and assumes it will never terminate.
  This class handles connection closes.
*/

package client;
import ocsf.client.*;
import common.*;
import java.io.*;

public class CommandClient extends ChatClient {
  public CommandClient(String host, int port, ChatIF clientUI) 
    throws IOException 
  {
    super(host, port, clientUI); //Call the superclass constructor
  }
  protected void connectionException(Exception exception)
  {
    System.out.println("Connection exception: " + exception.getMessage());
    exception.printStackTrace();
    System.exit(1);
  }
  public void handleMessageFromClientUI(Object message)
  {
    String parsed = "";
    if (!((Message)message).message.startsWith("#") && isConnected())
    {
      super.handleMessageFromClientUI(message);
      return;
    } 
    {
      parsed = ((Message)message).message.substring(1);
      if (parsed.equals("quit"))
      {
        try
        {
          closeConnection();
        }
        catch (IOException ex)
        {
          ex.printStackTrace();
          System.exit(1);
        }
        System.exit(0);
      }
      else if (parsed.equals("logoff"))
      {
        try
        {
          closeConnection();
        }
        catch (IOException ex)
        {
          ex.printStackTrace();
          System.exit(1);
        }
      }
      else if (parsed.equals("login"))
      {
        if (isConnected())
        {
          System.out.println("Error: Already connected");
          return;
        }
        try
        {
          openConnection();
        }
        catch (IOException ex)
        {
          System.out.println("Error: " + ex.getMessage());
          ex.printStackTrace();
        }
      }
      else if (parsed.startsWith("sethost"))
      {
        if (isConnected())
        {
          System.out.println("Error: Already connected");
          return;
        } 
        else
        {
          String host = "";
          try 
          {
            host = parsed.split(" ")[1];
          }
          catch (ArrayIndexOutOfBoundsException ex)
          {
            System.out.println("Error: Must specify host");
            return;
          }
          setHost(host);
        }
      }
      else if (parsed.startsWith("setport"))
      {
        if (isConnected())
        {
          System.out.println("Error: Already connected");
          return;
        } 
          int port = 0;
          try 
          {
            port = Integer.parseInt(parsed.split(" ")[1]);
          }
          catch (ArrayIndexOutOfBoundsException ex)
          {
            System.out.println("Error: Must specify port");
            return;
          }
          setPort(port);
      }
      else if (parsed.equals("getport"))
      {
        System.out.println("Port: " + getPort());
      }
      else if (parsed.equals("gethost"))
      {
        System.out.println("Host: " + getHost());
      }
      
    }
  }
}
