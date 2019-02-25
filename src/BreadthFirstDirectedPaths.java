import java.util.LinkedList;

public class BreadthFirstDirectedPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private int source;

    public BreadthFirstDirectedPaths(Digraph graph, int source) {
        marked = new boolean[graph.V()];
        edgeTo = new int[graph.V()];
        this.source = source;
        bfs(graph, source);
    }

    private void bfs(Digraph graph, int source) {
        var queue = new LinkedList<Integer>();
        queue.add(source);
        marked[source] = true;
        while (!queue.isEmpty()) {
            var v = queue.remove();
            for (var w : graph.adj(v)) {
                if (!marked[w]) {
                    queue.add(w);
                    marked[w] = true;
                    edgeTo[w] = v;
                }
            }

        }
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }

        var path = new Stack<Integer>();
        for (int x = v; x != source; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(source);
        return path;
    }

    public int distanceTo(int v) {
        if (!hasPathTo(v)) {
            throw new IllegalArgumentException();
        }
        int distance = 0;
        for (int x = v; x != source; x = edgeTo[x]) {
            distance++;
        }
        return distance;
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }
}
