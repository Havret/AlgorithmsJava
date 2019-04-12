import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FattestPathTest {
    @Test
    void should_find_fattest_path() {
        EdgeWeightedDigraph digraph = new EdgeWeightedDigraph(4);
        digraph.addEdge(new DirectedEdge(0, 1, 60));
        digraph.addEdge(new DirectedEdge(0, 2, 50));
        digraph.addEdge(new DirectedEdge(1, 2, 1));
        digraph.addEdge(new DirectedEdge(1, 3, 40));
        digraph.addEdge(new DirectedEdge(2, 3, 50));

        FattestPath fattestPath = new FattestPath(digraph, 0);

        assertTrue(fattestPath.hasPathTo(3));
        assertEquals("0->2 50.00 2->3 50.00 ", fattestPath.pathTo(3).toString());
    }
}