import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class NFATest {
    @Test
    void regular_expression_should_match_input_string() {
        NFA nfa = new NFA("((A*B|AC)D)");
        assertTrue(nfa.recognizes("AABD"));
    }

    @Test
    void regular_expression_should_not_match_input_string() {
        NFA nfa = new NFA("((A*B|AC)D)");
        assertFalse(nfa.recognizes("AABC"));
    }
}