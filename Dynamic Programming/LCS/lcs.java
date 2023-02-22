public class lcs {
    // static int dp[][] = new int[1001][1001];

    // recursive
    public static int longestCommonSubsequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        // for (int i = 0; i < n + 1; i++) {
        // for (int j = 0; j < m + 1; j++) {
        // dp[i][j] = -1;
        // }
        // }
        return bottomUp(str1, str2, n, m);
        // return memo(str1, str2, n, m);
        // return helper(str1, str2, str1.length(), str2.length());

    }

    public static int helper(String str1, String str2, int n, int m) {
        if (n == 0 || m == 0)
            return 0;
        if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
            return 1 + helper(str1, str2, n - 1, m - 1);
        } else {
            return Math.max(helper(str1, str2, n - 1, m), helper(str1, str2, n, m - 1));
        }
    }
    // memoized

    // public static int memo(String str1, String str2, int n, int m) {
    // if (n == 0 || m == 0)
    // return 0;

    // if (dp[n][m] != -1) {
    // return dp[n][m];
    // }
    // if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
    // return dp[n][m] = 1 + memo(str1, str2, n - 1, m - 1);
    // } else {
    // return dp[n][m] = Math.max(memo(str1, str2, n - 1, m), memo(str1, str2, n, m
    // - 1));
    // }
    // }

    public static int bottomUp(String str1, String str2, int n, int m) {
        int dp[][] = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        String text1 = "abcde", text2 = "def";
        System.out.println(longestCommonSubsequence(text1, text2));
    }
}