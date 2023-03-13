import java.util.Arrays;

public class Knapsack {
    // recursion
    public static int knapSack(int W, int wt[], int val[], int n) {
        if (n == 0 || W == 0)
            return 0;
        if (wt[n - 1] <= W) {
            return Math.max(val[n - 1] + knapSack(W - wt[n - 1], wt, val, n - 1), knapSack(W, wt, val, n - 1));
        }
        return knapSack(W, wt, val, n - 1);
    }

    // memoized
    public static int knapsack(int wt[], int val[], int n, int W, int dp[][]) {
        if (W == 0 || n == 0) {
            return 0;
        }
        if (dp[n][W] != -1) {
            return dp[n][W];
        }
        if (wt[n - 1] <= W) {
            int ans1 = val[n - 1] + knapsack(wt, val, n - 1, W - wt[n - 1], dp);
            int ans2 = knapsack(wt, val, n - 1, W, dp);
            return dp[n][W] = Math.max(ans1, ans2);
        }
        return knapsack(wt, val, n - 1, W, dp);
    }

    // tabulation

    public static int knapsack2(int wt[], int val[], int n, int W) {
        int dp[][] = new int[n + 1][W + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < W + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                if (wt[i - 1] <= j) {
                    dp[i][j] = Math.max((val[i - 1] + dp[i - 1][j - wt[i - 1]]), dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][W];

    }

    public static void main(String[] args) {
        int val[] = { 15, 14, 10, 45, 30 };
        int wt[] = { 2, 5, 1, 3, 4 };
        int W = 7;
        int dp[][] = new int[val.length + 1][W + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        // System.out.println(knapsack(wt, val, val.length, W, dp));
        System.out.println(knapsack2(wt, val, val.length, W));
        // knapsack2(wt, val, W, W);
    }
}