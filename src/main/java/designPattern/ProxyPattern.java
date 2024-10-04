package designPattern;
interface UserService{
  void loadData();
  void insertData();
}

class UserServiceIpl implements UserService{
  private String name;

  public UserServiceIpl(String name) {
    this.name = name;
  }


  @Override
  public void loadData() {
    System.out.println("Data is showed " + name);
  }

  @Override
  public void insertData() {
    System.out.println("Data is inserted" + name);
  }
}

class ProxyUserService implements UserService{
  private UserService userService;
  private String name;
  private Role role;

  public ProxyUserService(String name, Role role) {
    this.name = name;
    this.role = role;
    userService = new UserServiceIpl(name);

  }

  @Override
  public void loadData() {
    userService.loadData();
  }

  @Override
  public void insertData() {
    if (role.equals(Role.ADMIN)) {
      userService.insertData();
    } else {
      System.out.println("Access denied");
    }
  }
}

enum Role{
  ADMIN, USER, OWNER
}

public class ProxyPattern {

  public static void main(String[] args) {
    ProxyUserService proxyUserService = new ProxyUserService("Nam Doan", Role.USER);
    proxyUserService.loadData();
    proxyUserService.insertData();
  }
}
