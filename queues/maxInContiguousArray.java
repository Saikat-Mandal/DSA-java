import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class maxInContiguousArray {
    public static int[] maxSum(int[] nums, int k) {
        int ans[] = new int[nums.length - k + 1];
        Deque<Integer> q = new ArrayDeque<>();
        int i = 0, j = 0, p = 0;
        while (j < nums.length) {
            while (q.size() > 0 && q.peekLast() <= nums[j]) {
                q.removeLast();
            }
            q.add(nums[j]);
            if ((j - i + 1) < k) {
                j++;
            } else if ((j - i + 1) == k) {
                ans[p++] = q.peek();
                if (nums[i] == q.peekFirst()) {
                    q.removeFirst();
                }
                i++;
                j++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 1, 4, 5, 2, 3, 6 };
        System.out.println(Arrays.toString(maxSum(nums, 3)));
    }
}
