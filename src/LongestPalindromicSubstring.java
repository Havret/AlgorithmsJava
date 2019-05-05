public class LongestPalindromicSubstring {
    private LongestPalindromicSubstring() {
    }

    public static String findLongestPalindrome(String string) {
        int length = 0;
        int beginIndex = 0;
        boolean event = string.length() % 2 == 0;
        for (int i = 1; i < string.length() - 1; i++) {
            int left = i, right = event ? i + 1 : i;
            while (left > 0 && right < string.length() - 1 && string.charAt(left - 1) == string.charAt(right + 1)) {
                left--;
                right++;
            }
            int currentLength = right - left;
            if (length < currentLength) {
                length = currentLength;
                beginIndex = left;
            }
        }


        return string.substring(beginIndex, beginIndex + length + 1);
    }
}
