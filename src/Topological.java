public class Topological {
    private Iterable<Integer> order; // topological order

    public Topological(Digraph graph) {
        var cycleFinder = new DirectedCycle(graph);
        if (!cycleFinder.hasCycle()) {
            var dfs = new DepthFirstOrder(graph);
            order = dfs.reversePost();
        }
    }

    /**
     * @return Is graph a directed acyclic graph?
     */
    public boolean isDAG() {
        return order != null;
    }

    /**
     * @return vertices in topological order
     */
    public Iterable<Integer> order() {
        return order;
    }
}
