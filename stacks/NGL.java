import java.util.Stack;
import java.util.Arrays;

public class NGL {
    public static int[] ngr(int[] arr) {
        int[] ans = new int[arr.length];
        int p = 0;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                ans[p++] = -1;
            } else {
                ans[p++] = st.peek();

            }
            st.push(arr[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 3, 2, 4 };
        System.out.println(Arrays.toString(ngr(arr)));
    }
}
