package hu.schonherz.java.training.pojo;

import java.util.List;

public class Developer extends Employee{
  
  
  private static final long serialVersionUID = -3936601396418860868L;
  private List<String> tasks;
  // override the name attribute of super class
  //private int name;
  
  public Developer() {
    super();
  }
  
  // Override a methode
  /*@Override
  public void setName(final String name) {
    // Employee setName method will be used
    super.setName(name);
    
    // could not modify the name, cause the final modifier
    //name = "Noa name";
    
    // access the super class attribute
    super.name = name;
    // access this class attribute
    this.name = 123;
  }*/

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
