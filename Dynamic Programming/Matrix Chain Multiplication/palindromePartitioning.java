import java.util.Arrays;

public class palindromePartitioning {
    static int[][] dp = new int[501][501];

    public static int palindromicPartition(String str) {
        // code here
        return solve2(str, 0, str.length() - 1);
    }

    // recursion
    public static int solve(String s, int i, int j) {
        if (i >= j)
            return 0;
        if (isPalindrome(s, i, j)) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int temp = solve(s, i, k) + solve(s, k + 1, j) + 1;
            res = Math.min(res, temp);
        }
        return res;
    }

    // memoization

    public static int solve2(String s, int i, int j) {
        if (i >= j)
            return 0;
        if (isPalindrome(s, i, j)) {
            return 0;
        }
        if (dp[i][j] != -1)
            return dp[i][j];
        int res = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int temp = solve2(s, i, k) + solve2(s, k + 1, j) + 1;
            res = Math.min(res, temp);
        }
        return dp[i][j] = res;
    }

    public static boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "ababbbabbababa";
        for (int[] rows : dp) {
            Arrays.fill(rows, -1);
        }
        System.out.println(palindromicPartition(s));
    }
}
