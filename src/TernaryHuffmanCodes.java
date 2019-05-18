public class TernaryHuffmanCodes {
    // alphabet size of extended ASCII
    private static final int R = 256;

    private static class Node implements Comparable<Node> {
        private char ch;	// unused for internal node
        private int freq;	// unused for expand
        private final Node left, middle, right;

        public Node(char ch, int freq, Node left, Node middle, Node right) {
            this.ch = ch;
            this.freq = freq;
            this.left = left;
            this.middle = middle;
            this.right = right;
        }

        public boolean isLeaf() {
            return left == null && middle == null && right == null;
        }

        @Override
        public int compareTo(Node that) {
            return this.freq - that.freq;
        }
    }

    public static void compress() {
        String s = BinaryStdIn.readString();
        char[] input = s.toCharArray();
        int[] freq = new int[R];
        for (int i = 0; i < input.length; i++) {
            freq[input[i]]++;
        }
        Node root = buildTrie(freq);

        String[] st = new String[R];
        buildCode(st, root, "");

        // print trie for decoder
        writeTrie(root);

        // print number of bytes in original uncompressed message
        BinaryStdOut.write(input.length);

        for (int i = 0; i < input.length; i++) {
            String code = st[input[i]];
            for (int j = 0; j < code.length(); j++) {
                if (code.charAt(j) == '0') {
                    BinaryStdOut.write('0', 2);
                } else if (code.charAt(j) == '1') {
                    BinaryStdOut.write('1', 2);
                } else if (code.charAt(j) == '2') {
                    BinaryStdOut.write('2', 2);
                } else {
                    throw new IllegalStateException("Illegal state");
                }
            }
        }
        BinaryStdOut.close();
    }

    public static void expand() {
        Node root = readTrie();			// read in encoding trie
        int N = BinaryStdIn.readInt();	// read in number of chars

        for (int i = 0; i < N; i++) {
            Node x = root;
            while (!x.isLeaf()) {
                if (BinaryStdIn.readChar(2) == '0') {
                    x = x.left;
                } else if (BinaryStdIn.readChar(2) == '1') {
                    x = x.middle;
                } else {
                    x = x.right;
                }
            }
            BinaryStdOut.write(x.ch, 8);
        }
        BinaryStdOut.close();
    }

    private static Node buildTrie(int[] freq) {
        MinPQ<Node> pq = new MinPQ<>();
        for (char i = 0; i < R; i++) {
            if (freq[i] > 0) {
                pq.insert(new Node(i, freq[i], null, null, null));
            }
        }
        if (pq.size() % 2 == 0) {
            pq.insert(new Node('\0', 0, null, null, null));
        }
        while (pq.size() > 1) {
            Node x = pq.delMin();
            Node y = pq.delMin();
            Node z = pq.delMin();
            Node parent = new Node('\0', x.freq + y.freq + z.freq, x, y, z);
            pq.insert(parent);
        }
        return pq.delMin();
    }

    private static void buildCode(String[] st, Node x, String s) {
        if (!x.isLeaf()) {
            buildCode(st, x.left, s + "0");
            buildCode(st, x.middle, s + "1");
            buildCode(st, x.right, s + "2");
        }
        st[x.ch] = s;
    }

    // write a trie to a bit stream
    private static void writeTrie(Node x) {
        if (x.isLeaf()) {
            BinaryStdOut.write(true);
            BinaryStdOut.write(x.ch, 8);
            return;
        }
        BinaryStdOut.write(false);
        writeTrie(x.left);
        writeTrie(x.middle);
        writeTrie(x.right);
    }

    // read a bit steam into a trie
    private static Node readTrie() {
        if (BinaryStdIn.readBoolean()) {
            char c = BinaryStdIn.readChar(8);
            return new Node(c, 0, null, null, null);
        }
        Node x = readTrie();
        Node y = readTrie();
        Node z = readTrie();
        return new Node('\0', 0, x, y, z);		// not used for internal node
    }
}