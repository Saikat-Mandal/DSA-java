import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class kClosestNumber {
    public static List<Integer> solution(int nums[], int k, int x) {
        PriorityQueue<Pair> q = new PriorityQueue<Pair>((a, b) -> {

            if (a.d == b.d) {
                return a.x - b.x;
            }

            else {
                return b.d - a.d;
            }

        });
        for (int i = 0; i < nums.length; i++) {
            int d = Math.abs(x - nums[i]);

            if (d != 0) {

                q.add(new Pair(d, nums[i]));

            }
            if (q.size() > k) {
                q.remove();
            }
        }

        List<Integer> l = new ArrayList<>();
        while (!q.isEmpty()) {
            Pair p = q.poll();
            l.add(p.x);

        }
        Collections.sort(l);
        return l;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3, 4, 5 };
        System.out.println(solution(nums, 4, 3));
    }
}

class Pair {
    int d;
    int x;

    Pair(int d, int x) {
        this.d = d;
        this.x = x;
    }
}
