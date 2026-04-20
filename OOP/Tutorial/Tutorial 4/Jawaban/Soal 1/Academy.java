import java.util.ArrayList;

public class Academy {
    private ArrayList<Scroll> scrolls = new ArrayList<>();

    public void addScroll(Scroll s) {
        scrolls.add(s);
    }

    public Scroll getScroll(int index) {
        return scrolls.get(index - 1);
    }

    public int search(String keyword) {
        int count = 0;
        String lower = keyword.toLowerCase();
        for (Scroll s : scrolls) {
            if (s.getContent().toLowerCase().contains(lower)) {
                count++;
            }
        }
        return count;
    }

    public int count() {
        return scrolls.size();
    }
}