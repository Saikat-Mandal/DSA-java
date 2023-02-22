import java.util.PriorityQueue;

public class nRopes {
    public static int minCost(int[] arr) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i : arr) {
            q.add(i);
        }
        int cost = 0;
        while (q.size() > 1) {
            int m1 = q.remove();
            int m2 = q.remove();
            cost += m1 + m2;
            q.add(m1 + m2);
        }
        return cost;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 3, 2, 6 };
        System.out.println(minCost(arr));
    }
}
