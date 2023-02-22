import java.util.LinkedList;
import java.util.Queue;

public class interLeaves {
    static void interLeaveQueue(Queue<Integer> q) {

        int mid = q.size();

        Queue<Integer> f = new LinkedList<>();
        Queue<Integer> s = new LinkedList<>();
        Queue<Integer> finalq = new LinkedList<>();

        for (int i = 0; i < mid / 2; i++) {
            f.add(q.remove());
        }

        while (!q.isEmpty() && !f.isEmpty()) {
            finalq.add(f.remove());
            finalq.add(q.remove());
        }

        while (!finalq.isEmpty()) {
            System.out.println(finalq.remove());
        }

    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        interLeaveQueue(q);
    }
}
