public class KruskalMST {
    private Queue<Edge> mst;

    public KruskalMST(EdgeWeighedGraph graph) {
        mst = new Queue<>();

        MinPQ<Edge> pq = new MinPQ<>(graph.E());
        for (Edge edge : graph.edges()) {
            pq.insert(edge);
        }
        UF uf = new UF(graph.V());

        while (!pq.isEmpty() && mst.size() < graph.V() - 1) {
            Edge e = pq.delMin();
            int v = e.either(), w = e.other(v);
            if (uf.connected(v, w)) {
                continue;
            }
            uf.union(v, w);
            mst.enqueue(e);
        }
    }

    public Iterable<Edge> edges() {
        return mst;
    }
}
