import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExceptionDemo {
  public static void main(String[] args) throws FileNotFoundException {

    try{
      int zero = 0;
      int dive = 9/zero;
      System.out.println(dive);
    }catch (ArithmeticException e){
      System.out.println(e);
    }

    try{
      List<String> list = null;
      System.out.println(list.size());
    }catch (NullPointerException e){
      System.out.println(e);
    }

    try{
      FileInputStream inputStream = new FileInputStream("check.txt");
    }catch (FileNotFoundException e){
      System.out.println(e);
    }
  }
}
