import java.util.Stack;

public class reverseAstring {
    public static String reverse(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            st.push(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder("");
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverse("abc"));
    }
}
