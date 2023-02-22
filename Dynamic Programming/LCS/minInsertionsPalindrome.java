public class minInsertionsPalindrome {

    public static int minInsertions(String s) {
        String r = "";
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            b.append(s.charAt(i));
        }
        r = b.reverse().toString();
        int m = s.length();
        int n = r.length();
        return helper(s, r, m, n);
    }

    public static int helper(String s1, String s2, int m, int n) {
        int dp[][] = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return s1.length() - dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(minInsertions("mbadm"));
        System.out.println(minInsertions("leetcode"));
    }
}
