package common;
public class Message implements java.io.Serializable{
  public String user;
  public String message;
  public Message()
  {
    user = "";
    message = "";
  }
  public Message(String _message)
  {
    user = "";
    message = _message;
  }
  public Message(String _user, String _message)
  {
    user = _user;
    message = _message;
  }
  public String toString()
  {
    return user!=""?user + "> " + message:message;
  }
}
