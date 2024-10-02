import java.util.HashSet;
import java.util.Objects;

class Student{
  private String id;
  private String name;
  private String email;
  private int age;

  Student(String id){
    this.id = id;
  }

  public Student(String id, String name, String email, int age) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.age = age;
  }

  @Override
  public String toString() {
    return "Student{" +
        "id='" + id + '\'' +
        ", name='" + name + '\'' +
        ", email='" + email + '\'' +
        ", age=" + age +
        '}';
  }
  // ghi de equals phai ghi de ca hashcode neu ko se tra ve dia chi doi tuong ko nhat qua voi equals
  @Override
  public boolean equals(Object obj) {
    if(obj instanceof Student){
      Student another = (Student) obj;
      if(this.id.equals(another.id)) return true;
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}

public class EqualHashSet {
  public static void main(String[] args) {
    Student student1 = new Student("123", "Doan Van Nam", "doannam@", 22);
    Student student2 = new Student("123", "Doan Van Nam", "doannam@", 22);
    Student student3 = new Student("345", "Doan Van Nam", "doannam@", 22);
    HashSet<Student> hashSet = new HashSet<>();
    hashSet.add(student1);
    hashSet.add(student2);
    hashSet.add(student3);
    for (Student st : hashSet) {
      System.out.println(st);
    }
  }
}
