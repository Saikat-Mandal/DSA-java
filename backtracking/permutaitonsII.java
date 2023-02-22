import java.util.ArrayList;
import java.util.List;

public class permutaitonsII {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> l = new ArrayList<>();
        helper(nums, l, new ArrayList<>(), new boolean[nums.length]);
        return l;
    }

    public static void helper(int nums[], List<List<Integer>> l, List<Integer> temp, boolean[] used) {
        if (temp.size() == nums.length && !l.contains(temp)) {
            l.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i])
                continue;
            used[i] = true;
            temp.add(nums[i]);
            helper(nums, l, temp, used);
            used[i] = false;
            temp.remove(temp.size() - 1);

        }
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3 };
        System.out.println(permute(nums));
    }
}
