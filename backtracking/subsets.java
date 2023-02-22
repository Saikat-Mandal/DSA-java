import java.util.ArrayList;
import java.util.List;

public class subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> l = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(l, nums, temp, 0);
        return l;
    }

    public static void helper(List<List<Integer>> l, int[] nums, List<Integer> temp, int i) {
        if (i == nums.length) {
            l.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[i]);
        helper(l, nums, temp, i + 1);
        temp.remove(temp.size() - 1);
        helper(l, nums, temp, i + 1);
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        System.out.println(subsets(nums));
    }
}
