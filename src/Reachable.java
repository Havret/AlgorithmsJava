public class Reachable {
    private int count;
    private boolean[] marked;
    private Integer reachableVertex;

    public Reachable(Digraph graph) {
        count = 0;
        marked = new boolean[graph.V()];

        int vertexInLastStrongComponent = findVertexInLastStrongComponent(graph);
        dfs(graph.reverse(), vertexInLastStrongComponent);

        if (count == graph.V()) {
            reachableVertex = vertexInLastStrongComponent;
        }
    }

    private int findVertexInLastStrongComponent(Digraph graph) {
        var kosarajuSCC = new KosarajuSCC(graph);

        // The Kosaraju-Sharir algorithm outputs strong components in reverse topological order
        for (int v = 0; v < graph.V(); v++) {
            int id = kosarajuSCC.id(v);
            if (id == 0)
                return v;
        }

        throw new IllegalArgumentException("No strong components found in digraph.");
    }

    private void dfs(Digraph graph, int v) {
        marked[v] = true;
        count++;
        for (var w : graph.adj(v)) {
            if (!marked[w]) {
                dfs(graph, w);
            }
        }
    }

    public boolean hasReachableVertex() {
        return reachableVertex != null;
    }

    public int reachableVertex() {
        return reachableVertex;
    }
}
