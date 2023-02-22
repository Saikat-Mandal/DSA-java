public class cirCularQ {
    static class CircularQueue {
        static int[] arr;
        static int size;
        static int rear;
        static int front;

        CircularQueue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
            front = -1;
        }

        public static boolean isEmpty() {
            return rear == -1 && front == -1;
        }

        public static boolean isFull() {
            return (rear + 1) % size == front;
        }

        public static void add(int data) {
            if (isFull()) {
                System.out.println("q is full");
                return;
            }
            if (front == -1) {
                front = 0;
            }
            rear = (rear + 1) % size;
            arr[rear] = data;

        }

        public static void remove() {
            if (isEmpty()) {
                System.out.println("nothing to remove");
                return;
            }

            if (rear == front) {
                rear = front = -1;

            } else {
                front = (front + 1) % size;

            }

        }

        public static void peek() {

            if (isEmpty()) {
                System.out.println("nothing to peek");
                return;
            }
            System.out.println(arr[front]);
        }
    }

    public static void main(String[] args) {
        CircularQueue q = new CircularQueue(5);
        for (int i = 1; i <= 5; i++) {
            q.add(i);
        }
        while (!q.isEmpty()) {
            q.peek();
            q.remove();
        }
    }
}
