import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class DepthFirstDirectedPathsTest {
    @Test
    public void can_find_directed_path_from_s_to_a_given_vertex_v_using_dfs() {
        var graph = createTargetDigraph();

        var paths = new DepthFirstDirectedPaths(graph, 5);

        assertIterableEquals(paths.pathTo(0), Arrays.asList(5, 1, 2, 3, 0));
    }

    static Digraph createTargetDigraph() {
        var graph = new Digraph(8);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(4, 3);
        graph.addEdge(3, 0);
        graph.addEdge(5, 1);
        graph.addEdge(5, 6);
        graph.addEdge(5, 7);
        graph.addEdge(6, 7);

        return graph;
    }
}