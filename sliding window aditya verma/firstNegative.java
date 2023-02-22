import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class firstNegative {
    public static int[] negative(int[] nums, int k) {
        int i = 0, j = 0;
        int ans[] = new int[nums.length - k + 1];
        int p = 0;
        Queue<Integer> q = new LinkedList<>();
        while (j < nums.length) {
            if (nums[j] < 0) {
                q.add(nums[j]);
            }
            if ((j - i + 1) < k) {
                j++;
            } else if ((j - i + 1 == k)) {
                if (q.isEmpty()) {
                    ans[p++] = 0;
                } else {
                    ans[p++] = q.peek();
                    if (nums[i] == q.peek()) {
                        q.poll();
                    }
                }
                i++;
                j++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int nums[] = { 12, -1, -7, 8, -15, 30, 16, 28 };
        System.out.println(Arrays.toString(negative(nums, 3)));
    }
}
