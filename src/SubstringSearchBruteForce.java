public class SubstringSearchBruteForce {
    private SubstringSearchBruteForce() {
    }

    public static int search(String pattern, String text) {
        int m = pattern.length();
        int n = text.length();
        int i, j;
        for (i = 0, j = 0; i < n && j < m; i++) {
            if (text.charAt(i) == pattern.charAt(j)) {
                j++;
            } else {
                i -= j;
                j = 0;
            }
        }

        if (j == m) {
            return i - m;   // found
        } else {
            return -1;      // not found
        }
    }
}
