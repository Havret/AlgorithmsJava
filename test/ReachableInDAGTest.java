import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReachableInDAGTest {
    @Test
    void can_find_vertex_reachable_from_every_other_vertex_in_DAG() {
        var graph = new Digraph(5);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(0, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(2, 4);

        var reachableInDAG = new ReachableInDAG(graph);

        assertTrue(reachableInDAG.hasReachableVertex());
        assertEquals(4, reachableInDAG.reachableVertex());
    }

    @Test
    void can_detect_if_there_is_no_vertex_reachable_from_every_other_vertex_in_DAG() {
        var graph = new Digraph(7);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(0, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(2, 4);
        graph.addEdge(5, 6);

        var reachableInDAG = new ReachableInDAG(graph);

        assertFalse(reachableInDAG.hasReachableVertex());
    }
}


