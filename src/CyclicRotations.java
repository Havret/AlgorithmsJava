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

    public static boolean areCyclicRotations(String a, String b) {
        var fingerPrintSet = new HashSet<String>();
        for (int i = 0; i < a.length(); i++) {
            String head = a.substring(0, i);
            String tail = a.substring(i);
            fingerPrintSet.add(tail + head);
        }
        return fingerPrintSet.contains(b);
    }

}