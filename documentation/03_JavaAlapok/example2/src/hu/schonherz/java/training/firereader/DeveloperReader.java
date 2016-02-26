package hu.schonherz.java.training.firereader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import hu.schonherz.java.training.pojo.Developer;

public class DeveloperReader {
  
  private static final String SUBDIRECTORY = "files";
  private static final String FILENAME = "developers.txt";
  private static final String BINARYFILE = "developers.dat";
  
  private static File file = new File(SUBDIRECTORY + File.separator + FILENAME);
  private static File binaryFile = new File(SUBDIRECTORY + File.separator + BINARYFILE);

  public static List<Developer> readFromTextFile() {
    List<Developer> result = new ArrayList<Developer>();
    try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
      String line;
      while((line = bufferedReader.readLine()) != null) {
        String[] attributes = line.split(",");
        List<String> tasks = new ArrayList<String>();
        for(int i = 2; i<attributes.length; i++) {
          tasks.add(attributes[i]);
        }
        result.add(new Developer(attributes[0], Integer.parseInt(attributes[1]), tasks));
      }
    } catch (IOException e) {
      System.out.println("io error");
    }
    return result;
  }
  
  public static void writeToBinaryFile(List<Developer> developers) {
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(binaryFile));) {
      oos.writeObject(developers);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
  }
  
  @SuppressWarnings("unchecked")
  public static List<Developer> readFromBinaryFile() {
    List<Developer> result = new ArrayList<Developer>();
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(binaryFile))) {
      Object o = ois.readObject();
      /*if (o instanceof ArrayList<?>) {
        result = (List<Developer>) o;
      }*/
      result = (List<Developer>) o;
      
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return result;
  }
}
