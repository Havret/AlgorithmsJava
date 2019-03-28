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

    @Test
    void can_detect_if_edge_weighted_digraph_is_DAG() {
        var graph = createEWDAG();

        var topological = new Topological(graph);

        assertTrue(topological.isDAG());
    }

    @Test
    void can_detect_if_edge_weighted_digraph_is_not_DAG() {
        var graph = createEWDAG();

        // add cycle
        graph.addEdge(new DirectedEdge(7,1,0.5));

        var topological = new Topological(graph);

        assertFalse(topological.isDAG());
    }

    static EdgeWeightedDigraph createEWDAG() {
        EdgeWeightedDigraph graph = new EdgeWeightedDigraph(8);
        graph.addEdge(new DirectedEdge(5, 4, 0.35));
        graph.addEdge(new DirectedEdge(4, 7, 0.37));
        graph.addEdge(new DirectedEdge(5, 7, 0.28));
        graph.addEdge(new DirectedEdge(5, 1, 0.32));
        graph.addEdge(new DirectedEdge(4, 0, 0.38));
        graph.addEdge(new DirectedEdge(0, 2, 0.26));
        graph.addEdge(new DirectedEdge(3, 7, 0.39));
        graph.addEdge(new DirectedEdge(1, 3, 0.29));
        graph.addEdge(new DirectedEdge(7, 2, 0.34));
        graph.addEdge(new DirectedEdge(6, 2, 0.40));
        graph.addEdge(new DirectedEdge(3, 6, 0.52));
        graph.addEdge(new DirectedEdge(6, 0, 0.58));
        graph.addEdge(new DirectedEdge(6, 4, 0.93));
        return graph;
    }
}