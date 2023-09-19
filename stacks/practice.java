import java.util.Arrays;
import java.util.Stack;

public class practice {

    // nearest greater to right
    public static int[] NGR(int[] arr) {
        int res[] = new int[arr.length];
        int p = arr.length - 1;
        Stack<Integer> st = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                res[p--] = -1;
            } else {
                res[p--] = st.peek();

            }
            st.push(arr[i]);
        }
        return res;
    }

    // nearest greater to left
    public static int[] NGL(int[] arr) {
        int res[] = new int[arr.length];
        int p = 0;
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty() && st.peek() >= arr[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                res[p++] = -1;
            } else {
                res[p++] = st.peek();

            }
            st.push(arr[i]);
        }
        return res;
    }

    // nearest smaller right
    public static int[] NSR(int[] arr) {
        int res[] = new int[arr.length];
        int p = arr.length - 1;
        Stack<Integer> st = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() >= arr[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                res[p--] = -1;
            } else {
                res[p--] = st.peek();
            }
            st.push(arr[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 3, 2, 4 };

        System.out.println(Arrays.toString(NGR(arr)));
    }
}
