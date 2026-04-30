public abstract class Barang {
    protected String nama;
    protected int harga;

    public Barang(String nama, int harga) {
        this.nama = nama;
        this.harga = harga;
        // TODO: implementasi
    }

    public String getNama() {
        // TODO: implementasi
        return this.nama;
    }

    public int getHarga() {
        // TODO: implementasi
        return this.harga;
    }

    public abstract String info();
}
