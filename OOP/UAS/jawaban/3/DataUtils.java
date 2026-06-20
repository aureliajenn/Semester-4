import java.util.Iterator;
import java.util.List;

// Kelas utilitas dengan dua method statis untuk agregasi data.
// Method-method ini harus dapat menerima list batch dengan tipe numerik apapun
// (integer maupun desimal) tanpa duplikasi kode.
public class DataUtils {

    // Menjumlahkan hasil sum() dari semua batch. Kembalikan hasilnya sebagai double.
    public static double totalSum(List<DataBatch<? extends Number>> batches) {
        double total = 0;
        for (DataBatch<? extends Number> batch : batches) {
            total += batch.sum();
        }
        return total;
    }

    // Mencari nilai item terbesar dari seluruh batch sebagai double.
    // Iterasi semua batch dan semua item, gunakan .doubleValue().
    // Mulai dari Double.NEGATIVE_INFINITY.
    public static double findMax(List<DataBatch<? extends Number>> batches) {
        double max = Double.NEGATIVE_INFINITY;
        Iterator<DataBatch<? extends Number>> it = batches.iterator();
        while (it.hasNext()) {
            DataBatch<? extends Number> batch = it.next();
            for (Number item : batch.getItems()) {
                double val = item.doubleValue();
                if (val > max) {
                    max = val;
                }
            }
        }
        return max;
    }
}