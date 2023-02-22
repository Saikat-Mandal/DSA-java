public class equalSumPartition {

    // recursion
    public static boolean isSubsetSum(int n, int nums[], int sum) {
        if (sum == 0)
            return true;
        if (n == 0)
            return false;
        if (nums[n - 1] <= sum) {
            return isSubsetSum(n - 1, nums, sum) || isSubsetSum(n - 1, nums, sum - nums[n - 1]);
        }
        return isSubsetSum(n - 1, nums, sum);
    }

    // tabulation

    public static boolean subs(int n, int nums[], int sum) {
        boolean dp[][] = new boolean[n + 1][sum + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i < sum + 1; i++) {
            dp[0][i] = false;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][sum];
    }

    public static boolean canPartition(int[] nums) {

        int sum = 0;
        for (int i = 0; i < nums.length; i++)
            sum += nums[i];
        if (sum % 2 != 0) {
            return false;
        }

        return subs(nums.length, nums, sum / 2);

    }

    public static void main(String[] args) {
        int nums[] = { 3, 1, 5, 9, 12 };
        System.out.println(canPartition(nums));
    }
}
