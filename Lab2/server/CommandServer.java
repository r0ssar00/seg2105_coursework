package server;
import java.io.*;
import ocsf.server.*;


public class CommandServer extends AbstractServer {
  //Class variables *************************************************
  
  /**
   * The default port to listen on.
   */
  
  //Constructors ************************************************
  public CommandServer(int port)
  {
    super(port);
  }
  //Instance methods ************************************************
  public void handleMessageFromClient
    (Object msg, ConnectionToClient client)
  {
    System.out.println("Message received: " + msg + " from " + client);
    this.sendToAllClients(msg);
  }
  /**
   * This method handles any messages received from the server
   * @param message The message to send
   */
    public void handleMessageFromServerUI(String message)
  {
    String parsed = "";
    if (!message.startsWith("#") && getNumberOfClients() > 0)
    {
      this.sendToAllClients("SERVER MSG> " + message);
      return;
    } 
    {
      parsed = message.substring(1);
      if (parsed.equals("quit"))
      {
        try
        {
          close();
          System.exit(0);
        }
        catch (IOException ex)
        {
          ex.printStackTrace();
          System.exit(1);
        }
        System.exit(0);
      }
      else if (parsed.equals("stop"))
      {
        stopListening();
      }
      else if (parsed.equals("close"))
      {
        try
        {
          close();
        }
        catch (IOException ex)
        {
          System.out.println("Error: " + ex.getMessage());
          ex.printStackTrace();
        }
      }
      else if (parsed.equals("start"))
      {
        if (isListening())
        {
          System.out.println("Error: already listening");
          return;
        }
        try
        {
          listen();
        }
        catch (IOException ex)
        {
          System.out.println("Error: " + ex.getMessage());
          ex.printStackTrace();
        }
      }
      else if (parsed.startsWith("setport"))
      {
        if (isListening())
        {
          System.out.println("Error: Already listening");
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
      
    }
  }
  /**
   * This method overrides the one in the superclass.  Called
   * when the server starts listening for connections.
   */
  protected void serverStarted()
  {
    System.out.println
      ("Server listening for connections on port " + getPort());
  }
  
  /**
   * This method overrides the one in the superclass.  Called
   * when the server stops listening for connections.
   */
  protected void serverStopped()
  {
    System.out.println
      ("Server has stopped listening for connections.");
  }
}
