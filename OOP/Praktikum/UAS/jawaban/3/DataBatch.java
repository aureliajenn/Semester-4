import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Kelas generik yang merepresentasikan satu batch data sensor berlabel.
// Kelas ini harus dapat menampung nilai numerik dari berbagai tipe.
public class DataBatch<T extends Number> {
    private final String label;
    private final List<T> items;

    // Membuat batch baru dengan label yang diberikan. Inisialisasi list items sebagai kosong.
    public DataBatch(String label) {
        items = new ArrayList<>();
        this.label = label;
    }

    // Menambahkan satu item ke dalam batch.
    public void add(T item) {
        this.items.add(item);
    }

    // Mengembalikan daftar item (tidak dapat dimodifikasi).
    public List<T> getItems() {
        return Collections.unmodifiableList(items);
    }

    // Mengembalikan label batch ini.
    public String getLabel() {
        return label;
    }

    // Menghitung total nilai semua item sebagai double.
    // Gunakan .doubleValue() saat mengkonversi setiap item.
    public double sum() {
        double total = 0;
        for (T item : items) {
            total += item.doubleValue();
        }
        return total;
    }
}