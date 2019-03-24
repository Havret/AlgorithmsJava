import java.util.ArrayList;
import java.util.List;

public class NthOrderStatistic {
    public static <T extends Comparable<T>> T find(Iterable<T> items, int n) {
        var a = new ArrayList<T>();
        for (T item : items) {
            a.add(item);
        }

        int lo = 0, hi = a.size() - 1;
        while (true) {
            int pivotIndex = partition(a, lo, hi);
            if (pivotIndex == n)
                return a.get(pivotIndex);

            if (n < pivotIndex) {
                hi = pivotIndex - 1;
            } else {
                lo = pivotIndex + 1;
            }

        }
    }

    private static <T extends Comparable<T>> int partition(List<T> a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        T v = a.get(lo);
        while (true) {
            // find item on lo to swap
            while (less(a.get(++i), v)) {
                if (i == hi) break;
            }

            // find item on hi to swap
            while (less(v, a.get(--j))) {
                if (j == lo) break;
            }

            // check if pointers cross
            if (i >= j) break;

            exch(a, i, j);
        }

        // put partitioning item v at a(j)
        exch(a, lo, j);

        // now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
        return j;
    }

    // is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        if (v == w) return false;   // optimization when reference equals
        return v.compareTo(w) < 0;
    }

    // exchange a(i) and a(j)
    private static <T extends Comparable<T>> void exch(List<T> a, int i, int j) {
        var swap = a.get(i);
        a.set(i, a.get(j));
        a.set(j, swap);
    }
}
