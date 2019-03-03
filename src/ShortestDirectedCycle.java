public class ShortestDirectedCycle {
    private boolean[] marked;
    private int[] edgeTo;
    private Stack<Integer> cycle;
    private boolean[] onStack;

    public ShortestDirectedCycle(Digraph graph) {
        onStack = new boolean[graph.V()];
        edgeTo = new int[graph.V()];
        marked = new boolean[graph.V()];
        for (int v = 0; v < graph.V(); v++) {
            if (!marked[v]) {
                dfs(graph, v);
            }
        }
    }

    private void dfs(Digraph graph, int v) {
        onStack[v] = true;
        marked[v] = true;
        for (var w : graph.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(graph, w);
            } else if (onStack[w]) {
                var currentCycle = new Stack<Integer>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    currentCycle.push(x);
                }
                currentCycle.push(w);
                currentCycle.push(v);

                if (cycle == null || cycle.size() > currentCycle.size()) {
                    cycle = currentCycle;
                }
            }
        }
        onStack[v] = false;
    }

    public boolean hasCycle() {
        return cycle != null;
    }

    /**
     * @return shortest cycle in a given digraph or null
     * if graph is acyclic
     */
    public Iterable<Integer> cycle() {
        return cycle;
    }
}
