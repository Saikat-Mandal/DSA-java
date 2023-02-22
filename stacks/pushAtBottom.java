import java.util.Stack;

public class pushAtBottom {
    public static void bottom(Stack<Integer> st, int data) {
        if (st.isEmpty()) {
            st.push(data);
            return;
        }
        int num = st.pop();
        bottom(st, data);
        st.push(num);
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        bottom(st, 4);

        System.out.println(st);
    }
}
