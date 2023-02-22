public class practice {
    // recursion
    public static Boolean isSubsetSum(int N, int arr[], int sum) {
        if (N == 0) {
            return false;
        }
        if (sum == 0) {
            return true;
        }
        if (arr[N - 1] <= sum) {
            return isSubsetSum(N - 1, arr, sum - arr[N - 1]) || isSubsetSum(N - 1, arr, sum);
        }
        return isSubsetSum(N - 1, arr, sum);
    }

    // tabulation
    public static Boolean isSubsetSum2(int n, int arr[], int sum) {
        boolean dp[][] = new boolean[n + 1][sum + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i < sum + 1; i++) {
            dp[0][i] = false;
        }
        for (int i = 1; i < n + 1; i++) {

            for (int j = 1; j < sum + 1; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][sum];
    }

    public static void main(String[] args) {
        int arr[] = { 3, 34, 4, 12, 5, 2 };
        int sum = 9;
        int n = arr.length;
        System.out.println(isSubsetSum2(n, arr, sum));
    }
}
