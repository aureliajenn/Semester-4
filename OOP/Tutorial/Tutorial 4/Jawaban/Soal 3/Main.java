import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        Courier[] couriers = new Courier[n];
        String[] items = new String[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            int speed   = sc.nextInt();
            String item = sc.next();
            sc.nextLine();

            if (type.equals("B")) {
                couriers[i] = new BikeCourier(name, speed);
            } else {
                couriers[i] = new CarCourier(name, speed);
            }
            items[i] = item;
        }

        for (int i = 0; i < n; i++) {
            System.out.println(couriers[i]);
            System.out.println(couriers[i].deliver(items[i]));
        }

        double total = 0;
        boolean fast = false;
        for (int i = 0; i < n; i++) {
            total += couriers[i].getSpeed();
            if (couriers[i].getSpeed() > 40) fast = true;
        }

        double avg = (n == 0) ? 0.00 : total / n;
        System.out.printf("Average speed: %.2f%n", avg);
        System.out.println("Fast? " + fast);

        sc.close();
    }
}