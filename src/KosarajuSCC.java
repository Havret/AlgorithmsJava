/**
 * Kosaraju’s algorithm for computing strong components
 */
public class KosarajuSCC {
    private boolean[] marked; // reached vertices
    private int[] id; // component identifier
    private int count; // number of strong components

    public KosarajuSCC(Digraph graph) {
        marked = new boolean[graph.V()];
        id = new int[graph.V()];
        var order = new DepthFirstOrder(graph.reverse());
        for (var s : order.reversePost()) {
            if (!marked[s]) {
                dfs(graph, s);
                count++;
            }
        }
    }

    private void dfs(Digraph graph, int v) {
        marked[v] = true;
        id[v] = count;
        for (var w : graph.adj(v)) {
            if (!marked[w]) {
                dfs(graph, w);
            }
        }
    }

    public boolean stronglyConnected(int v, int w) {
        return id[v] == id[w];
    }

    public int id(int v) {
        return id[v];
    }

    public int count() {
        return count;
    }
}
