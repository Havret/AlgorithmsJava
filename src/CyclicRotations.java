import java.util.*;

public class CyclicRotations {
    private CyclicRotations() {
    }

    public static boolean hasCyclicRotations(String[] array) {
        var fingerPrintSet = new HashSet<String>();
        for (String string : array) {
            if (fingerPrintSet.contains(string)) {
                return true;
            }

            for (int i = 1; i < string.length(); i++) {
                String head = string.substring(0, i);
                String tail = string.substring(i);
                fingerPrintSet.add(tail + head);
            }
        }

        return false;
    }
}