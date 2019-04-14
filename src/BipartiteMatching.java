public class BipartiteMatching {
    private static final int UNMATCHED = -1;
    private final int V;
    private BipartiteX bipartition;
    private int cardinality;
    private int[] mate;
    private int[] edgeTo;

    public BipartiteMatching(Graph graph) {
        bipartition = new BipartiteX(graph);
        if (!bipartition.isBipartite()) {
            throw new IllegalArgumentException("graph is not bipartite");
        }

        this.V = graph.V();

        mate = new int[V];
        for (int v = 0; v < V; v++) {
            mate[v] = UNMATCHED;
        }

        while (hasAugmentingPath(graph)) {
            int t = 1;
            for (int v = 0; v < graph.V(); v++) {
                if (!isMatched(v) && edgeTo[v] != -1) {
                    t = v;
                    break;
                }
            }

            for (int v = t; v != -1; v = edgeTo[edgeTo[v]]) {
                int w = edgeTo[v];
                mate[v] = w;
                mate[w] = v;
            }
            cardinality++;
        }
    }

    private boolean hasAugmentingPath(Graph graph) {
        boolean[] marked = new boolean[V];
        edgeTo = new int[V];
        for (int v = 0; v < V; v++) {
            edgeTo[v] = -1;
        }

        var queue = new Queue<Integer>();
        for (int v = 0; v < V; v++) {
            if (bipartition.color(v) && !isMatched(v)) {
                queue.enqueue(v);
                marked[v] = true;
            }

        }

        while (!queue.isEmpty()) {
            int v = queue.dequeue();
            for (var w : graph.adj(v)) {
                if (isResidualGraphEdge(v, w) && !marked[w]) {
                    edgeTo[w] = v;
                    marked[w] = true;
                    if (!isMatched(w)) {
                        return true;
                    }
                    queue.enqueue(w);
                }
            }
        }

        return false;
    }

    private boolean isResidualGraphEdge(int v, int w) {
        if ((mate[v] != w) && bipartition.color(v)) {
            return true;
        }
        if ((mate[v] == w) && !bipartition.color(v)) {
            return true;
        }
        return false;
    }

    private boolean isMatched(int v) {
        return mate[v] != UNMATCHED;
    }

    public boolean isPerfect() {
        return cardinality * 2 == V;
    }
}
