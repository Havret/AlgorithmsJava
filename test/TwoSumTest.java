import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class TwoSumTest {
    @Test
    void should_detect_if_there_are_two_longs_in_array_that_their_sum_equals_T() {
        long[] a = {100, 20, 3, 4, 5, 60};
        assertTrue(TwoSum.sumExists(a, 8));
    }

    @Test
    void should_detect_if_there_are_not_two_longs_in_array_that_their_sum_equals_T() {
        long[] a = {100, 20, 3, 4, 5, 60};
        assertFalse(TwoSum.sumExists(a, 10));
    }
}