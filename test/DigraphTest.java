import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class DigraphTest {
    @Test
    void can_create_digraph() {
        var digraph = createTargetDigraph();

        assertEquals(5, digraph.V());
        assertEquals(6, digraph.E());
        assertIterableEquals(digraph.adj(0), Collections.singletonList(1));
        assertIterableEquals(digraph.adj(1), Collections.singletonList(2));
        assertIterableEquals(digraph.adj(2), Arrays.asList(3, 4));
        assertIterableEquals(digraph.adj(3), Collections.singletonList(0));
        assertIterableEquals(digraph.adj(4), Collections.singletonList(3));
    }

    @Test
    void can_reverse_digraph() {
        var digraph = createTargetDigraph();

        Digraph reversedDigraph = digraph.reverse();

        assertEquals(5, reversedDigraph.V());
        assertEquals(6, reversedDigraph.E());
        assertIterableEquals(reversedDigraph.adj(0), Collections.singleton(3));
        assertIterableEquals(reversedDigraph.adj(1), Collections.singleton(0));
        assertIterableEquals(reversedDigraph.adj(2), Collections.singleton(1));
        assertIterableEquals(reversedDigraph.adj(3), Arrays.asList(2, 4));
        assertIterableEquals(reversedDigraph.adj(4), Collections.singleton(2));

    }

    static Digraph createTargetDigraph() {
        var graph = new Digraph(5);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(4, 3);
        graph.addEdge(3, 0);

        return graph;
    }
}