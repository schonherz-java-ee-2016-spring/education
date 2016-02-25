package hu.schonherz.java.training.firereader;

import java.io.File;
import java.util.List;

import hu.schonherz.java.training.pojo.Employee;

public class EmployeeReader {

  private static final String SUBDIRECTORY = "files";
  private static final String FILENAME = "employees.txt";
  
  //Will it works under Linux?                       ¡¡¡¡
  private static File file = new File(SUBDIRECTORY + "\\" + FILENAME);
  
  /**
   * @return List of employees which has been found in employees.txt file
   */
  public static List<Employee> read() {
    // TODO unimplemented method
    // Hint: BufferedReader usage
    throw new UnsupportedOperationException("Not implemented yet.");
  }
  
}
