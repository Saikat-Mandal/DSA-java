import java.util.Arrays;

public class subsetSum {
    // recursion
    public static boolean isSubsetSum(int N, int arr[], int sum) {
        if (N == 0)
            return false;
        if (sum == 0)
            return true;

        if (arr[N - 1] <= sum) {
            return isSubsetSum(N - 1, arr, sum) || isSubsetSum(N - 1, arr, sum - arr[N - 1]);
        }
        return isSubsetSum(N - 1, arr, sum);
    }

    // memoization

    public static int isSubsetSum2(int N, int arr[], int sum, int[][] dp) {
        if (N == 0)
            return 0;
        if (sum == 0)
            return 1;

        if (dp[N - 1][sum] != 0) {
            return dp[N - 1][sum];
        }
        if (arr[N - 1] > sum) {
            dp[N - 1][sum] = isSubsetSum2(N - 1, arr, sum, dp);
        } else {
            if (isSubsetSum2(N - 1, arr, sum, dp) != 0
                    || isSubsetSum2(N - 1, arr, sum - arr[N - 1], dp) != 0) {
                return dp[N - 1][sum] = 1;
            } else
                return dp[N - 1][sum] = 0;
        }
        return dp[N - 1][sum];
    }

    // tabulation
    public static boolean isSubsetSum3(int N, int arr[], int sum) {
        boolean dp[][] = new boolean[N + 1][sum + 1];
        for (int i = 0; i < N + 1; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i < sum + 1; i++) {
            dp[0][i] = false;
        }

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[N][sum];
    }

    public static void main(String[] args) {
        int arr[] = { 3, 34, 4, 12, 5, 2 };
        int sum = 9;
        int dp[][] = new int[arr.length + 1][sum + 1];
        System.out.println(isSubsetSum3(arr.length, arr, sum));

    }
}
