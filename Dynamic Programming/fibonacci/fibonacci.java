public class fibonacci {
    public static int fib(int n, int[] dp) {
        if (n == 1 || n == 0)
            return n;
        if (dp[n] != 0)
            return dp[n];

        return dp[n] = fib(n - 1, dp) + fib(n - 2, dp);
    }

    public static int fib2(int n, int[] dp) {
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 6;
        int dp[] = new int[n + 1];
        System.out.println(fib2(n, dp));

    }
}
