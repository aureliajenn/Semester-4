import java.util.List;

public class DapurJus {
    private DapurJus() {}

    public static void cekBahan(List<? extends Buah> daftarBahan) {
        for (Buah buah : daftarBahan) {
            System.out.println(buah.deskripsi());
        }
    }

    public static int hitungTotalManis(List<? extends Buah> daftarBahan) {
        int total = 0;
        for (Buah buah : daftarBahan) {
            total += buah.getTingkatManis();
        }
        return total;
    }

    public static void buatJusApelDefault(List<? super JusApel> daftarMinuman) {
        daftarMinuman.add(new JusApel("Jus Apel Original"));
        daftarMinuman.add(new JusApel("Jus Apel Madu"));
    }

    public static void cetakRakUmum(List<?> rak) {
        for (Object item : rak) {
            System.out.println(item);
        }
    }
}