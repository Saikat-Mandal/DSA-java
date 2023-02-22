import java.util.ArrayList;

public class heaps {
    static class heap {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) {
            arr.add(data);
            int x = arr.size() - 1;
            int parent = (x - 1) / 2;

            while (arr.get(x) < arr.get(parent)) {
                int temp = arr.get(x);
                arr.set(x, arr.get(parent));
                arr.set(parent, temp);
                x = parent;
                parent = (x - 1) / 2;
            }
        }

        public void display() {
            System.out.println(arr);
        }

        public void peek() {
            System.out.println(arr.get(0));
        }

        public void heapify(int i) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            int min = i;

            if (left < arr.size() && arr.get(min) > arr.get(left)) {
                min = left;
            }
            if (right < arr.size() && arr.get(min) > arr.get(right)) {
                min = right;
            }
            if (min != i) {
                int temp = arr.get(i);
                arr.set(i, arr.get(min));
                arr.set(min, temp);

                heapify(min);
            }
        }

        public void delete() {

            // step 1
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size() - 1));
            arr.set(arr.size() - 1, temp);

            // step 2
            arr.remove(arr.size() - 1);

            // step 3
            heapify(0);
        }

        public boolean isEmpty() {
            return arr.size() == 0;
        }

    }

    public static void main(String[] args) {
        heap h = new heap();
        h.add(2);
        h.add(3);
        h.add(4);
        h.add(5);
        h.add(10);
        h.display();
        h.add(1);
        h.display();
        h.delete();
        h.display();

    }
}
