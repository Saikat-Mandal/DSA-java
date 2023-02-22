import java.sql.Array;
import java.util.Arrays;

public class printSCS {

    public static String shortestCommonSupersequence(String str1, String str2) {
        return helper(str1, str2, str1.length(), str2.length());
    }

    public static String helper(String s1, String s2, int m, int n) {
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
        int i = m, j = n;
        StringBuilder b = new StringBuilder();
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                b.append(s1.charAt(i - 1));
                i--;
                j--;
            } else {
                if (dp[i][j - 1] > dp[i - 1][j]) {
                    b.append(s2.charAt(j - 1));
                    j--;
                } else {
                    b.append(s1.charAt(i - 1));
                    i--;
                }
            }
        }
        while (i > 0) {
            b.append(s1.charAt(i - 1));
            i--;
        }
        while (j > 0) {
            b.append(s2.charAt(j - 1));
            j--;
        }

        return b.reverse().toString();
    }

    public static void main(String[] args) {
        String str1 = "abac", str2 = "cab";

        System.out.println(shortestCommonSupersequence(str1, str2));
    }
}
