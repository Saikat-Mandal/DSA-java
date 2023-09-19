import java.util.Arrays;

class knapsack {

    // recursion
    public static int kp(int val[], int[] wt, int W, int n) {
        if (n == 0 || W == 0) {
            return 0;
        }
        if (wt[n - 1] <= W) {
            return Math.max(val[n - 1] + kp(val, wt, W - wt[n - 1], n - 1), kp(val, wt, W, n - 1));
        }
        return kp(val, wt, W, n - 1);
    }

    // memoization
    public static int kp2(int val[], int[] wt, int W, int n, int dp[][]) {
        if (n == 0 || W == 0) {
            return 0;
        }
        if (dp[n][W] != -1) {
            return dp[n][W];
        }

        if (wt[n - 1] <= W) {
            return dp[n][W] = Math.max(val[n - 1] + kp2(val, wt, W - wt[n - 1], n - 1, dp), kp2(val, wt, W, n - 1, dp));
        }
        return dp[n][W] = kp2(val, wt, W, n - 1, dp);
    }

    // bottom up

    public static int kp3(int val[], int[] wt, int W, int n) {
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
                    dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][W];

    }

    public static void main(String args[]) {
        int val[] = { 60, 100, 120 };
        int wt[] = { 10, 20, 30 };

        int dp[][] = new int[val.length + 1][51];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        // System.out.println(kp2(val, wt, 50, val.length, dp));
        System.out.println(kp3(val, wt, 50, val.length));
    }
}