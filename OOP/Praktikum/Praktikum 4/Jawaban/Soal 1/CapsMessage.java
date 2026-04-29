public class CapsMessage extends Pesan{
    public CapsMessage(String konten) {
        super(konten);
    }

    @Override
    public String process() {
        return konten.toUpperCase();
    }
    public int countVowels() { 
        int count = 0;
        for (char c : konten.toLowerCase().toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count++;
            }
        }
        return count;
    }
    @Override
    public String toString() {
        return "[CAPS] " + konten;
    }
    
}
