import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class KosarajuSCCTest {
    @Test
    void can_compute_strong_components_in_given_digraph() {
        Digraph digraph = createDigraph();

        KosarajuSCC kosarajuSCC = new KosarajuSCC(digraph);

        int id0 = kosarajuSCC.id(0);
        assertEquals(id0, kosarajuSCC.id(2));
        assertEquals(id0, kosarajuSCC.id(3));
        assertEquals(id0, kosarajuSCC.id(4));
        assertEquals(id0, kosarajuSCC.id(5));

        int id1 = kosarajuSCC.id(1);
        assertNotEquals(id0, id1);

        int id6 = kosarajuSCC.id(6);
        assertNotEquals(id0, id6);

        int id7 = kosarajuSCC.id(7);
        assertNotEquals(id0, id7);
        assertEquals(id7, kosarajuSCC.id(8));

        int id9 = kosarajuSCC.id(9);
        assertNotEquals(id0, id9);
        assertEquals(id9, kosarajuSCC.id(10));
        assertEquals(id9, kosarajuSCC.id(11));
        assertEquals(id9, kosarajuSCC.id(12));
    }

    static Digraph createDigraph() {
        var graph = new Digraph(13);

        graph.addEdge(0, 1);
        graph.addEdge(0, 5);
        graph.addEdge(5, 4);
        graph.addEdge(4, 3);
        graph.addEdge(4, 2);
        graph.addEdge(3, 5);
        graph.addEdge(3, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 0);
        graph.addEdge(6, 0);
        graph.addEdge(6, 4);
        graph.addEdge(6, 9);
        graph.addEdge(7, 6);
        graph.addEdge(7, 8);
        graph.addEdge(8, 7);
        graph.addEdge(8, 9);
        graph.addEdge(9, 10);
        graph.addEdge(9, 11);
        graph.addEdge(11, 4);
        graph.addEdge(11, 12);
        graph.addEdge(12, 9);
        graph.addEdge(10, 12);

        return graph;
    }

}