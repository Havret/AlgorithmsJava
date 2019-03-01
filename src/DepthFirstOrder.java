public class DepthFirstOrder {
    private boolean[] marked;
    private Queue<Integer> pre; // vertices in preorder
    private Queue<Integer> post; // vertices in postorder
    private Stack<Integer> reversePost; // vertices in reverse postorder

    public DepthFirstOrder(Digraph graph) {
        pre = new Queue<>();
        post = new Queue<>();
        reversePost = new Stack<>();
        marked = new boolean[graph.V()];

        for (int v = 0; v < graph.V(); v++) {
            if (!marked[v]) {
                dfs(graph, v);
            }
        }
    }

    private void dfs(Digraph graph, int v) {
        pre.enqueue(v);

        marked[v] = true;
        for (var w : graph.adj(v)) {
            if (!marked[w]) {
                dfs(graph, w);
            }
        }

        post.enqueue(v);
        reversePost.push(v);
    }

    public Iterable<Integer> pre() {
        return pre;
    }

    public Iterable<Integer> post() {
        return post;
    }

    public Iterable<Integer> reversePost() {
        return reversePost;
    }
}
