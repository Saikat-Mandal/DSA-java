import java.util.Arrays;

public class trappingRainwater {
    public static int trap(int[] heights) {

        int left[] = maxLeft(heights);
        int right[] = maxRight(heights);

        int finalHeights[] = new int[heights.length];

        for (int i = 0; i < heights.length; i++) {
            finalHeights[i] = Math.min(left[i], right[i]) - heights[i];
        }

        int sum = 0;
        for (int i : finalHeights) {
            sum += i;
        }
        return sum;
    }

    public static int[] maxLeft(int[] heights) {

        int left[] = new int[heights.length];
        left[0] = heights[0];
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > left[i - 1]) {
                left[i] = heights[i];
            } else {
                left[i] = left[i - 1];
            }
        }
        return left;
    }

    public static int[] maxRight(int[] heights) {
        int right[] = new int[heights.length];
        right[right.length - 1] = heights[heights.length - 1];
        for (int i = heights.length - 2; i >= 0; i--) {
            if (heights[i] > right[i + 1]) {
                right[i] = heights[i];
            } else {
                right[i] = right[i + 1];
            }
        }
        return right;
    }

    public static void main(String[] args) {
        int heights[] = { 4, 2, 0, 3, 2, 5 };
        // System.out.println(max(heights));
        System.out.println(Arrays.toString(maxRight(heights)));

    }
}
