public class RepeatMessage extends Pesan{
    private int n;

    public RepeatMessage(String konten, int n) {
        super(konten);
        this.n = n;
    }
    public int getN() {
        return n;
    }
    @Override
    public String process() {
        String[] words = konten.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String word : words) {
            for (int i = 0; i < n; i++) {
                if (sb.length() > 0){
                    sb.append(" ");
                }
                sb.append(word);
            }
        }
        return sb.toString();
    }
    @Override
    public String toString() {
        return "[REPEAT] " + konten;
    }
    
}
