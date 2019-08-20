package strategypattern;

public interface PayStrategy {
  boolean pay(int paymentAmount);
  void collectPaymentDetails();
}
