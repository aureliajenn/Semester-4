public class PangramMessage extends Pesan{
    public PangramMessage(String konten) {
        super(konten);
    }

    @Override
    public String process() {
        String[] words = konten.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            if (sb.length() > 0){
                sb.append(" ");
            }
            sb.append(words[i]);
        }
        return sb.toString();
    }

    public boolean isPangram() {
        boolean[] found = new boolean[26];
        for(char c : konten.toLowerCase().toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                found[c - 'a'] = true;
            }
        }
        for (boolean b : found) {
            if (!b){
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "[PANGRAM] " + konten;
    }
    
}
