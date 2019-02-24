import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GraphPropertiesTest {
    @Test
    void can_compute_graph_eccentricity() {
        var graph = createTargetGraph();

        var graphProperties = new GraphProperties(graph);

        assertEquals(2, graphProperties.eccentricity(0));
    }

    @Test
    void can_compute_graph_diameter() {
        var graph = createTargetGraph();

        var graphProperties = new GraphProperties(graph);

        assertEquals(2, graphProperties.diameter());
    }

    @Test
    void can_compute_graph_radius() {
        var graph = createTargetGraph();

        var graphProperties = new GraphProperties(graph);

        assertEquals(1, graphProperties.radius());
    }

    @Test
    void can_find_graph_center() {
        var graph = createTargetGraph();

        var graphProperties = new GraphProperties(graph);

        assertEquals(1, graphProperties.center());
    }

    static Graph createTargetGraph() {
        var graph = new Graph(4);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);

        return graph;
    }
}