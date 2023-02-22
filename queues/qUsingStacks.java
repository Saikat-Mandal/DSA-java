import java.util.Stack;

public class qUsingStacks {
    static class Queue {
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public static boolean isEmpty() {
            return s1.isEmpty();
        }

        public static void add(int data) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            s1.push(data);
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }

        public static void remove() {
            if (s1.isEmpty()) {
                System.out.println("nothing to pop");
                return;
            }
            s1.pop();
        }

        public static void peek() {
            if (s1.isEmpty()) {
                System.out.println("nothing to peek");
                return;
            }
            System.out.println(s1.peek());
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        for (int i = 1; i < 5; i++) {
            q.add(i);
        }
        while (!q.isEmpty()) {
            q.peek();
            q.remove();
        }
    }
}