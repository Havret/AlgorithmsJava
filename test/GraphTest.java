import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class GraphTest {
    @Test
    void can_create_graph() {
        var graph = createTargetGraph();

        assertIterableEquals(graph.adj(0), Collections.singletonList(1));
        assertIterableEquals(graph.adj(1), Arrays.asList(0, 2, 3));
        assertIterableEquals(graph.adj(2), Arrays.asList(1, 3));
        assertIterableEquals(graph.adj(3), Arrays.asList(1, 2));
    }

    @Test
    void can_compute_the_degree_of_v() {
        var graph = createTargetGraph();

        assertEquals(1, Graph.degree(graph, 0));
        assertEquals(3, Graph.degree(graph, 1));
        assertEquals(2, Graph.degree(graph, 2));
        assertEquals(2, Graph.degree(graph, 3));
    }

    @Test
    void can_compute_max_degree() {
        var graph = createTargetGraph();

        assertEquals(3, Graph.maxDegree(graph));
    }

    @Test
    void can_compute_avg_degree() {
        var graph = createTargetGraph();

        assertEquals(2, Graph.avgDegree(graph));
    }

    @Test
    void can_count_self_loops() {
        var graph = createTargetGraph();

        graph.addEdge(1, 1);
        graph.addEdge(2, 2);

        assertEquals(2, Graph.numberOfSelfLoops(graph));
    }

    static Graph createTargetGraph() {
        var graph = new Graph(4);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);

        return graph;
    }
}