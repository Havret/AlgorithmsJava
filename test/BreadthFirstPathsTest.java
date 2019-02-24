import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BreadthFirstPathsTest {
    @Test
    void can_determine_if_s_and_v_are_connected() {
        var graph = createTargetGraph();

        var paths = new BreadthFirstPaths(graph, 0);

        assertTrue(paths.hasPathTo(0));
        assertTrue(paths.hasPathTo(1));
        assertTrue(paths.hasPathTo(2));
        assertTrue(paths.hasPathTo(3));

        assertFalse(paths.hasPathTo(4));
        assertFalse(paths.hasPathTo(5));
    }

    @Test
    void can_find_shortest_path_from_s_to_a_given_v() {
        var graph = createTargetGraph();

        var paths = new BreadthFirstPaths(graph, 0);

        assertTrue(paths.hasPathTo(3));
        assertIterableEquals(paths.pathTo(3), Arrays.asList(3, 1, 0));
    }

    @Test
    void can_compute_shortest_distance_from_s_to_a_given_v() {
        var graph = createTargetGraph();

        var paths = new BreadthFirstPaths(graph, 0);

        assertTrue(paths.hasPathTo(3));
        assertEquals(paths.distanceTo(3), 2);
    }

    static Graph createTargetGraph() {
        var graph = new Graph(6);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(4, 5);

        return graph;
    }

}