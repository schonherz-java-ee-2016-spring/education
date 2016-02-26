package hu.schonherz.java.training.main;

import java.util.List;

import hu.schonherz.java.training.firereader.DeveloperReader;
import hu.schonherz.java.training.firereader.EmployeeReader;
import hu.schonherz.java.training.pojo.Developer;
import hu.schonherz.java.training.pojo.Employee;

public class Main {

  /*
   * COURSE AGENDA
   * 
   * Friday - IO, Thread, Exceptions
   * 0) Create branch
   * 1) I/O
   *    a) Read employee from file
   *    b) Read from developers.txt
   *    c) Write to developers.dat
   *    d) Read from developers.dat
   * 2) Threading 
   *    a) Create thread to read up employee and developers (ReaderThread)
   *    b) Play with synchronized
   * 3) Exceptions
   * 
   * Saturday - Annotation, Interfaces, Abstract Classes, Inheritance, Polimorfism, Generics
   * 1) Annotations
   * 2) Create server
   *    a) Windows server
   *    b) Linux server
   *    c) Windows Database server
   *    d) Linux Web server
   *    e) Linux Database and Web server
   * 3) Create Database and Web interface
   *    a) With default getStatus
   * 4) Generics
   * 5) Homework
   */
  public static void main(String[] args) {
    
    List<Employee> employees = EmployeeReader.read();
    for (Employee employee : employees) {
      System.out.println(employee.getName() + " - " + employee.getEmployeeID());
    }
    
    List<Developer> developers = DeveloperReader.readFromTextFile();
    for (Developer developer : developers) {
      System.out.println(developer.getName() + " (" + developer.getEmployeeID() + ")");
      for (String s : developer.getTasks()) {
        System.out.println(s);
      }
    }
    DeveloperReader.writeToBinaryFile(developers);
    
    System.out.println("---------------------------------------------");
    
    List<Developer> dev = DeveloperReader.readFromBinaryFile();
    for (Developer developer : dev) {
      System.out.println(developer.getName() + " (" + developer.getEmployeeID() + ")");
      for (String s : developer.getTasks()) {
        System.out.println(s);
      }
    }
  }
  
  private static void test() {
    System.out.println("kis kacsa");
  }
  
  /*
   * As a manager of the company, I want a real-time report for those servers, which are not running.
   * The report should tell that which system administrator have right for those servers. 
   */
  private static void homework() {
    // TODO unimplemented method
    throw new UnsupportedOperationException("Not implemented yet.");
  }

}
