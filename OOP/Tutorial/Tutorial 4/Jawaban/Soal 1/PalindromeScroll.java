public class PalindromeScroll extends Scroll {

    public PalindromeScroll(String content) {
        super(content);
    }

    @Override
    public String process() {
        String reversed = new StringBuilder(content).reverse().toString();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < content.length(); i++) {
            char orig = content.charAt(i);
            char rev  = reversed.charAt(i);
            if (!java.lang.Character.isAlphabetic(orig)) {
                sb.append(java.lang.Character.toLowerCase(rev));
            } else {
                sb.append(rev);
            }
        }
        return sb.toString();
    }

    public boolean isPalindrome() {
        String cleaned = content.replaceAll("\\s+", "").toLowerCase();
        String reversed = new StringBuilder(cleaned).reverse().toString();
        return cleaned.equals(reversed);
    }

    @Override
    public String toString() {
        return "[PALINDROME] " + content;
    }
}