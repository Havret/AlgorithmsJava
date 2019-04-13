/**
 * Data type for determining whether an undirected graph is bipartite or whether
 * it has an odd-length cycle.
 */
public class BipartiteX {
    private static final boolean WHITE = false;

    private boolean isBipartite;
    private boolean[] color;
    private boolean[] marked;
    private int[] edgeTo;
    private Queue<Integer> cycle;


    public BipartiteX(Graph graph) {
        isBipartite = true;
        color = new boolean[graph.V()];
        marked = new boolean[graph.V()];
        edgeTo = new int[graph.V()];

        for (int v = 0; v < graph.V() && isBipartite; v++) {
            if (!marked[v]) {
                dfs(graph, v);
            }
        }
    }

    private void dfs(Graph graph, int s) {
        var queue = new Queue<Integer>();
        color[s] = WHITE;
        marked[s] = true;
        queue.enqueue(s);

        while (!queue.isEmpty()) {
            var v = queue.dequeue();
            for (var w : graph.adj(v)) {
                if (!marked[w]) {
                    marked[w] = true;
                    edgeTo[w] = v;
                    color[w] = !color[v];
                    queue.enqueue(w);
                } else if (color[w] == color[v]) {
                    isBipartite = false;
                    cycle = new Queue<>();
                    var stack = new Stack<Integer>();
                    int x = v, y = w;
                    while (x != y) {
                        stack.push(x);
                        cycle.enqueue(y);
                        x = edgeTo[x];
                        y = edgeTo[y];
                    }
                    stack.push(x);
                    while (!stack.isEmpty()) {
                        cycle.enqueue(stack.pop());
                    }
                    cycle.enqueue(w);
                    return;
                }
            }
        }
    }

    public boolean isBipartite() {
        return isBipartite;
    }

    public Iterable<Integer> oddCycle() {
        return cycle;
    }

    public boolean color(int v) {
        if (!isBipartite)
            throw new UnsupportedOperationException("Graph is not bipartite");
        return color[v];
    }
}
