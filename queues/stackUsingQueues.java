import java.util.LinkedList;
import java.util.Queue;

public class stackUsingQueues {
    static class Stack {
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();

        public static boolean isEmpty() {
            return q1.isEmpty() && q2.isEmpty();
        }

        public static void add(int data) {
            q1.add(data);
        }

        public static void remove() {
            if (isEmpty()) {
                System.out.println("nop");
                return;
            }
            while (!q1.isEmpty()) {
                q2.add(q1.remove());
            }
            System.out.println(q1.remove());
            while (!q2.isEmpty()) {
                q1.add(q2.remove());
            }
        }

        public static void peek() {
            if (isEmpty()) {
                System.out.println("nop");
                return;
            }
            while (!q1.isEmpty()) {
                q2.add(q1.remove());
            }
            System.out.println(q1.remove());
            while (!q2.isEmpty()) {
                q1.add(q2.remove());
            }
        }

    }

    public static void main(String[] args) {

    }
}
