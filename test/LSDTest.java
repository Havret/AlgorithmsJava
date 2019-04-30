import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class LSDTest {
    @Test
    void it_should_sort_array_of_fixed_length_strings() {
        String[] a = {
                "4PGC938",
                "2IYE230",
                "3CIO720",
                "1ICK750",
                "1OHV845",
                "4JZY524",
                "1ICK750",
                "3CIO720",
                "1OHV845",
                "1OHV845",
                "2RLA629",
                "2RLA629",
                "3ATW723",
        };

        LSD.sort(a, 7);

        assertArrayEquals(Arrays.stream(a).sorted().toArray(), a);
    }

    @Test
    void it_should_sort_array_of_longs() {
        long[] a = {Long.MAX_VALUE, Long.MAX_VALUE - 1, Long.MAX_VALUE - 2, Long.MAX_VALUE - 3, Long.MAX_VALUE - 4, 0};

        LSD.sort(a);

        long[] expected = {0, Long.MAX_VALUE - 4, Long.MAX_VALUE - 3, Long.MAX_VALUE - 2, Long.MAX_VALUE - 1, Long.MAX_VALUE};
        assertArrayEquals(expected, a);
    }
}