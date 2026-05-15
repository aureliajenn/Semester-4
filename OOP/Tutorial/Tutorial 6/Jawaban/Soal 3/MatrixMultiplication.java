public class MatrixMultiplication {
    
    // Di dalam method run() dalam runnable WAJIB panggil ThreadTracker.mark();
    // Misal :
    // new Thread(() -> {
    //     ThreadTracker.mark(); <- tambahkan ini ketika ingin submit jawaban
    //     //kode lainnya
    // });
    //
    // Atau
    //
    // run(){
    //   ThreadTracker.mark(); <- tambahkan ini ketika ingin submit jawaban
    //   //kode lainnya
    // }
    
    public static int[][] multiply(int[][] A, int[][] B) {
        int m = A.length;
        int n = A[0].length;
        int p = B[0].length;

        int[][] C = new int[m][p];
        int totalCells = m * p;
        int numThreads = 10;

        Thread[] threads = new Thread[numThreads];
        for (int t = 0; t < numThreads; t++) {
            final int threadIndex = t;
            threads[t] = new Thread(() -> {
                ThreadTracker.mark();
                int start = totalCells * threadIndex / numThreads;
                int end = totalCells * (threadIndex + 1) / numThreads;
                for (int idx = start; idx < end; idx++) {
                    int i = idx / p;
                    int j = idx % p;
                    int sum = 0;
                    for (int k = 0; k < n; k++) {
                        sum += A[i][k] * B[k][j];
                    }
                    C[i][j] = sum;
                }
            });
            threads[t].start();
        }

        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return C;
    }
}
