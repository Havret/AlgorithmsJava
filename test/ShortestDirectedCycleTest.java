import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ShortestDirectedCycleTest {
    @Test
    void can_find_shortest_cycle_for_a_given_digraph() {
        var graph = createDigraph();

        var cycle = new ShortestDirectedCycle(graph);

        assertIterableEquals(cycle.cycle(), Arrays.asList(2, 3, 2));
    }

    @Test
    void should_report_if_a_given_digraph_is_acyclic() {
        var graph = createDAG();

        var cycle = new ShortestDirectedCycle(graph);

        assertFalse(cycle.hasCycle());
        assertNull(cycle.cycle());
    }

    static Digraph createDigraph() {
        var graph = new Digraph(13);

        graph.addEdge(0, 1);
        graph.addEdge(0, 5);
        graph.addEdge(5, 4);
        graph.addEdge(4, 3);
        graph.addEdge(4, 2);
        graph.addEdge(3, 5);
        graph.addEdge(3, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 0);
        graph.addEdge(6, 0);
        graph.addEdge(6, 4);
        graph.addEdge(6, 9);
        graph.addEdge(7, 6);
        graph.addEdge(7, 8);
        graph.addEdge(8, 7);
        graph.addEdge(8, 9);
        graph.addEdge(9, 10);
        graph.addEdge(9, 11);
        graph.addEdge(11, 4);
        graph.addEdge(11, 12);
        graph.addEdge(12, 9);
        graph.addEdge(10, 12);

        return graph;
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