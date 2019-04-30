import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class Quick3stringTest {
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

        Quick3string.sort(a);

        assertArrayEquals(Arrays.stream(a).sorted().toArray(), a);
    }
}