import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CCTest {
    @Test
    void can_determine_if_s_and_v_are_connected() {
        var graph = createTargetGraph();

        var cc = new CC(graph);

        assertTrue(cc.connected(0, 1));
        assertTrue(cc.connected(0, 2));
        assertTrue(cc.connected(0, 3));
        assertTrue(cc.connected(1, 2));
        assertTrue(cc.connected(4, 5));

        assertFalse(cc.connected(0, 4));
        assertFalse(cc.connected(0, 5));
    }

    @Test
    void can_find_connected_components(){
        var graph = createTargetGraph();

        var cc = new CC(graph);

        assertEquals(0, cc.id(0));
        assertEquals(0, cc.id(1));
        assertEquals(0, cc.id(2));
        assertEquals(0, cc.id(3));
        assertEquals(1, cc.id(4));
        assertEquals(1, cc.id(5));
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
