public class Checkout {

    public PaymentStrategy ps;

    public Checkout() {
        this.ps = null;
    }

    public void setPaymentStrategy(PaymentStrategy ps){
        this.ps = ps;
    };

    public void processPayment(int amount) {
        if (ps == null) {
            System.out.println("No payment method selected");
        } else {
            ps.pay(amount);
        }
    }


}