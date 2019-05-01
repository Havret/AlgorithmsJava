import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CyclicRotationsTest {
    @Test
    void should_find_cyclic_rotations_for_given_array_of_strings() {
        String[] array = {
                "algorithms",
                "polynomial",
                "sortsuffix",
                "boyermoore",
                "structures",
                "minimumcut",
                "suffixsort",
                "stackstack",
                "binaryheap",
                "digraphdfs",
                "stringsort",
                "digraphbfs",
        };

        assertTrue(CyclicRotations.hasCyclicRotations(array));
    }

    @Test
    void should_find_that_there_are_no_cyclic_rotations_for_given_array_of_strings() {
        String[] array = {
                "algorithms",
                "polynomial",
                "sortsuffix",
                "boyermoore",
                "structures",
                "minimumcut",
                "stackstack",
                "binaryheap",
                "digraphdfs",
                "stringsort",
                "digraphbfs",
        };

        assertFalse(CyclicRotations.hasCyclicRotations(array));
    }

    @Test
    void should_find_that_there_are_no_cyclic_rotations_in_empty_array() {
        String[] array = {};

        assertFalse(CyclicRotations.hasCyclicRotations(array));
    }
}