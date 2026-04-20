public class CarCourier extends Courier {
    // Implementasi kelas CarCourier di sini
    public CarCourier(String name, int speed) {
        super(name, speed);
    }

    @Override 
    public String toString() {
        return "[Car] " + super.toString();
    }
}