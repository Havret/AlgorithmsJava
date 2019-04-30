/**
 * Class to determine whether there are two distinct integer i and i in an array a
 * of n 64-bit integers such that a[i] + a[j] = T
 */
public class TwoSum {
    private TwoSum() {
    }

    public static boolean sumExists(long[] a, long T) {
        LSD.sort(a);

        int i = 0, j = a.length - 1;

        while (i != j) {
            long sum = a[i] + a[j];
            if (sum == T) {
                return true;
            }

            if (sum < T) {
                i++;
            } else if (sum > T) {
                j--;
            }
        }

        return false;
    }
}
