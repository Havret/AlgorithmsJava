import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class EulerianCycleTest {
    @Test
    void can_detect_if_graph_does_not_have_an_euler_cycle() {
        var graph = createTargetGraphWithoutCycle();

        var euler = new EulerianCycle(graph);

        assertFalse(euler.hasEulerianCycle());
    }

    @Test
    void can_detect_if_graph_has_an_euler_cycle() {
        var graph = createTargetGraphWithCycle();

        var euler = new EulerianCycle(graph);

        assertTrue(euler.hasEulerianCycle());
    }

    @Test
    void can_find_euler_cycle() {
        var graph = createTargetGraphWithCycle();

        var euler = new EulerianCycle(graph);

        for (Integer integer : euler.cycle()) {
            System.out.println(integer);
        }

        assertIterableEquals(euler.cycle(), Arrays.asList(0, 2, 4, 3, 2, 1, 0));

        assertTrue(euler.hasEulerianCycle());
    }

    static Graph createTargetGraphWithoutCycle() {
        var graph = new Graph(6);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(4, 5);

        return graph;
    }

    static Graph createTargetGraphWithCycle() {
        var graph = new Graph(5);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);

        return graph;
    }
}