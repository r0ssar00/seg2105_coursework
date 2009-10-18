/*
  ChatClient only handles a basic connection and assumes it will never terminate.
  This class handles connection closes.
*/

package client;
import ocsf.client.*;
import common.*;
import java.io.*;

public class ClosingClient extends ChatClient {
  public ClosingClient(String host, int port, ChatIF clientUI) 
    throws IOException 
  {
    super(host, port, clientUI); //Call the superclass constructor
  }
  protected void connectionClosed()
  {
    System.out.println("Connection closed!  Exiting...");
    System.exit(1);
  }
  protected void connectionException(Exception exception)
  {
    System.out.println("Connection exception: " + exception.getMessage());
    exception.printStackTrace();
    System.exit(1);
  }
}
