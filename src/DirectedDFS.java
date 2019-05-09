public class DirectedDFS {
    private boolean[] marked;

    public DirectedDFS(Digraph graph, int s) {
        marked = new boolean[graph.V()];
        dfs(graph, s);
    }

    public DirectedDFS(Digraph graph, Iterable<Integer> sources) {
        marked = new boolean[graph.V()];
        for (int v : sources) {
            if (!marked[v]) {
                dfs(graph, v);
            }
        }
    }

    private void dfs(Digraph graph, int v) {
        marked[v] = true;
        for (int w : graph.adj(v)) {
            if (!marked[w]) {
                dfs(graph, w);
            }
        }
    }

    // is v reachable?
    public boolean marked(int v) {
        return marked[v];
    }
}
