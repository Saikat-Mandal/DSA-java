import java.util.Arrays;
import java.util.Scanner;

public class MCM {
    public static int matrixMultiplication(int n, int arr[]) {
        return solve2(n, arr, 1, arr.length - 1);
    }

    // recursion
    public static int solve(int n, int arr[], int i, int j) {
        if (i >= j)
            return 0;

        int res = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int temp = solve(n, arr, i, k) + solve(n, arr, k + 1, j) + (arr[i - 1] * arr[k] * arr[j]);
            res = Math.min(temp, res);
        }
        return res;
    }

    static int[][] dp = new int[101][101];

    // memoization
    public static int solve2(int n, int arr[], int i, int j) {
        if (i >= j)
            return 0;
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int res = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int temp = solve2(n, arr, i, k) + solve2(n, arr, k + 1, j) + (arr[i - 1] * arr[k] * arr[j]);
            res = Math.min(temp, res);
        }
        return dp[i][j] = res;
    }

    public static void main(String[] args) {
        int arr[] = { 40, 20, 30, 10, 30 };
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        System.out.println(matrixMultiplication(arr.length, arr));
    }
}