import java.util.ArrayDeque;
import java.util.Arrays;

import java.util.Deque;

public class maxInWindow {
    public static int[] maxSlidingWindow(int nums[], int k) {
        int i = 0, j = 0, p = 0;
        int ans[] = new int[nums.length - k + 1];
        Deque<Integer> q = new ArrayDeque<>();

        while (j < nums.length) {
            while (q.size() > 0 && q.peekLast() < nums[j]) {
                q.removeLast();
            }
            q.add(nums[j]);
            if ((j - i + 1) < k)
                j++;
            else if ((j - i + 1) == k) {
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
        int nums[] = { 1, 3, -1, -3, 5, 3, 6, 7 };
        System.out.println(Arrays.toString(maxSlidingWindow(nums, 3)));
    }
}
