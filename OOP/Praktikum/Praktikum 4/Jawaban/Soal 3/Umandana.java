public class Umandana {
    /**
     * Mengembalikan kata yang telah diubah menjadi bahasa Umandana
     * Huruf a menjadi "aiden"
     * Huruf i menjadi "ipri"
     * Huruf u menjadi "upru"
     * Huruf e menjadi "epre"
     * Huruf o menjadi "opro"
     * Huruf mati yang tidak diikuti huruf vokal menjadi huruf tersebut + "es"
     * Suku kata "ng" yang tidak diikuti huruf vokal menjadi "strengen"
     * Suku kata "ng" yang diikuti huruf vokal tetap menjadi "ng"
     * Suku kata "ny" yang diikuti huruf vokal tetap menjadi "ny"
     * Selain ketentuan di atas, huruf/karakter tidak diubah
     * *
     * 
     * @param words
     * @return kata yang telah diubah menjadi bahasa Umandana
     * 
     */
    public static String toUmandana(String words) {
        StringBuilder result = new StringBuilder();
        int n = words.length();
        int i = 0;

        while(i < n) {
            char c = words.charAt(i);
            if(!Character.isLetter(c)) {
                result.append(c);
                i++;
                continue;
            }

            if (c == 'n' && i + 1 < n && words.charAt(i + 1) == 'g') {
                boolean nextIsVowel = (i + 2 < n) && isVowel(words.charAt(i + 2));
                if (nextIsVowel) {
                    result.append("ng");
                } else {
                    result.append("strengen");
                }
                i += 2;
                continue;
            }

            if(c == 'n' && i + 1 < n && words.charAt(i+1) == 'y') {
                boolean nextIsVowel = (i + 2 < n) && isVowel(words.charAt(i + 2));
                if(nextIsVowel) {
                    result.append("ny");
                    i += 2;
                    continue;
                }
                result.append("nes");
                i++;
                continue;
            }

            if (c == 'a') { 
                result.append("aiden"); 
                i++; 
                continue; 
            }
            if (c == 'i') { 
                result.append("ipri");  
                i++; 
                continue; 
            }
            if (c == 'u') { 
                result.append("upru");  
                i++; 
                continue; 
            }
            if (c == 'e') { 
                result.append("epre");  
                i++; 
                continue; 
            }
            if (c == 'o') { 
                result.append("opro");  
                i++; 
                continue; 
            }

            boolean nextIsVowel = (i + 1 < n) && isVowel(words.charAt(i + 1));
            result.append(c);
            if(!nextIsVowel){
                result.append("es");
            }
            i++;
        }
        return result.toString();

    }

    /**
     * Mengembalikan kata Umandana ke bentuk normal
     * *
     * 
     * @param words kata dalam bahasa Umandana
     * @return kata telah diubah ke bentuk normal
     */
    public static String deUmandana(String words) {
        StringBuilder result = new StringBuilder();
        int n = words.length();
        int i = 0;
 
        while (i < n) {
            if (!Character.isLetter(words.charAt(i))) {
                result.append(words.charAt(i));
                i++;
                continue;
            }
 
            if (words.startsWith("strengen", i)) { 
                result.append("ng"); 
                i += 8; 
                continue; 
            }
            if (words.startsWith("aiden", i)) { 
                result.append("a");  
                i += 5; 
                continue; 
            }
            if (words.startsWith("ipri", i)) { 
                result.append("i"); 
                i += 4; 
                continue; 
            }
            if (words.startsWith("upru", i)) { 
                result.append("u");  
                i += 4; continue; 
            }
            if (words.startsWith("epre", i)) { 
                result.append("e");  
                i += 4; continue; 
            }
            if (words.startsWith("opro", i)) { 
                result.append("o");  
                i += 4; 
                continue; 
            }
            if (words.startsWith("ng", i)) { 
                result.append("ng"); 
                i += 2; 
                continue; 
            }
            if (words.startsWith("ny", i)) { 
                result.append("ny"); 
                i += 2; 
                continue; 
            }
 
            char c = words.charAt(i);
            if (!isVowel(c) && i + 2 < n && words.charAt(i + 1) == 'e' && words.charAt(i + 2) == 's') {
                result.append(c);
                i += 3;
                continue;
            }
 
            result.append(c);
            i++;
        }
 
        return result.toString();
    }
 
    private static boolean isVowel(char c) {
        return (c == 'a' || c == 'i' || c == 'u' || c == 'e' || c == 'o');
    }

}