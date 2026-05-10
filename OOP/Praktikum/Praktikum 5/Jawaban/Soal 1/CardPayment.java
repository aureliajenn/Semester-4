public class CardPayment implements PaymentStrategy {
    
    public void pay (int amount) {
        System.out.println("Paid $" + String.valueOf(amount) + " using Credit Card");
    }
}