import java.util.LinkedList;

public class Degrees {
    private int[] indegrees;
    private int[] outdegrees;
    private LinkedList<Integer> sources;
    private LinkedList<Integer> sinks;

    public Degrees(Digraph graph) {
        indegrees = new int[graph.V()];
        outdegrees = new int[graph.V()];
        sources = new LinkedList<>();
        sinks = new LinkedList<>();

        for (int v = 0; v < graph.V(); v++) {
            for (var w : graph.adj(v)) {
                outdegrees[v]++;
                indegrees[w]++;
            }
        }

        for (int v = 0; v < graph.V(); v++) {
            if (indegree(v) == 0) {
                sources.add(v);
            }
            if (outdegree(v) == 0) {
                sinks.add(v);
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

    /**
     * @return the source vertices in a given digraph
     */
    public Iterable<Integer> sources() {
        return sources;
    }

    /**
     * @return the sinks in a given digraph
     */
    public Iterable<Integer> sinks() {
        return sinks;
    }
}
