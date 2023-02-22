public class sequencePatternMatching {
    // recursion
    public static boolean subseq(String s1, String s2, int m, int n) {
        if (m == 0) {
            return true;
        }
        if (n == 0) {
            return false;
        }

        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return subseq(s1, s2, m - 1, n - 1);
        }
        return subseq(s1, s2, m, n - 1);
    }

    public static void main(String[] args) {
        String s2 = "ADXCPY";
        String s1 = "AXY";
        System.out.println(subseq(s1, s2, s1.length(), s2.length()));
    }
}