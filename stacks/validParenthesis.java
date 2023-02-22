import java.util.Stack;

public class validParenthesis {
    public boolean isValid(String s) {
        boolean ans = true;
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                st.push(ch);
            } else if (ch == ')') {
                if (!st.isEmpty() && st.peek() == '(') {
                    st.pop();
                } else {
                    ans = false;
                    break;
                }
            } else if (ch == ']') {
                if (!st.isEmpty() && st.peek() == '[') {
                    st.pop();
                } else {
                    ans = false;
                    break;
                }
            } else if (ch == '}') {
                if (!st.isEmpty() && st.peek() == '{') {
                    st.pop();
                } else {
                    ans = false;
                    break;
                }
            }
        }
        if (!st.isEmpty()) {
            ans = false;
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
