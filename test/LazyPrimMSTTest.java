import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LazyPrimMSTTest {
    @Test
    void should_find_mst_for_given_graph() {
        EdgeWeighedGraph graph = new EdgeWeighedGraph(16);
        graph.addEdge(new Edge(4, 5, 0.35));
        graph.addEdge(new Edge(4, 7, 0.37));
        graph.addEdge(new Edge(5, 7, 0.28));
        graph.addEdge(new Edge(0, 7, 0.16));
        graph.addEdge(new Edge(1, 5, 0.32));
        graph.addEdge(new Edge(0, 4, 0.38));
        graph.addEdge(new Edge(2, 3, 0.17));
        graph.addEdge(new Edge(1, 7, 0.19));
        graph.addEdge(new Edge(0, 2, 0.26));
        graph.addEdge(new Edge(1, 2, 0.36));
        graph.addEdge(new Edge(1, 3, 0.29));
        graph.addEdge(new Edge(2, 7, 0.34));
        graph.addEdge(new Edge(6, 2, 0.40));
        graph.addEdge(new Edge(3, 6, 0.52));
        graph.addEdge(new Edge(6, 0, 0.58));
        graph.addEdge(new Edge(6, 4, 0.93));

        LazyPrimMST lazyPrimMST = new LazyPrimMST(graph);

        assertEquals("0-7 0.16 1-7 0.19 0-2 0.26 2-3 0.17 5-7 0.28 4-5 0.35 6-2 0.40 ", lazyPrimMST.edges().toString());
    }

}