import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AcyclicSPTest {
    @Test
    void should_find_shortest_path_from_a_given_source_in_a_given_edge_weighted_digraph() {
        var graph = createEWDAG();

        AcyclicSP acyclicSP = new AcyclicSP(graph, 5);

        assertEquals("5->4 0.35 4->0 0.38 ", acyclicSP.pathTo(0).toString());
        assertEquals(0.73, acyclicSP.distTo(0),0.001);
        assertEquals("5->1 0.32 ", acyclicSP.pathTo(1).toString());
        assertEquals(0.32, acyclicSP.distTo(1), 0.001);
        assertEquals("5->7 0.28 7->2 0.34 ", acyclicSP.pathTo(2).toString());
        assertEquals(0.62, acyclicSP.distTo(2), 0.001);
        assertEquals("5->1 0.32 1->3 0.29 ", acyclicSP.pathTo(3).toString());
        assertEquals(0.61, acyclicSP.distTo(3), 0.001);
        assertEquals("5->4 0.35 ", acyclicSP.pathTo(4).toString());
        assertEquals(0.35, acyclicSP.distTo(4), 0.001);
        assertEquals(null, acyclicSP.pathTo(5));
        assertEquals(0.00, acyclicSP.distTo(5), 0.001);
        assertEquals("5->1 0.32 1->3 0.29 3->6 0.52 ", acyclicSP.pathTo(6).toString());
        assertEquals(1.13, acyclicSP.distTo(6), 0.001);
        assertEquals("5->7 0.28 ", acyclicSP.pathTo(7).toString());
        assertEquals(0.28, acyclicSP.distTo(7), 0.001);
    }

    static EdgeWeightedDigraph createEWDAG() {
        EdgeWeightedDigraph graph = new EdgeWeightedDigraph(8);
        graph.addEdge(new DirectedEdge(5, 4, 0.35));
        graph.addEdge(new DirectedEdge(4, 7, 0.37));
        graph.addEdge(new DirectedEdge(5, 7, 0.28));
        graph.addEdge(new DirectedEdge(5, 1, 0.32));
        graph.addEdge(new DirectedEdge(4, 0, 0.38));
        graph.addEdge(new DirectedEdge(0, 2, 0.26));
        graph.addEdge(new DirectedEdge(3, 7, 0.39));
        graph.addEdge(new DirectedEdge(1, 3, 0.29));
        graph.addEdge(new DirectedEdge(7, 2, 0.34));
        graph.addEdge(new DirectedEdge(6, 2, 0.40));
        graph.addEdge(new DirectedEdge(3, 6, 0.52));
        graph.addEdge(new DirectedEdge(6, 0, 0.58));
        graph.addEdge(new DirectedEdge(6, 4, 0.93));
        return graph;
    }
}