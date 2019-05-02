import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class PrefixFreeCheckerTest {
    @Test
    void empty_sequence_of_binary_strings_is_prefix_free() {
        var checker = new PrefixFreeChecker();
        assertTrue(checker.isPrefixFree());
    }

    @Test
    void should_detect_if_sequence_of_binary_strings_is_prefix_free() {
        var checker = new PrefixFreeChecker();
        checker.put("01");
        checker.put("10");
        checker.put("0010");
        checker.put("1111");

        assertTrue(checker.isPrefixFree());
    }

    @Test
    void should_detect_if_sequence_of_binary_strings_is_not_prefix_free() {
        var checker = new PrefixFreeChecker();
        checker.put("01");
        checker.put("10");
        checker.put("0010");
        checker.put("10100");

        assertFalse(checker.isPrefixFree());
    }
}