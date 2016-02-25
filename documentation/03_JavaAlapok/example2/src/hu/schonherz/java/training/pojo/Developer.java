package hu.schonherz.java.training.pojo;

import java.util.List;

public class Developer extends Employee{
  
  private List<String> tasks;
  
  public Developer() {
    super();
  }

  public Developer(String name, int employeeID, List<String> tasks) {
    super(name, employeeID);
    this.tasks = tasks;
  }

  public List<String> getTasks() {
    return tasks;
  }

  public void setTasks(List<String> tasks) {
    this.tasks = tasks;
  }

}
