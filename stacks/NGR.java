
import java.util.Arrays;
import java.util.Stack;

public class NGR {

    public static int largestRectangleArea(int[] heights) {
        int[] left = NSL(heights);
        int[] right = NSR(heights);
        int ans = 0;

        for (int i = 0; i < heights.length; i++) {
            ans = Math.max(ans, heights[i] * ((right[i] - left[i]) - 1));
        }
        return ans;
    }

    public static int[] NSL(int[] nums) {
        int ans[] = new int[nums.length];
        Stack<Integer> st = new Stack<>();
        int p = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                ans[p++] = -1;
            } else {
                ans[p++] = st.peek();
            }
            st.push(i);
        }
        return ans;
    }

    public static int[] NSR(int[] nums) {
        int ans[] = new int[nums.length];
        Stack<Integer> st = new Stack<>();
        int p = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                ans[p--] = nums.length;
            } else {
                ans[p--] = st.peek();
            }
            st.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 3, 2, 4 };
        System.out.println(Arrays.toString(NSR(nums)));
    }
}
