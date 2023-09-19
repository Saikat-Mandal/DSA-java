import java.util.Arrays;

class subsetSum {

    // recursion

    public static boolean subSum(int[] arr, int sum, int n, int[][] dp) {
        if (sum == 0)
            return true;
        if (n == 0)
            return arr[0] == sum;

        boolean notTake = subSum(arr, sum, n - 1, dp);
        boolean take = false;

        if (arr[n - 1] <= sum) {
            take = subSum(arr, sum - arr[n - 1], n - 1, dp);
        }
        return take || notTake;
    }

    // tabulation

    public static boolean tab(int[] arr, int sum, int n) {
        boolean dp[][] = new boolean[n + 1][sum + 1];

        for (int i = 0; i < n; i++)
            dp[i][0] = true;

        dp[0][arr[0]] = true;

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                boolean notTake = dp[i - 1][sum];
                boolean take = false;

                if (arr[i] <= sum) {
                    take = dp[i - 1][sum - arr[i - 1]];
                }

                dp[i][j] = take || notTake;
            }
        }
        return dp[n][sum];
    }

    public static void main(String[] args) {
        int arr[] = { 3, 34, 4, 12, 5, 2 };
        int dp[][] = new int[arr.length + 1][10];
        // System.out.println(subSum(arr, 9, arr.length, dp));
        System.out.println(tab(arr, 9, arr.length));

    }
}