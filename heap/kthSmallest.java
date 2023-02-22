import java.util.Comparator;
import java.util.PriorityQueue;

public class kthSmallest {
    public static int kthSmallest(int[] arr, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < arr.length; i++) {
            q.add(arr[i]);
        }
        int n = arr.length - k;
        while (n != 0) {

            q.remove();
            n--;

        }
        return q.peek();
    }

    public static int smallest(int[] arr, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < arr.length; i++) {
            q.add(arr[i]);
            if (q.size() > k) {
                q.remove();
            }
        }
        return q.peek();
    }

    public static void main(String[] args) {
        int arr[] = { 7, 10, 4, 20, 15 };
        System.out.println(smallest(arr, 4));
    }
}
