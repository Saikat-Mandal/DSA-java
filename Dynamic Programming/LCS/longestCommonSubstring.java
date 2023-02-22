public class longestCommonSubstring {
    public static int longestCommonSubstr(String s1, String s2, int n, int m) {
        return bottomUp(s1, s2, n, m);
    }

    // recursion
    public static int helper(String s1, String s2, int n, int m, int count) {
        if (n == 0 || m == 0)
            return count;
        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            count = helper(s1, s2, n - 1, m - 1, count + 1);
        }
        count = Math.max(Math.max(helper(s1, s2, n, m - 1, 0), helper(s1, s2, n - 1, m, 0)), count);

        return count;
    }

    // bottom up
    public static int bottomUp(String s1, String s2, int n, int m) {
        int dp[][] = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }
        int best_count = 0;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    best_count = Math.max(dp[i][j], best_count);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return best_count;
    }

    public static void main(String[] args) {
        String S1 = "ABCDGH", S2 = "ACDGHR";
        int n = S1.length(), m = S2.length();
        System.out.println(bottomUp(S1, S2, n, m));

    }
}
