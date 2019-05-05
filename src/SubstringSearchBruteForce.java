public class SubstringSearchBruteForce {
    private SubstringSearchBruteForce() {
    }

    public static int search(String pattern, String text) {
        int m = pattern.length();
        int n = text.length();
        for (int i = 0; i < n - m; i++) {
            int j;
            for (j = 0; j < m; j++) {
                if (text.charAt(i+j) != pattern.charAt(j)) {
                    break;
                }
            }
            if (j == m) {
                return i;
            }
        }

        return -1;
    }
}
