import java.util.Stack;

public class DepthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private int source;

    public DepthFirstPaths(Graph graph, int source) {
        this.marked = new boolean[graph.V()];
        this.edgeTo = new int[graph.V()];
        this.source = source;

        dfs(graph, source);
    }

    private void dfs(Graph graph, int v) {
        marked[v] = true;
        for (var w : graph.adj(v)) {
            if (!marked[w]) {
                dfs(graph, w);
                edgeTo[w] = v;
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        var path = new Stack<Integer>();
        for (int x = v; x != source; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(source);
        return path;
    }
}
