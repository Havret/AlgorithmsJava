import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BipartiteXTest {
    @Test
    void should_determine_if_undirected_graph_is_bipartite() {
        Graph graph = new Graph(6);
        graph.addEdge(0, 3);
        graph.addEdge(0, 4);
        graph.addEdge(1, 4);
        graph.addEdge(1, 5);
        graph.addEdge(2, 4);
        graph.addEdge(2, 5);

        BipartiteX bipartiteX = new BipartiteX(graph);

        assertTrue(bipartiteX.isBipartite());
        assertTrue(bipartiteX.color(3));
        assertTrue(bipartiteX.color(4));
        assertTrue(bipartiteX.color(5));
        assertFalse(bipartiteX.color(0));
        assertFalse(bipartiteX.color(1));
        assertFalse(bipartiteX.color(2));
    }

    @Test
    void should_determine_if_undirected_graph_is_not_bipartite_and_find_odd_length_cycle() {
        Graph graph = new Graph(6);
        graph.addEdge(0, 3);
        graph.addEdge(0, 4);
        graph.addEdge(1, 4);
        graph.addEdge(1, 5);
        graph.addEdge(2, 4);
        graph.addEdge(2, 5);
        graph.addEdge(0, 1);

        BipartiteX bipartiteX = new BipartiteX(graph);
        assertFalse(bipartiteX.isBipartite());
        assertEquals("1 0 4 1 ", bipartiteX.oddCycle().toString());
    }
}