import java.util.Optional;

//memiliki default behaviour print "[X] Gerakan tidak valid untuk bidak ini!\n".
public interface Aksi {
    void atas(Optional<Integer> steps);

    void atasKanan(Optional<Integer> steps);

    void atasKiri(Optional<Integer> steps);

    void kanan(Optional<Integer> steps);

    void kiri(Optional<Integer> steps);

    void bawahKanan(Optional<Integer> steps);

    void bawahKiri(Optional<Integer> steps);

    void bawah(Optional<Integer> steps);
}