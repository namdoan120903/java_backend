import com.google.gson.Gson;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
    //serialize();
    //deserialize();
    Gson gson = new Gson();
    Employee employee = new Employee("Nam Doan","5430", 20, "namdoan@");
    //serialize
    String json = gson.toJson(employee);
    System.out.println(json);

    //deserialize
    Employee employee1 = gson.fromJson(json, Employee.class);
    System.out.println(employee1);
    //
    // Json simple
    //Json parse String to Json
    String jsonString = "{\"name\":\"Nam\", \"age\":21, \"city\":\"Ha Noi\"}";
    JSONParser jsonParser = new JSONParser();
    try{
      JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonString);
      System.out.println("Name " + (String)jsonObject.get("name") );
      System.out.println(jsonObject.toString());
    } catch (ParseException e) {
      throw new RuntimeException(e);
    }

  }
}
