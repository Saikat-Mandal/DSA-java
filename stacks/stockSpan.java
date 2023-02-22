import java.util.Arrays;
import java.util.Stack;

public class stockSpan {
    public static int[] stocks(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];
        int p = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                ans[p++] = -1;
            } else {
                ans[p++] = st.peek();
            }
            st.push(i);
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < ans.length; i++) {
            res[i] = i - ans[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[] = { 100, 80, 60, 70, 60, 75, 85 };
        System.out.println(Arrays.toString(stocks(arr)));
    }
}
