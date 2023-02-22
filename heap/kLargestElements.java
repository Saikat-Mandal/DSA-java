import java.util.Arrays;
import java.util.PriorityQueue;

public class kLargestElements {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            q.add(nums[i]);
            if (q.size() > k) {
                q.remove();
            }
        }
        return q.peek();
    }

    public static int[] kLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            q.add(nums[i]);
            if (q.size() > k) {
                q.remove();
            }
        }
        int[] ans = new int[k];
        int p = ans.length - 1;
        while (!q.isEmpty()) {
            ans[p--] = q.remove();
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 2, 1, 5, 6, 4 };
        System.out.println(Arrays.toString(nums));
    }
}
