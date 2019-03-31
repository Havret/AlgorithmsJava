import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MonotonicSPTest {
    @Test
    void should_find_a_monotonic_ascending_shortest_path_from_a_given_source_to_every_other_vertex() {
        var digraph = createTargetGraph();

        MonotonicSP monotonicSP = new MonotonicSP(digraph, 5, Comparator.comparingDouble(DirectedEdge::weight));

        assertEquals("5->7 0.28 7->3 0.39 ", monotonicSP.pathTo(3).toString());
    }

    @Test
    void should_find_a_monotonic_descending_shortest_path_from_a_given_source_to_every_other_vertex() {
        var digraph = createTargetGraph();

        MonotonicSP monotonicSP = new MonotonicSP(digraph, 5, Comparator.comparingDouble(DirectedEdge::weight).reversed());

        assertEquals("5->1 0.32 1->3 0.29 ", monotonicSP.pathTo(3).toString());
    }

    private static EdgeWeightedDigraph createTargetGraph() {
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
        return digraph;
    }
}