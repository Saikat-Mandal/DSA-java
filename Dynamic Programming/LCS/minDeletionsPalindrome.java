public class minDeletionsPalindrome {
    public static int minDeletions(String s, int n) {
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            b.append(s.charAt(i));
        }
        String r = b.reverse().toString();
        int m = r.length();
        int dp[][] = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (r.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return s.length() - dp[m][n];

    }

    public static void main(String[] args) {
        String s = "aebebda";
        System.out.println(minDeletions(s, s.length()));
    }
}
