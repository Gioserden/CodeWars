package strategypattern;

public class CreditCard {
  private int amount;
  private String number;
  private String date;
  private String cvv;

  CreditCard(String number, String date, String cvv) {
    this.amount = 300000;
    this.cvv = cvv;
    this.date = date;
    this.number = number;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }
  public int getAmount() {
    return amount;
  }
}
