import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DirectedCycleTest {
    @Test
    void can_detect_if_digraph_has_a_directed_cycle() {
        var graph = createDigraphWithCycle();

        DirectedCycle directedCycle = new DirectedCycle(graph);

        assertTrue(directedCycle.hasCycle());
    }

    @Test
    void can_find_a_directed_cycle() {
        var graph = createDigraphWithCycle();

        DirectedCycle directedCycle = new DirectedCycle(graph);

        assertIterableEquals(directedCycle.cycle(), Arrays.asList(3, 0, 1, 2, 3));
    }

    @Test
    void can_detect_that_graph_does_not_have_a_cycle() {
        var graph = createTargetDigraphWithoutCycle();

        var euler = new DirectedCycle(graph);

        assertFalse(euler.hasCycle());
    }

    static Digraph createTargetDigraphWithoutCycle() {
        var graph = new Digraph(5);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(4, 3);
        graph.addEdge(0, 3);

        return graph;
    }


    static Digraph createDigraphWithCycle() {
        var graph = new Digraph(5);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(4, 3);
        graph.addEdge(3, 0);

        return graph;
    }
}