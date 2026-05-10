public class EWalletPayment implements PaymentStrategy {
    public void pay (int amount){
        System.out.println("Paid $" + String.valueOf(amount) + " using E-Wallet");
    }

}