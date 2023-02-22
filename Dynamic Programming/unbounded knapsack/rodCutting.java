import java.util.Arrays;

public class rodCutting {
    public static int cutRod(int price[], int n) {
        int N = price.length;
        int len[] = new int[N];
        for (int i = 0; i < len.length; i++) {
            len[i] = i + 1;
        }
        int dp[][] = new int[N + 1][n + 1];
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (len[i - 1] <= j) {
                    dp[i][j] = Math.max(price[i - 1] + dp[i][j - len[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[N][n];
    }

    public static void main(String[] args) {
        int price[] = { 1, 5, 8, 9, 10, 17, 17, 2 };
        System.out.println(cutRod(price, 8));
    }
}
