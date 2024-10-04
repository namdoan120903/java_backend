package designPattern;

interface Bank{
  String getBankName();
}

class TpBank implements Bank{

  @Override
  public String getBankName() {
    return "This is TPBank";
  }
}

class VietinBank implements Bank{

  @Override
  public String getBankName() {
    return "This is VietinBank";
  }
}

enum BankType{
  TPBANK, VIETINBANK
}

class BankFactory{
  private BankFactory(){};
  //static ko cần tạo ra đối tượng
  public static Bank getBank(BankType bankType){
    switch (bankType){
      case TPBANK:
        return new TpBank();
      case VIETINBANK:
        return new VietinBank();
      default:
        throw new IllegalArgumentException("Chọn đúng ngân hàng hỗ trợ");
    }
  }

}

public class FactoryPattern {

  public static void main(String[] args) {
    Bank bank = BankFactory.getBank(BankType.VIETINBANK);
    System.out.println(bank.getBankName());
  }
}
