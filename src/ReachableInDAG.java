public class ReachableInDAG {
    private Integer reachableVertex;

    public ReachableInDAG(Digraph graph) {
        Degrees degrees = new Degrees(graph);
        degrees.sinks();

        for (Integer sink : degrees.sinks()) {
            if (reachableVertex == null) {
                reachableVertex = sink;
            } else {
                reachableVertex = null;
                return;
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
