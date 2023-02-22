public class countSubsets {
    // recursion
    public static int subsets(int[] nums, int sum, int n) {
        int dp[][] = new int[n + 1][sum + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < sum + 1; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (nums[i - 1] <= j) {
                    dp[i][j] = (dp[i - 1][j - nums[i - 1]] + dp[i - 1][j]) % 1000000007;
                } else {
                    dp[i][j] = (dp[i - 1][j]) % 1000000007;
                }
            }
        }
        return (dp[n][sum]) % 1000000007;
    }

    public static void main(String[] args) {
        int arr[] = { 3, 3, 3, 3 };
        int n = arr.length;
        int x = 6;
        System.out.println(subsets(arr, x, n));
    }
}
