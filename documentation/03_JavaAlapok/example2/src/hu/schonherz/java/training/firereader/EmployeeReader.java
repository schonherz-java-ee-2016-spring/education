package hu.schonherz.java.training.firereader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import hu.schonherz.java.training.pojo.Employee;

public class EmployeeReader {

  private static final String SUBDIRECTORY = "files";
  private static final String FILENAME = "employees.txt";
  
  //Will it works under Linux?                       ¡¡¡¡
  private static File file = new File(SUBDIRECTORY + File.separator + FILENAME);
  
  /**
   * @return List of employees which has been found in employees.txt file
   */
  public static List<Employee> read() {
    // Hint: BufferedReader usage
    List<Employee> result = new LinkedList<Employee>();
    /*
     * Alternative solution
    Scanner sc = new Scanner(file);
    while(sc.hasNext()) {
      
    }*/
    try {
      BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
      String line;
      while((line = bufferedReader.readLine()) != null) {
        String[] attributes = line.split(",");
        Employee employee = new Employee(attributes[0], Integer.parseInt(attributes[1]));
        result.add(employee);
      }
      bufferedReader.close();
      
    } catch (IOException e) {
      System.out.println("File is not found");
    }
    return result;
  }
  
}
