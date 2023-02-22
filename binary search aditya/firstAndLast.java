import java.util.Arrays;

public class firstAndLast {
    public static int[] search(int nums[], int target) {
        int ans[] = new int[2];
        ans[0] = helper(nums, target, true);
        ans[1] = helper(nums, target, false);

        return ans;
    }

    public static int helper(int nums[], int target, boolean con) {
        int s = 0;
        int e = nums.length - 1;
        int ans = -1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (nums[mid] == target) {
                ans = mid;
                if (con) {
                    e = mid - 1;
                } else {
                    s = mid + 1;
                }
            } else if (nums[mid] >= target) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int nums[] = { 2, 4, 10, 10, 10, 18, 20 };
        System.out.println(Arrays.toString(search(nums, 10)));
    }
}
