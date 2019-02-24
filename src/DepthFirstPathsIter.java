import java.util.Stack;

public class DepthFirstPathsIter {
    private boolean[] marked;
    private int[] edgeTo;
    private int source;

    public DepthFirstPathsIter(Graph graph, int source) {
        this.marked = new boolean[graph.V()];
        this.edgeTo = new int[graph.V()];
        this.source = source;

        dfs(graph, source);
    }

    private void dfs(Graph graph, int source) {
        var stack = new Stack<Integer>();
        stack.push(source);
        marked[source] = true;
        while (!stack.empty()) {
            var v = stack.pop();
            // To make iterative dfs yield the same result as
            // recursive solution, adjacent nodes should be processed in
            // reverse order.
            for (var w : graph.adj(v)) {
                if (!marked[w]) {
                    stack.add(w);
                    marked[w] = true;
                    edgeTo[w] = v;
                }
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        var path = new Stack<Integer>();
        for (int x = v; x != source; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(source);
        return path;
    }
}
