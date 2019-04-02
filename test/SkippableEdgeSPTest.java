import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SkippableEdgeSPTest {

    @Test
    void should_find_shortest_path_with_one_skippable_edge() {
        var graph = createTargetGraph();

        SkippableEdgeSP skippableEdgeSP = new SkippableEdgeSP(graph, 5, 3);

        assertEquals("[5->7 0.28, 7->3 0.39]", skippableEdgeSP.getShortestSkippablePath().toString());
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