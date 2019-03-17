import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UFTest {
    @Test
    void it_should_computer_number_of_components() {
        UF uf = createUF();

        assertEquals(2, uf.count());
    }

    @Test
    void it_should_compute_which_vertices_are_in_the_same_components() {
        UF uf = createUF();

        assertConnected(uf, 0, Arrays.asList(0, 1, 2), true);
        assertConnected(uf, 1, Arrays.asList(0, 1, 2), true);
        assertConnected(uf, 2, Arrays.asList(0, 1, 2), true);
        assertConnected(uf, 3, Arrays.asList(3, 4, 5), true);
        assertConnected(uf, 4, Arrays.asList(3, 4, 5), true);
        assertConnected(uf, 5, Arrays.asList(3, 4, 5), true);
        assertConnected(uf, 0, Arrays.asList(3, 4, 5), false);
        assertConnected(uf, 1, Arrays.asList(3, 4, 5), false);
        assertConnected(uf, 2, Arrays.asList(3, 4, 5), false);
        assertConnected(uf, 3, Arrays.asList(0, 1, 2), false);
        assertConnected(uf, 4, Arrays.asList(0, 1, 2), false);
        assertConnected(uf, 5, Arrays.asList(0, 1, 2), false);
    }

    private UF createUF() {
        UF uf = new UF(6);
        uf.union(0, 1);
        uf.union(1, 2);
        uf.union(3, 5);
        uf.union(4, 5);
        return uf;
    }

    private void assertConnected(UF uf, int p, Iterable<Integer> components, boolean condition) {
        for (Integer q : components) {
            assertEquals(condition, uf.connected(p, q));
            assertEquals(condition, uf.connected(q, p));
        }
    }
}