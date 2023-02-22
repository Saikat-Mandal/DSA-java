import java.util.ArrayList;
import java.util.PriorityQueue;

public class kSortedElements {
    public static ArrayList<Integer> nearlySorted(int arr[], int k) {
        ArrayList<Integer> l = new ArrayList<>();
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            q.add(arr[i]);
            if (q.size() > k) {
                l.add(q.remove());
            }
        }
        while (!q.isEmpty()) {
            l.add(q.remove());
        }
        return l;
    }

    public static void main(String[] args) {
        int arr[] = { 3, 1, 4, 2, 5 };
        System.out.println(nearlySorted(arr, 2));
    }
}