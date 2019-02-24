import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class EulerianCycle {
    private Stack<Integer> cycle;

    public EulerianCycle(Graph G) {
        if (G.E() == 0) return;

        for (int v = 0; v < G.V(); v++)
            if (Graph.degree(G, v) % 2 != 0)
                return;

        Queue<Edge>[] adj = (Queue<Edge>[]) new LinkedList[G.V()];
        for (int v = 0; v < G.V(); v++)
            adj[v] = new LinkedList<>();

        for (int v = 0; v < G.V(); v++) {
            for (int w : G.adj(v)) {
                if (v < w) {
                    Edge e = new Edge(v, w);
                    adj[v].add(e);
                    adj[w].add(e);
                }
            }
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        // greedily search through edges in iterative DFS style
        cycle = new Stack<>();
        while (!stack.isEmpty()) {
            int v = stack.pop();
            while (!adj[v].isEmpty()) {
                Edge edge = adj[v].remove();
                if (edge.isUsed) continue;
                edge.isUsed = true;
                stack.push(v);
                v = edge.other(v);
            }
            // push vertex with no more leaving edges to cycle
            cycle.push(v);
        }

        // check if all edges are used
        if (cycle.size() != G.E() + 1)
            cycle = null;
    }

    public boolean hasEulerianCycle() {
        return cycle != null;
    }

    public Iterable<Integer> cycle() {
        return cycle;
    }

    private static class Edge {
        private final int v;
        private final int w;
        private boolean isUsed;

        Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }

        int other(int vertex) {
            if (vertex == v) return w;
            else if (vertex == w) return v;
            else throw new IllegalArgumentException();
        }
    }
}
