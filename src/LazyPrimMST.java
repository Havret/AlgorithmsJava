/**
 * Lazy version of Prim's MST algorithm
 */
public class LazyPrimMST {
    private boolean[] marked;   // MST vertices
    private Queue<Edge> mst;    // MST edges
    private MinPQ<Edge> pq;     // crossing (and ineligible) edges

    public LazyPrimMST(EdgeWeightedGraph graph) {
        pq = new MinPQ<>();
        marked = new boolean[graph.V()];
        mst = new Queue<>();

        // assumes that graph is connected
        visit(graph, 0);
        while (!pq.isEmpty()) {
            Edge edge = pq.delMin();
            int v = edge.either(), w = edge.other(v);

            // skip if ineligible
            if (marked[v] && marked[w]) {
                continue;
            }
            mst.enqueue(edge);
            if (!marked[v]) {
                visit(graph, v);
            }
            if (!marked[w]) {
                visit(graph, w);
            }
        }
    }

    private void visit(EdgeWeightedGraph graph, int v) {
        marked[v] = true;
        for (Edge edge : graph.adj(v)) {
            if (!marked[edge.other(v)]) {
                pq.insert(edge);
            }
        }
    }

    public Iterable<Edge> edges() {
        return mst;
    }

    public double weight() {
        return -1;
    }
}
