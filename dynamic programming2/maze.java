import java.util.HashMap;
import java.util.Map;

public class maze {

    // public static int count(int r, int c, int dp[][]) {
    // if (r == 1 || c == 1)
    // return dp[r][c] = 1;
    // if (dp[r][c] == 0 && r - 1 > 0 && c - 1 > 0) {
    // dp[r][c] = count(r - 1, c, dp) + count(r, c - 1, dp);
    // }
    // return dp[r][c];
    // }
    public static long count(int r, int c, Map<String, Long> memo) {
        String key = r + "," + c;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        if (r == 1 || c == 1)
            return 1L;

        memo.put(key, count(r - 1, c, memo) + count(r, c - 1, memo));

        return memo.get(key);
    }

    public static void main(String[] args) {
        // int nums[][] = new int[4][4];
        // for (int i = 0; i < nums.length; i++) {
        // for (int j = 0; j < nums.length; j++) {
        // nums[i][j] = 0;
        // }
        // }
        Map<String, Long> map = new HashMap<>();
        System.out.println(count(1, 1, map));
        System.out.println(count(2, 3, map));
        System.out.println(count(3, 2, map));
        System.out.println(count(3, 3, map));
        System.out.println(count(18, 18, map));

    }
}