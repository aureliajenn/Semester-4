public class Laci<T> {
    private String label;
    private Object[] items;
    private int count;
    private static final int CAPACITY = 10;

    public Laci(String label) {
        this.label = label;
        this.items = new Object[CAPACITY];
        this.count = 0;
    }

    public boolean simpan(T item) {
        if (count < CAPACITY) {
            items[count] = item;
            count++;
            return true;
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    public T ambil(int i) {
        if (i < 1 || i > count) {
            return null;
        }
        return (T) items[i - 1];
    }

    public void set(int i, T item) {
        if (i >= 1 && i <= count) {
            items[i - 1] = item;
        }
    }

    public int ukuran() {
        return count;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Laci[").append(label).append("]: [");
        for (int i = 0; i < count; i++) {
            sb.append(items[i]);
            if (i < count - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}