import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class LongestPalindromicSubstringTest {
    @Test
    void should_find_longest_palindromic_substring_odd_case() {
        assertEquals("abxba", LongestPalindromicSubstring.findLongestPalindrome("xxabxbaacax"));
    }

    @Test
    void should_find_longest_palindromic_substring_even_case() {
        assertEquals("xabbax", LongestPalindromicSubstring.findLongestPalindrome("xxxabbaxacax"));
    }
}