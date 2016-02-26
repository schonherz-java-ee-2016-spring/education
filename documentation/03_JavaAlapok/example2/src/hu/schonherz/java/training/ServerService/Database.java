package hu.schonherz.java.training.ServerService;

public interface Database {
  
  public enum Status {RUNNING, STOPPED}
  
  /**
   * Tell the status of Database
   * @return String of status of Database
   */
  public String getStatus();
  
  /**
   * Tell the URL connection of the Database
   * @return Sting of URL connection to the Database
   */
  public String getConnectionURL();
  
}
