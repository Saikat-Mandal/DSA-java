import java.util.ArrayList;

public class customStack {

    static class Stack {
        static ArrayList<Integer> l = new ArrayList<>();

        public static boolean isEmpty() {
            return l.size() == 0;
        }

        public static void push(int data) {
            l.add(data);
        }

        public static void pop() {
            if (l.isEmpty()) {

                System.out.println("nothing to pop");
                return;
            }
            l.remove(l.size() - 1);
        }

        public static void peek() {
            if (l.isEmpty()) {

                System.out.println("nothing to peek");
                return;
            }
            System.out.println(l.get(l.size() - 1));
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(6);
        s.push(7);
        s.push(4);

        while (!s.isEmpty()) {
            s.peek();
            s.pop();
        }

        s.peek();
    }
}