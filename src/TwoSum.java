import java.util.*;

/**
 * Class to determine whether there are two distinct integer i and i in an array a
 * of n 64-bit integers such that a[i] + a[j] = T
 */
public class TwoSum {
    private TwoSum() {
    }

    public static boolean sumExists(long[] a, long T) {
        HashSet<Long> complementSet = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            long current = a[i];
            if (complementSet.contains(current)) {
                return true;
            } else {
                long complement = T - current;
                complementSet.add(complement);
            }
        }

        return false;
    }
}
