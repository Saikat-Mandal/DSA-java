import java.util.Arrays;

public class frogjump {
    // memo
    public static int jump(int arr[], int i, int[] dp) {
        if (i == 0)
            return 0;
        if (dp[i] != -1)
            return dp[i];
        int left = jump(arr, i - 1, dp) + Math.abs(arr[i] - arr[i - 1]);
        int right = Integer.MAX_VALUE;
        if (i > 1) {
            right = jump(arr, i - 2, dp) + Math.abs(arr[i] - arr[i - 2]);
        }
        return dp[i] = Math.min(left, right);
    }

    // tab
    public static int jump2(int arr[]) {
        int dp[] = new int[arr.length + 1];
        dp[0] = 0;

        for (int i = 1; i < arr.length; i++) {
            int left = dp[i - 1] + Math.abs(arr[i] - arr[i - 1]);
            int right = Integer.MAX_VALUE;
            if (i > 1) {
                right = dp[i - 2] + Math.abs(arr[i] - arr[i - 2]);
            }
            dp[i] = Math.min(left, right);
        }
        return dp[arr.length - 1];
    }

    public static void main(String[] args) {
        int arr[] = { 30, 10, 60, 10, 60, 50 };
        int dp[] = new int[arr.length + 1];
        Arrays.fill(dp, -1);
        // System.out.println(jump(arr, arr.length - 1, dp));
        System.out.println(jump2(arr));
    }
}
