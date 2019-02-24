import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DirectedDFSTest {
    @Test
    void can_check_which_vertices_are_reachable_from_a_given_vertex_1() {
        var graph = createTargetDigraph();
        var search = new DirectedDFS(graph, 0);

        assertTrue(search.marked(1));
        assertTrue(search.marked(2));
        assertTrue(search.marked(3));
        assertTrue(search.marked(4));
        assertFalse(search.marked(5));
        assertFalse(search.marked(6));
        assertFalse(search.marked(7));
    }

    @Test
    void can_check_which_vertices_are_reachable_from_a_given_vertex_2() {
        var graph = createTargetDigraph();
        var search = new DirectedDFS(graph, 5);

        assertTrue(search.marked(1));
        assertTrue(search.marked(2));
        assertTrue(search.marked(3));
        assertTrue(search.marked(4));
        assertTrue(search.marked(5));
        assertTrue(search.marked(6));
        assertTrue(search.marked(7));
    }

    @Test
    void can_check_which_vertices_are_reachable_from_a_given_vertex_3() {
        var graph = createTargetDigraph();
        var search = new DirectedDFS(graph, 7);

        assertFalse(search.marked(1));
        assertFalse(search.marked(2));
        assertFalse(search.marked(3));
        assertFalse(search.marked(4));
        assertFalse(search.marked(5));
        assertFalse(search.marked(6));
        assertTrue(search.marked(7));
    }

    static Digraph createTargetDigraph() {
        var graph = new Digraph(8);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(4, 3);
        graph.addEdge(3, 0);
        graph.addEdge(5, 1);
        graph.addEdge(5, 6);
        graph.addEdge(5, 7);
        graph.addEdge(6, 7);

        return graph;
    }
}