import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ReachableTest {
    @Test
    void can_find_vertex_reachable_from_every_other_vertex_in_DAG() {
        var graph = new Digraph(7);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(0, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 5);
        graph.addEdge(2, 5);
        graph.addEdge(3, 4);
        graph.addEdge(4, 2);
        graph.addEdge(5, 6);

        var reachable = new Reachable(graph);

        assertTrue(reachable.hasReachableVertex());
        assertEquals(6, reachable.reachableVertex());
    }
}