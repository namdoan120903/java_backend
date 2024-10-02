import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Employee implements Serializable {
  private String name;
  private String id;
  private int age;
  private String email;

  public Employee(String name, String id, int age, String email) {
    this.name = name;
    this.id = id;
    this.age = age;
    this.email = email;
  }

  @Override
  public String toString() {
    return "Employee{" +
        "name='" + name + '\'' +
        ", id='" + id + '\'' +
        ", age=" + age +
        ", email='" + email + '\'' +
        '}';
  }
}
public class Serialize {
  public static void serialize(){
    Employee employee = new Employee("Nam Doan","5430", 20, "namdoan@");
    try{
      FileOutputStream fileOutputStream = new FileOutputStream("output.txt");
      ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);

      outputStream.writeObject(employee);
      outputStream.close();
      fileOutputStream.close();
      System.out.println("Serialized data in output data");
    }catch (Exception e){
      e.printStackTrace();
    }
  }

  public static void deserialize(){
    Employee employee = null;
    try{
      FileInputStream fileInputStream = new FileInputStream("output.txt");
      ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);

      employee = (Employee) inputStream.readObject();
      inputStream.close();
      fileInputStream.close();
    }catch (Exception e){
      e.printStackTrace();
    }
    System.out.println(employee);
  }

  public static void main(String[] args) {
    serialize();
    deserialize();
  }
}
