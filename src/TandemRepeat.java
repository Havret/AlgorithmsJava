public class TandemRepeat {
    private TandemRepeat() {
    }

    public static String findTandemRepeat(String source, String base) {
        StringBuilder tandemRepeat = new StringBuilder();
        int index = 0;
        do {
            index = source.indexOf(base, index);
            if (index > -1) {
                index = index + base.length();
                tandemRepeat.append(base);
            }
        } while (index > -1);

        return tandemRepeat.toString();
    }
}
