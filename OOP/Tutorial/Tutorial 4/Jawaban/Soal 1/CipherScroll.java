public class CipherScroll extends Scroll {
    private int shift;

    public CipherScroll(String content, int shift) {
        super(content);
        this.shift = shift;
    }

    public int getShift() {
        return shift;
    }

    private char shiftChar(char c, int s) {
        if (java.lang.Character.isLetter(c)) {
            char base = java.lang.Character.isUpperCase(c) ? 'A' : 'a';
            return (char)(((c - base + s % 26 + 26) % 26) + base);
        }
        return c;
    }

    @Override
    public String process() {
        StringBuilder sb = new StringBuilder();
        for (char c : content.toCharArray()) {
            sb.append(shiftChar(c, shift));
        }
        return sb.toString();
    }

    public String decode() {
        StringBuilder sb = new StringBuilder();
        for (char c : content.toCharArray()) {
            sb.append(shiftChar(c, -shift));
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "[CIPHER] " + content;
    }
}