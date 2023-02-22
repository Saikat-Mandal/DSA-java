public class longestRepeatingSubsequence {
    public static int LongestRepeatingSubsequence(String str) {
        String r = str;
        return helper(str, str.length(), r, r.length());
    }

    public static int helper(String s1, int m, String s2, int n) {
        int dp[][] = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1) && i != j) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String str = "axxzxy";
        System.out.println(LongestRepeatingSubsequence(str));
    }
}
