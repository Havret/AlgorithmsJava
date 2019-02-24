import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepthFirstSearchTest {

    @Test
    void can_check_if_v_is_connected_to_source() {
        var graph = createTargetGraph();
        var search = new DepthFirstSearch(graph, 1);

        assertTrue(search.marked(0));
        assertTrue(search.marked(2));
        assertTrue(search.marked(3));
        assertFalse(search.marked(4));
        assertFalse(search.marked(5));
    }

    @Test
    void can_count_number_of_vertices_connected_to_source() {
        var graph = createTargetGraph();
        var search = new DepthFirstSearch(graph, 1);

        assertEquals(4, search.count());
    }

    public static Graph createTargetGraph() {
        var graph = new Graph(6);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(4, 5);

        return graph;
    }
}