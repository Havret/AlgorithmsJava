import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TopologicalTest {
    @Test
    void can_detect_if_digraph_is_DAG() {
        var graph = createDAG();

        var topological = new Topological(graph);

        assertTrue(topological.isDAG());
    }

    @Test
    void can_detect_if_digraph_is_not_DAG() {
        Digraph graph = createDAG();

        // add cycle
        graph.addEdge(12, 0);

        var topological = new Topological(graph);

        assertFalse(topological.isDAG());
    }

    @Test
    void can_return_vertices_in_topological_order() {
        var graph = createDAG();

        var topological = new Topological(graph);

        assertIterableEquals(topological.order(), Arrays.asList(8, 7, 2, 3, 0, 6, 9, 11, 12, 10, 5, 4, 1));
    }

    static Digraph createDAG() {
        var graph = new Digraph(13);

        graph.addEdge(0, 1);
        graph.addEdge(0, 5);
        graph.addEdge(0, 6);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 5);
        graph.addEdge(5, 4);
        graph.addEdge(6, 4);
        graph.addEdge(7, 6);
        graph.addEdge(8, 7);
        graph.addEdge(6, 9);
        graph.addEdge(9, 10);
        graph.addEdge(9, 11);
        graph.addEdge(9, 12);
        graph.addEdge(11, 12);


        return graph;
    }
}