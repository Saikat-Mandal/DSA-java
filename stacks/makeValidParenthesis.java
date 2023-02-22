import java.util.Stack;

public class makeValidParenthesis {

    // q1
    public static int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ')') {
                if (!st.isEmpty() && st.peek() == '(') {
                    st.pop();
                } else {
                    st.push(ch);
                }
            } else {
                st.push(ch);

            }
        }
        return st.size();

    }

    // q2
    public static int minInsertions(String s) {
        Stack<Character> st = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (!st.isEmpty() && ch == ')') {
                if (st.peek() == '(') {
                    i++;
                    if (ch == ')') {
                        st.pop();
                    }
                } else {
                    st.push(ch);
                }

            } else {
                st.push(ch);
            }
            i++;
        }
        return st.size();
    }

    public static void main(String[] args) {
        String s = "))())(";
        System.out.println(minInsertions(s));
    }
}
