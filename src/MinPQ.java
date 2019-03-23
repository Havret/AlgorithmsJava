public class MinPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int n = 0;

    public MinPQ(int initCapacity) {
        pq = (Key[]) new Comparable[initCapacity + 1];
    }

    public MinPQ() {
        this(1);
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void insert(Key key) {
        // double size of array if necessary
        if (n == pq.length - 1) {
            resize(2 * pq.length);
        }

        // add key, and percolate it up to maintain heap invariant
        pq[++n] = key;
        swim(n);
    }

    private void resize(int capacity) {
        Key[] temp = (Key[]) new Comparable[capacity];
        for (int i = 0; i <= n; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }

    private void swim(int k) {
        while (k > 1 && greater(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    public Key delMin() {
        Key min = pq[1];
        exch(1, n--);
        pq[n + 1] = null;
        sink(1);

        if ((n > 0) && n == (pq.length - 1) / 4) {
            resize(pq.length / 2);
        }

        return min;
    }

    private void sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && greater(j, j + 1)) {
                j++;
            }
            if (!greater(k, j)) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }


    private boolean greater(int i, int j) {
        return pq[i].compareTo(pq[j]) > 0;
    }

    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }
}
