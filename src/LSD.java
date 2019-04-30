/**
 * least-significant-digit first (LSD) string sort implementation
 */
public class LSD {
    private static final int BITS_PER_BYTE = 8;

    private LSD() {
    }

    public static void sort(String[] a, int W) {
        int N = a.length;
        int R = 256;
        var aux = new String[N];

        for (int d = W - 1; d >= 0; d--) {
            // Compute frequency counts.
            var count = new int[R + 1];
            for (int i = 0; i < N; i++) {
                count[a[i].charAt(d) + 1]++;
            }

            // Transform counts to indices.
            for (int r = 0; r < R; r++) {
                count[r + 1] += count[r];
            }

            // Distribute.
            for (int i = 0; i < N; i++) {
                aux[count[a[i].charAt(d)]++] = a[i];
            }

            // Copy back.
            for (int i = 0; i < N; i++) {
                a[i] = aux[i];
            }
        }
    }

    /**
     * Rearranges the array of 64-bit integers in ascending order.
     * @param a the array to be sorted
     */
    public static void sort(long[] a) {
        final int BITS = 64;                 // each long is 64 bits
        final int R = 1 << BITS_PER_BYTE;    // each bytes is between 0 and 255
        final int MASK = R - 1;              // 0xFF
        final int w = BITS / BITS_PER_BYTE;  // each int is 8 bytes

        int n = a.length;
        long[] aux = new long[n];

        for (int d = 0; d < w; d++) {
            // Compute frequency counts.
            int[] count = new int[R + 1];
            for (int i = 0; i < n; i++) {
                int c = (int) (a[i] >> BITS_PER_BYTE * d) & MASK;
                count[c + 1]++;
            }

            // Transform counts to indices.
            for (int r = 0; r < R; r++)
                count[r + 1] += count[r];

            // Distribute.
            for (int i = 0; i < n; i++) {
                int c = (int) (a[i] >> BITS_PER_BYTE * d) & MASK;
                aux[count[c]++] = a[i];
            }

            // Copy back.
            for (int i = 0; i < n; i++)
                a[i] = aux[i];
        }
    }
}
