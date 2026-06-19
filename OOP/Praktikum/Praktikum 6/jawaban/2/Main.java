import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        // Baca N dan data array
        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        // Baca W = panjang window
        // Baca T = jumlah thread yang diinginkan
        int W = sc.nextInt();
        int T = sc.nextInt();

        if (T <= 0) {
            System.out.println("Jumlah thread harus >= 1");
            sc.close();
            return;
        }

        int M = N - W + 1;
        if (M <= 0) {
            System.out.println("Window tidak valid");
            sc.close();
            return;
        }

        int[] sums = new int[M];
        String[] logs = new String[T];
        Thread[] threads = new Thread[T];

        // 1. Hitung pembagian Thread
        //    Bagi window berurutan ke dalam T threads sedemikian rupa sehingga selisih jumlah window antar thread <= 1.
        //    Jika M tidak habis dibagi T, maka thread dengan indeks lebih kecil akan mendapatkan 1 window ekstra.
        int base = M / T;
        int extra = M % T;
        int start = 0;
        for (int i = 0; i < T; i++) {
            int count = base + (i < extra ? 1 : 0);
            int end = start + count;
            threads[i] = new WindowThread(A, sums, start, end, W, i, logs);
            start = end;
        }

        // 2. Start setiap thread
        for (int i = 0; i < T; i++) {
            threads[i].start();
        }

        // 3. Sinkronisasi semua Thread
        for (int i = 0; i < T; i++) {
            threads[i].join();
        }

        // Output, tidak perlu diubah
        for (int i = 0; i < T; i++) {
            System.out.println(logs[i]);
        }

        sc.close();
    }
}