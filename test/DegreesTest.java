import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class DegreesTest {
    @Test
    void can_calculate_outdegree_of_a_vertex_in_digraph() {
        Digraph graph = createDigraph();

        Degrees degrees = new Degrees(graph);

        assertEquals(2, degrees.outdegree(0));
        assertEquals(1, degrees.outdegree(1));
        assertEquals(2, degrees.outdegree(2));
        assertEquals(1, degrees.outdegree(3));
        assertEquals(0, degrees.outdegree(4));
    }

    @Test
    void can_calculate_indegree_of_a_vertex_in_digraph() {
        Digraph graph = createDigraph();

        Degrees degrees = new Degrees(graph);

        assertEquals(0, degrees.indegree(0));
        assertEquals(1, degrees.indegree(1));
        assertEquals(2, degrees.indegree(2));
        assertEquals(1, degrees.indegree(3));
        assertEquals(2, degrees.indegree(4));
    }

    @Test
    void can_find_sources_in_a_digraph() {
        var graph = createDigraph();

        var degrees = new Degrees(graph);
        assertIterableEquals(degrees.sources(), Collections.singletonList(0));
    }

    @Test
    void can_find_sins_in_a_digraph() {
        var graph = createDigraph();

        var degrees = new Degrees(graph);
        assertIterableEquals(degrees.sinks(), Collections.singletonList(4));
    }

    @Test
    void can_detect_that_a_digraph_is_not_a_map() {
        var graph = createDigraph();

        var degrees = new Degrees(graph);
        assertFalse(degrees.isMap());
    }

    @Test
    void can_detect_that_a_digraph_is_a_map() {
        var graph = new Digraph(3);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 1);

        var degrees = new Degrees(graph);
        assertTrue(degrees.isMap());
    }

    private static Digraph createDigraph() {
        var graph = new Digraph(5);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(0, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(2, 4);
        return graph;
    }
}