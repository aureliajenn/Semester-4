public class BankTransferPayment implements PaymentStrategy {
    public void pay (int amount) {
        System.out.println("Paid $" + String.valueOf(amount) +  " using Bank Transfer");
    }
}