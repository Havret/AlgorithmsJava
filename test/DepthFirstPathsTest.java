import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class DepthFirstPathsTest {
    @Test
    public void can_calculate_path_using_recursive_dfs() {
        var graph = createGraph();

        var paths = new DepthFirstPaths(graph, 0);

        assertIterableEquals(paths.pathTo(6), Arrays.asList(6, 4, 5, 0));
    }

    @Test
    public void can_calculate_path_using_iterative_dfs() {
        var graph = createGraph();

        var paths = new DepthFirstPathsIter(graph, 0);

        assertIterableEquals(paths.pathTo(6), Arrays.asList(6, 0));
    }

    private Graph createGraph() {
        var graph = new Graph(13);
        graph.addEdge(0, 5);
        graph.addEdge(4, 3);
        graph.addEdge(0, 1);
        graph.addEdge(9, 12);
        graph.addEdge(6, 4);
        graph.addEdge(5, 4);
        graph.addEdge(0, 2);
        graph.addEdge(11, 12);
        graph.addEdge(9, 10);
        graph.addEdge(0, 6);
        graph.addEdge(7, 8);
        graph.addEdge(9, 11);
        graph.addEdge(5, 3);
        return graph;
    }
}
