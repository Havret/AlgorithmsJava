import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class HamiltonianPathInDAGTest {
    @Test
    void can_find_hamiltonian_path_in_DAG() {
        var digraph = new Digraph(5);
        digraph.addEdge(0, 1);
        digraph.addEdge(0, 2);
        digraph.addEdge(1, 2);
        digraph.addEdge(2, 3);
        digraph.addEdge(3, 4);

        var hamiltonianPathInDAG = new HamiltonianPathInDAG(digraph);

        assertTrue(hamiltonianPathInDAG.hasPath());
        assertIterableEquals(hamiltonianPathInDAG.path(), Arrays.asList(0, 1, 2, 3, 4));
    }

    @Test
    void can_find_that_there_are_no_hamiltonian_path_in_DAG() {
        var digraph = new Digraph(6);
        digraph.addEdge(0, 1);
        digraph.addEdge(1, 2);
        digraph.addEdge(3, 4);
        digraph.addEdge(4, 5);

        HamiltonianPathInDAG hamiltonianPathInDAG = new HamiltonianPathInDAG(digraph);

        assertFalse(hamiltonianPathInDAG.hasPath());
    }
}