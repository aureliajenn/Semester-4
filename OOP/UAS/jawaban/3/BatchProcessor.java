import java.util.List;
import java.util.Locale;

// Kelas yang mengimplementasikan Runnable dan memproses sebagian dari daftar batch secara paralel.
public class BatchProcessor implements Runnable {
    private final List<DataBatch<? extends Number>> batches;
    private final int threadIndex;
    private final String[] logs;
    private final int[] totalItems;
    private final Object lock;

    // Simpan semua parameter ke atribut.
    public BatchProcessor(List<DataBatch<? extends Number>> batches, int threadIndex, String[] logs,
                          int[] totalItems, Object lock) {
        this.batches = batches;
        this.threadIndex = threadIndex;
        this.logs = logs;
        this.totalItems = totalItems;
        this.lock = lock;
    }

    @Override
    public void run() {
        // 1. Panggil ThreadTracker.mark() sebagai baris pertama.
        ThreadTracker.mark();

        // 2. Bangun string log untuk thread ini dan simpan ke logs[threadIndex].
        //    Format:
        //      Thread <threadIndex>:
        //      Batch <label>: sum = <sum>
        //      Batch <label>: sum = <sum>
        //      ...
        //    Gunakan format %.1f untuk sum dengan Locale.US.
        StringBuilder sb = new StringBuilder();
        sb.append("Thread ").append(threadIndex).append(":\n");
        int localCount = 0;
        for (DataBatch<? extends Number> batch : batches) {
            sb.append(String.format(Locale.US, "Batch %s: sum = %.1f", batch.getLabel(), batch.sum()));
            sb.append("\n");
            localCount += batch.getItems().size();
        }
        logs[threadIndex] = sb.toString();

        // 3. Hitung total elemen dari semua batch yang ditugaskan ke thread ini.
        // (sudah dihitung di atas sebagai localCount)

        // 4. Update totalItems[0] secara thread-safe menggunakan lock.
        synchronized (lock) {
            totalItems[0] += localCount;
        }
    }
}