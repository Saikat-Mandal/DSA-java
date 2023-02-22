public class SCS {
    public static int lcs(String s1, String s2, int m, int n) {
        int dp[][] = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int size = dp[m][n];
        return s1.length() + s2.length() - size;
    }

    public static void main(String[] args) {
        String s1 = "abcd", s2 = "xycd";
        System.out.println(lcs(s1, s2, s1.length(), s2.length()));
    }
}
