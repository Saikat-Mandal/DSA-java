import java.util.ArrayList;
import java.util.List;

public class combination {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(candidates, res, temp, 0, 0, target);
        return res;
    }

    public static void helper(int[] nums, List<List<Integer>> res, List<Integer> temp, int i, int cur, int t) {
        if (cur > t) {
            return;
        }
        if (i == nums.length) {
            if (cur == t) {
                res.add(new ArrayList<>(temp));
                return;
            }
        }

        // inclusion
        cur += nums[i];
        temp.add(nums[i]);
        helper(nums, res, temp, i, cur, t);
        cur -= nums[i];
        temp.remove(temp.size() - 1);

        // exclusion
        helper(nums, res, temp, i + 1, cur, t);

    }

    public static void main(String[] args) {
        int arr[] = { 2, 3, 6, 7 };
        System.out.println(combinationSum(null, 7));
    }
}
