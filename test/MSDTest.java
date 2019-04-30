import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class MSDTest {
    @Test
    void it_should_sort_array_of_strings() {
        String[] a = {
                "she",
                "sells",
                "seashells",
                "by",
                "the",
                "sea",
                "shore",
                "shells",
                "she",
                "sells",
                "are",
                "surely",
                "seashells",
        };

        MSD.sort(a);

        assertArrayEquals(Arrays.stream(a).sorted().toArray(), a);
    }
}