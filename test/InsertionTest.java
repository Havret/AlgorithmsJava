import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class InsertionTest {
    @Test
    void should_sort_array_of_elements() {
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

        Insertion.sort(a);

        assertArrayEquals(Arrays.stream(a).sorted().toArray(), a);
    }
}