import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class TandemRepeatTest {
    @Test
    void should_find_tandem_repeat_of_base_string_within_source_string() {
        assertEquals("abcababcab", TandemRepeat.findTandemRepeat("abcabcababcaba", "abcab"));
    }

    @Test
    void should_return_empty_string_if_there_is_no_tandem_reaped_of_base_within_source() {
        assertEquals("", TandemRepeat.findTandemRepeat("abcabcababcaba", "abcabb"));
    }
}