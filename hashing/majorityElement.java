import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class majorityElement {
    public static int element(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // if (map.containsKey(nums[i])) {
            // map.put(nums[i], map.get(nums[i]) + 1);
            // } else {
            // map.put(nums[i], 1);
            // }

            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int max = 0;
        for (int i : map.keySet()) {
            if (map.get(i) > nums.length / 2) {
                max = i;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int nums[] = { 3, 2, 3 };
        System.out.println(element(nums));
    }
}
