import java.util.Arrays;

public class practice {

    // brute force
    public static int maxArea(int[] height) {
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = Math.min(height[i], height[j]) * (j - i);
                ans = Math.max(ans, area);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        System.out.println(maxArea(nums));

    }
}
