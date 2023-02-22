import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class howSum {

    public static List<Integer> howSum(int targetSum, List<Integer> nums, Map<Integer, List<Integer>> memo) {
        if (memo.containsKey(targetSum)) {
            return memo.get(targetSum);
        }
        if (targetSum == 0) {
            return new ArrayList<>();
        }
        if (targetSum < 0) {
            return null;
        }
        for (int num : nums) {
            int remainder = targetSum - num;
            List<Integer> remainderResult = howSum(remainder, nums, memo);
            if (remainderResult != null) {
                remainderResult.add(num);
                memo.put(targetSum, remainderResult);
                return memo.get(targetSum);
            }
        }
        memo.put(targetSum, null);
        return memo.get(targetSum);
    }

    public static void main(String[] args) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> l = new ArrayList<>();
        l.add(7);
        l.add(14);

        // System.out.println(howSum(7, l, map));
        // System.out.println(howSum(7, l, map));
        // System.out.println(howSum(7, l, map));
        // System.out.println(howSum(8, l, map));
        System.out.println(howSum(300, l, map));
    }
}
