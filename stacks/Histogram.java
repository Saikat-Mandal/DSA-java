import java.util.Arrays;
import java.util.Stack;

public class Histogram {
    public static int largestRectangleArea(int[] heights) {
        int left[] = NSL(heights);
        int right[] = NSR(heights);
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < heights.length; i++) {
            max = Math.max(max, ((right[i] - left[i]) - 1) * heights[i]);
        }

        return max;

    }

    public static int[] NSL(int[] arr) {
        int ans[] = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        int p = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
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

    public static int[] NSR(int[] arr) {
        int ans[] = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        int p = arr.length - 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                ans[p--] = arr.length;
            } else {
                ans[p--] = st.peek();
            }
            st.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 1, 5, 6, 2, 3 };
        // System.out.println(Arrays.toString(largestRectangleArea(arr)));
        System.out.println(largestRectangleArea(arr));
    }
}