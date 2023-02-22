public class customStackLinkedList {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Stack {
        static Node head;

        public static boolean isEmpty() {
            return head == null;
        }

        public static void push(int data) {
            Node n = new Node(data);
            if (isEmpty()) {
                head = n;
                return;
            }
            n.next = head;
            head = n;
        }

        public static void pop() {
            if (isEmpty()) {
                System.out.println("nothing to pop");
                return;
            }
            head = head.next;
        }

        public static void peek() {
            if (isEmpty()) {
                System.out.println("nothing to peek");
                return;
            }
            System.out.println(head.data);
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.pop();

        s.peek();
    }
}
