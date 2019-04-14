import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BipartiteMatchingTest {
    @Test
    void should_determine_if_there_is_a_perfect_matching_in_given_graph() {
        Graph graph = new Graph(6);
        graph.addEdge(0, 3);
        graph.addEdge(0, 4);
        graph.addEdge(1, 4);
        graph.addEdge(1, 5);
        graph.addEdge(2, 5);

        BipartiteMatching bipartiteMatching = new BipartiteMatching(graph);

        assertTrue(bipartiteMatching.isPerfect());
    }

    @Test
    void should_determine_if_there_is_no_perfect_matching_in_a_given_graph() {
        Graph graph = new Graph(6);
        graph.addEdge(0, 3);
        graph.addEdge(0, 4);
        graph.addEdge(1, 5);
        graph.addEdge(2, 5);

        BipartiteMatching bipartiteMatching = new BipartiteMatching(graph);

        assertFalse(bipartiteMatching.isPerfect());
    }
}