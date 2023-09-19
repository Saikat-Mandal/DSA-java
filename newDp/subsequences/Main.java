import java.util.Arrays;

class Main {
    // recursion
    public static Boolean isSubsetSum(int N, int arr[], int sum) {
        return subset(arr, N - 1, sum);
    }

    public static boolean subset(int[] arr, int index, int sum) {
        if (sum == 0)
            return true;
        if (index == 0)
            return arr[0] == sum;

        boolean notTake = subset(arr, index - 1, sum);
        boolean take = false;
        if (sum >= arr[index]) {
            take = subset(arr, index - 1, sum - arr[index]);
        }

        return take || notTake;
    }

    // memoization

    // public static int subset2(int[] arr, int index, int sum, int[][] dp) {
    // if (sum == 0)
    // return 1;
    // if (index == 0)
    // return arr[0] == sum ? 1:0;
    // if (dp[index][sum] != -1)
    // return dp[index][sum];
    // boolean notTake = subset(arr, index - 1, sum);
    // boolean take = false;
    // if (sum >= arr[index]) {
    // take = subset(arr, index - 1, sum - arr[index]);
    // }

    // return take || notTake;
    // }

    public static int tab(int[] arr, int index, int sum, int N) {
        boolean dp[][] = new boolean[N + 1][sum + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }
        dp[0][arr[0]] = true;

    }

    public static void main(String[] args) {
        int arr[] = { 3, 34, 4, 12, 5, 2 };
        int sum = 9;
        System.out.println(isSubsetSum(arr.length, arr, sum));
    }
}