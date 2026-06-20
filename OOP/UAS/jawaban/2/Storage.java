import java.util.LinkedHashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class Storage<T> {
    private Map<String, T> data;
    private int capacity;

    public Storage(int capacity) {
        this.capacity = capacity;
        this.data = new LinkedHashMap<>(capacity);
    }

    public void store(String id, T item) throws DuplicateIdException, StorageFullException {
        T object = data.get(id);
        if (object != null) {
            throw new DuplicateIdException(id);
        }
        if(this.data.size() >= capacity){
            throw new StorageFullException();
        }

        this.data.put(id, item);
        // TODO:
        // Tambahkan item ke dalam data dengan id sebagai key.
        // Jika kapasitas sudah penuh, lemparkan StorageFullException.
        // Jika kapasitas belum penuh namun id sudah ada di dalam data, lemparkan DuplicateIdException.
    }

    public T retrieve(String id) throws DataNotFoundException {
        T object = this.data.get(id);
        if (object == null) {
            throw new DataNotFoundException(id);
        } else {
            return object;
        }
        // TODO:
        // Kembalikan item yang sesuai dengan id.
        // Jika id tidak ditemukan, lemparkan DataNotFoundException.
    }

    public void remove(String id) throws DataNotFoundException  {
        // TODO:
        // Hapus item dengan id dari dalam data.
        // Jika id tidak ditemukan, lemparkan DataNotFoundException.
        T  object = this.data.get(id);
        if (object == null) {
            throw new DataNotFoundException(id);
        } else {
            this.data.remove(id);
        }
    }

    public List<T> getAll() {
        // TODO:
        // Kembalikan semua item di dalam data dalam bentuk List.
        return new ArrayList<T>(this.data.values());
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getSize() {
        if (this.data == null) {
            return 0;
        }
        return this.data.size();
    }
}