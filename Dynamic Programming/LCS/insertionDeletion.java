public class insertionDeletion {
    public static int minOperations(String str1, String str2) {
        return helper(str1, str2, str1.length(), str2.length());
    }

    public static int helper(String s1, String s2, int m, int n) {
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

        int lcs = dp[m][n];

        return (s1.length() - lcs) + (s2.length() - lcs);
    }

    public static void main(String[] args) {
        System.out.println(minOperations("heap", "pea"));
    }

}
