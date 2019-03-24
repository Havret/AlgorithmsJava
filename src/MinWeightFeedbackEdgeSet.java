public class MinWeightFeedbackEdgeSet {
    private Queue<Edge> feedbackEdgeSet;

    public MinWeightFeedbackEdgeSet(EdgeWeightedGraph graph) {
        feedbackEdgeSet = new Queue<>();

        MaxPQ<Edge> pq = new MaxPQ<>(graph.E());
        for (Edge edge : graph.edges()) {
            pq.insert(edge);
        }
        UF uf = new UF(graph.V());

        while (!pq.isEmpty() && feedbackEdgeSet.size() < graph.V() - 1) {
            Edge e = pq.delMax();
            int v = e.either(), w = e.other(v);
            if (uf.connected(v, w)) {
                continue;
            }
            uf.union(v, w);
            feedbackEdgeSet.enqueue(e);
        }

    }

    public Iterable<Edge> edges() {
        return feedbackEdgeSet;
    }
}
