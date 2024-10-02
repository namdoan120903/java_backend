package oop;
class Mobile{
  private String manufacturer;
  private String operating_system;
  private String model;
  private int cost;

  public Mobile(String manufacturer, String operating_system, String model, int cost) {
    this.manufacturer = manufacturer;
    this.operating_system = operating_system;
    this.model = model;
    this.cost = cost;
  }

  public String getManufacturer() {
    return this.manufacturer;
  }

  public void printModel() {
    System.out.println("This is mobile device");
  }
}

interface MobileConnect{
  void connect();
}

class Android extends Mobile{
  private String androidId;
  public Android(String manufacturer, String operating_system, String model, int cost, String androidId) {
    super(manufacturer, operating_system, model, cost);
    this.androidId = androidId;
  }

  public void printModel(){
    System.out.println("This is a android device " + androidId);
  }
  public void alarm(){
    System.out.println("This is a android device alarm ");
  }
  public void alarm(String app){
    System.out.println("This is a android device alarm " + app);
  }
}

class Iphone extends Mobile{
  private String iphoneId;
  public Iphone(String manufacturer, String operating_system, String model, int cost, String iphoneId) {
    super(manufacturer, operating_system, model, cost);
    this.iphoneId = iphoneId;
  }
  public void printModel(){
    System.out.println("This is an iphone device " + iphoneId);
  }
}

class AndroidConnect implements MobileConnect{

  @Override
  public void connect() {
    System.out.println("Connect to android device");
  }
}

class IphoneConnect implements MobileConnect{

  @Override
  public void connect() {
    System.out.println("Connect to iphone device");
  }
}


class MobileConnectionFactory {
  private MobileConnect mobileConnect;

  public MobileConnectionFactory(MobileConnect mobileConnect){
    this.mobileConnect = mobileConnect;
    mobileConnect.connect();
  }
}

public class Demo {
  public static void main(String[] args){
    Mobile mobile = new Mobile("Nokia", "Android","Lumia", 1000);
    Mobile android = new Android("Xiaomi", "Android", "Note", 2000, "UID102");
    Mobile iphone = new Iphone("Iphone", "IOS", "15", 2000, "UID100");
    mobile.printModel();
    android.printModel();
    iphone.printModel();

    Android android1 = new Android("Xiaomi", "Android", "Note 13", 2000, "UID103");
    android1.alarm();
    android1.alarm("messenger");

    MobileConnect mobileConnect = new AndroidConnect();
    MobileConnectionFactory mobileConnectionFactory = new MobileConnectionFactory(mobileConnect);
  }
}
