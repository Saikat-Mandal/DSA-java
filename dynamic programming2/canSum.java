import java.io.Console;
import java.util.HashMap;
import java.util.Map;

public class canSum {
    public static boolean cSum(int targetSum, int[] nums, Map<Integer, Boolean> memo) {

        if (memo.containsKey(targetSum)) {
            return memo.get(targetSum);
        }
        if (targetSum == 0) {
            return true;
        }
        if (targetSum < 0) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            int remainder = targetSum - nums[i];
            if (cSum(remainder, nums, memo) == true) {
                memo.put(targetSum, true);
                return memo.get(targetSum);
            }
        }
        memo.put(targetSum, false);
        return false;
    }

    public static void main(String[] args) {
        Map<Integer, Boolean> map = new HashMap<>();
        int nums[] = { 2, 3 };
        int nums2[] = { 5, 3, 4, 7 };
        int nums3[] = { 2, 4 };
        int nums4[] = { 2, 3, 5 };
        int nums5[] = { 7, 14 };
        System.out.println(cSum(7, nums, map));
        System.out.println(cSum(7, nums2, map));
        System.out.println(cSum(7, nums3, map));
        System.out.println(cSum(8, nums4, map));
        System.out.println(cSum(300, nums5, map));

    }
}
