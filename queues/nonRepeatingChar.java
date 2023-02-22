import java.util.LinkedList;
import java.util.Queue;

public class nonRepeatingChar {
    public static void nChar(String s) {
        Queue<Character> q = new LinkedList<>();
        int map[] = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            q.add(ch);
            map[ch - 'a']++;

            while (!q.isEmpty() && map[q.peek() - 'a'] > 1) {
                q.remove();
            }
            if (q.isEmpty()) {
                System.out.println(-1);
            } else {
                System.out.println(q.peek());
            }
        }
    }

    public static void main(String[] args) {
        nChar("aabccxb");
    }
}
