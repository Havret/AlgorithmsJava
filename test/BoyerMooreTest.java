import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class BoyerMooreTest {
    @Test
    void should_find_the_index_withing_the_text_of_the_first_occurrence_of_specified_pattern() {
        assertEquals(6, new BoyerMoore("ABRA").search("ABACADABRAC"));
    }

    @Test
    void should_handle_scenario_when_there_is_no_match() {
        assertEquals(-1, new BoyerMoore("ABRA").search("BUBA"));
    }
}