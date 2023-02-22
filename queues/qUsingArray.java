public class qUsingArray {

    static class Queue {
        static int[] arr;
        static int size;
        static int rear;

        Queue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
        }

        public static boolean isEmpty() {
            return rear == -1;
        }

        public static void add(int data) {
            if (rear == size - 1) {
                System.out.println("q is full");
                return;
            }
            arr[++rear] = data;

        }

        public static void remove() {
            if (rear == -1) {
                System.out.println("nothing to remove");
                return;
            }
            for (int i = 0; i < size - 1; i++) {
                arr[i] = arr[i + 1];
            }
            rear--;
        }

        public static void peek() {

            if (isEmpty()) {
                System.out.println("nothing to peek");
                return;
            }
            System.out.println(arr[0]);
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue(5);
        for (int i = 1; i <= 5; i++) {
            q.add(i);
        }
        while (!q.isEmpty()) {
            q.peek();
            q.remove();
        }
        // q.peek();
    }
}