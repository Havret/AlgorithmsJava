public class UF {
    private int[] parent;  // parent[i] = parent of i
    private byte[] rank;    // rank[i] = rank of a subtree at i (never more than 31)
    private int count;

    /**
     * Initializes N sites with integer names (0 to N-1)
     */
    public UF(int n) {
        count = n;
        parent = new int[n];
        rank = new byte[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    /**
     * add connection between p and q
     */
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if (rootP == rootQ) {
            return;
        }

        // make root of smaller rank point to root of larger rank
        if (rank[rootP] < rank[rootQ]) {
            parent[rootP] = rootQ;
        } else if (rank[rootP] > rank[rootQ]) {
            parent[rootQ] = rootP;
        } else {
            parent[rootQ] = rootP;
            rank[rootP]++;
        }
        count--;
    }

    /**
     * component identifier for p (0 to N-1)
     */
    public int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]]; // path compression by halving
            p = parent[p];
        }

        return p;
    }

    /**
     * @return true if p and q are in the same component
     */
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * @return number of components
     */
    public int count() {
        return count;
    }

}
