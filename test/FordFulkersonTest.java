import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FordFulkersonTest {
    @Test
    void should_find_max_flow_in_flow_network() {
        FlowNetwork flowNetwork = new FlowNetwork(6);
        flowNetwork.addEdge(new FlowEdge(0, 1, 2.0));
        flowNetwork.addEdge(new FlowEdge(0, 2, 3.0));
        flowNetwork.addEdge(new FlowEdge(1, 3, 3.0));
        flowNetwork.addEdge(new FlowEdge(1, 4, 1.0));
        flowNetwork.addEdge(new FlowEdge(2, 3, 1.0));
        flowNetwork.addEdge(new FlowEdge(2, 4, 1.0));
        flowNetwork.addEdge(new FlowEdge(3, 5, 2.0));
        flowNetwork.addEdge(new FlowEdge(4, 5, 3.0));

        FordFulkerson fordFulkerson = new FordFulkerson(flowNetwork, 0, 5);
        assertEquals(4.0, fordFulkerson.value());

        Iterable<FlowEdge> edges = flowNetwork.edges();
        assertEquals(2.0, getFlow(edges, 0, 1));
        assertEquals(2.0, getFlow(edges, 0, 2));
        assertEquals(1.0, getFlow(edges, 1, 3));
        assertEquals(1.0, getFlow(edges, 1, 4));
        assertEquals(1.0, getFlow(edges, 2, 3));
        assertEquals(1.0, getFlow(edges, 2, 4));
        assertEquals(2.0, getFlow(edges, 3, 5));
        assertEquals(2.0, getFlow(edges, 4, 5));
    }

    private double getFlow(Iterable<FlowEdge> edges, int v, int w) {
        for (FlowEdge edge : edges) {
            if (edge.from() == v && edge.to() == w) {
                return edge.flow();
            }
        }
        return -1;
    }
}