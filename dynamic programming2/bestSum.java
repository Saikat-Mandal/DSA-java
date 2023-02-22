import java.util.ArrayList;
import java.util.List;

public class bestSum {
    public static List<Integer> sum(List<Integer> nums, int targetSum) {
        if (targetSum == 0)
            return new ArrayList<>();
        if (targetSum < 0)
            return null;
        List<Integer> shortestCombination = null;
        for (int num : nums) {
            int rem = targetSum - num;
            List<Integer> remResult = sum(nums, rem);
            if (remResult != null) {
                List<Integer> combination = new ArrayList<>(remResult);
                combination.add(num);
                if (combination == null || combination.size() < shortestCombination.size()) {
                    shortestCombination = remResult;
                }
            }
        }

        return shortestCombination;
    }

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(2);
        nums.add(3);
        nums.add(5);
        System.out.println(sum(nums, 8));
    }
}
