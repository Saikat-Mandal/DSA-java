import java.util.LinkedList;
import java.util.Queue;

public class reverseQ {
    // reverse code
    public static void reverse(Queue<Integer> q) {
        if (q.isEmpty()) {
            return;
        }
        int front = q.remove();
        reverse(q);
        q.add(front);
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q);
        reverse(q);
        System.out.println(q);
    }
}
