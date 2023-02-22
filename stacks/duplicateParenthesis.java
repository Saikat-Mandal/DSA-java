import java.util.Stack;

public class duplicateParenthesis {
    public static boolean isValid(String s) {

        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == ')') {

                int count = 0;
                while (st.peek() != '(') {
                    st.pop();
                    count++;
                }
                if (count < 1) {
                    return true;
                } else {
                    st.pop();
                }
            } else {
                st.push(ch);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isValid("((a+b)+(c+d)) "));
    }
}
