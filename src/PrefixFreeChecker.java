public class PrefixFreeChecker {
    private Node root;
    private boolean isPrefixFree = true;

    private static class Node {
        boolean isFinal;
        Node[] next = new Node[2];
    }

    public void put(String code) {
        root = put(root, code, 0);
    }

    private Node put(Node x, String code, int d) {
        if (x == null) {
            x = new Node();
        }

        if (d == code.length()) {
            x.isFinal = true;
            return x;
        }

        if (x.isFinal) {
            isPrefixFree = false;
        }

        var c = getIndex(code.charAt(d));
        x.next[c] = put(x.next[c], code, d + 1);
        return x;
    }

    private int getIndex(char c) {
        if (c == '0') {
            return 0;
        } else {
            return 1;
        }
    }

    public boolean isPrefixFree() {
        return isPrefixFree;
    }
}
