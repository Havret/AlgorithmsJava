import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DijkstraSPTest {
    @Test
    void should_find_shortest_path_from_a_given_source_in_a_given_graph() {
        var digraph = new EdgeWeightedDigraph(8);
        digraph.addEdge(new DirectedEdge(4, 5, 0.35));
        digraph.addEdge(new DirectedEdge(5, 4, 0.35));
        digraph.addEdge(new DirectedEdge(4, 7, 0.37));
        digraph.addEdge(new DirectedEdge(5, 7, 0.28));
        digraph.addEdge(new DirectedEdge(7, 5, 0.28));
        digraph.addEdge(new DirectedEdge(5, 1, 0.32));
        digraph.addEdge(new DirectedEdge(0, 4, 0.38));
        digraph.addEdge(new DirectedEdge(0, 2, 0.26));
        digraph.addEdge(new DirectedEdge(7, 3, 0.39));
        digraph.addEdge(new DirectedEdge(1, 3, 0.29));
        digraph.addEdge(new DirectedEdge(2, 7, 0.34));
        digraph.addEdge(new DirectedEdge(6, 2, 0.40));
        digraph.addEdge(new DirectedEdge(3, 6, 0.52));
        digraph.addEdge(new DirectedEdge(6, 0, 0.58));
        digraph.addEdge(new DirectedEdge(6, 4, 0.93));

        DijkstraSP dijkstraSP = new DijkstraSP(digraph, 0);

        for (int v = 1; v < digraph.V(); v++) {
            assertTrue(dijkstraSP.hasPathTo(v));
        }

        assertIterableEquals(Arrays.asList(new DirectedEdge(0, 2, 0.26),
                new DirectedEdge(2, 7, 0.34),
                new DirectedEdge(7, 3, 0.39),
                new DirectedEdge(3, 6, 0.52)
        ), dijkstraSP.pathTo(6));

        assertEquals(1.51, dijkstraSP.distTo(6), 0.001);
    }
}