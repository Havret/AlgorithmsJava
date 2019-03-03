public class HamiltonianPathInDAG {
    private Iterable<Integer> path;

    public HamiltonianPathInDAG(Digraph graph) {
        Topological topological = new Topological(graph);

        if (!topological.isDAG()) {
            return;
        }

        Integer previous = null;
        for (int next : topological.order()) {
            if (previous != null) {
                if (!graph.hasEdge(previous, next)) {
                    return;
                }
            }
            previous = next;
        }

        path = topological.order();
    }

    public Iterable<Integer> path() {
        return path;
    }

    public boolean hasPath() {
        return path != null;
    }
}
