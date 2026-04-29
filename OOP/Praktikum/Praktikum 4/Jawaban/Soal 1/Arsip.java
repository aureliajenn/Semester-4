public class Arsip {
    private Pesan[] data;
    private int size;

    public Arsip() {
        data = new Pesan[100];
        size = 0;
    }
    public void tambah(Pesan p) {
        data[size++] = p;
    }
    public Pesan get(int idx) {
        return data[idx-1];
    }
    public int jumlah() {
        return size;
    }
    public int cari(String keyword) {
        int count = 0;
        String k = keyword.toLowerCase();
        for( int i = 0; i < size; i++) {
            if (data[i].getKonten().toLowerCase().contains(k)) {
                count++;
            }
        }
        return count;
    }
    
}
