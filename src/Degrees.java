public class Degrees {
    private int[] indegrees;
    private int[] outdegrees;

    public Degrees(Digraph graph) {
        indegrees = new int[graph.V()];
        outdegrees = new int[graph.V()];

        for (int v = 0; v < graph.V(); v++) {
            for (var w : graph.adj(v)) {
                outdegrees[v]++;
                indegrees[w]++;
            }
        }
    }


    /**
     * @return the number of directed edges that point to a given vertex v
     */
    public int indegree(int v) {
        return indegrees[v];
    }

    /**
     * @return the number of directed edges that emanate from a given vertex v
     */
    public int outdegree(int v) {
        return outdegrees[v];
    }
}
