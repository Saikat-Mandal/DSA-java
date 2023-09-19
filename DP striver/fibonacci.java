import java.lang.reflect.Array;
import java.util.Arrays;

public class fibonacci {

    // memo
    public static int fib(int n, int[] dp) {

        if (n <= 1)
            return n;

        if (dp[n] != -1) {
            return dp[n];
        }
        return dp[n] = fib(n - 1, dp) + fib(n - 2, dp);
    }

    // tabulation
    public static int tab(int n, int[] dp) {
        dp[1] = 1;
        dp[0] = 0;

        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 8;
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);

        System.out.println(tab(n, dp));
    }
}
