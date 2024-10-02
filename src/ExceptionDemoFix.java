import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class ExceptionDemoFix {

  public static void main(String[] args) {
    try{
      int zero = 0;
      if (zero != 0) {
        int dive = 9 / zero;
        System.out.println(dive);
      } else {
        System.out.println("cant divide by zero ");
      }
    }catch (ArithmeticException e){
      System.out.println(e);
    }

    try{
      List<String> list = new ArrayList<>();
      System.out.println(list.size());
    }catch (NullPointerException e){
      System.out.println(e);
    }

    try{
      File input = new File("check.txt");
      if (input.exists()) {
        FileInputStream inputStream = new FileInputStream("check.txt");
        System.out.println("input successfully");
      } else {
        System.out.println("file is not exist");
      }

    }catch (FileNotFoundException e){
      System.out.println(e);
    }

  }
}
