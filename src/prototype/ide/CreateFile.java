package prototype.ide;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateFile {
  public static boolean save(String pathTO, String txt) {
    try {
      File myObj = new File(pathTO);
      
      if (myObj.createNewFile()) {
    	  FileWriter myWriter = new FileWriter(pathTO);  
    	System.out.println("File created: " + myObj.getName());
    	myWriter.write(txt);
        myWriter.close();
      } else {
    	  FileWriter myWriter = new FileWriter(pathTO);
        System.out.println("File already exists.");
        myWriter.write(txt);
        myWriter.close();
        return false;
      }
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    return true;
  }
}