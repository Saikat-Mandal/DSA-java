public class LLQ {
    static class Node {
        Node next;
        int data;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Queue {
        static Node head;
        static Node tail;

        Queue() {
            head = null;
            tail = null;
        }

        public static boolean isEmpty() {
            return head == null && tail == null;
        }

        public static void add(int data) {
            Node n = new Node(data);
            if (isEmpty()) {
                head = tail = n;
                return;
            }
            tail.next = n;
            tail = n;
        }

        public static void remove() {
            if (isEmpty()) {
                return;
            }
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
            }

        }

        public static void peek() {
            if (isEmpty()) {
                System.out.println("np");
                return;
            }
            System.out.println(head.data);
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        for (int i = 1; i <= 5; i++) {
            q.add(i);
        }
        while (!q.isEmpty()) {
            q.peek();
            q.remove();
        }
        q.peek();
    }
}