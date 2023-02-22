import java.util.HashMap;

public class maxSumSubarrayK {
    public static int lenOfLongSubarr(int nums[], int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        map.put(0, 1);
        int j = 0;
        int sum = 0;
        while (j < nums.length) {
            sum += nums[j];
            if (map.containsKey(sum - k)) {
                ans += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);

            j++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3 };
        System.out.println(lenOfLongSubarr(nums, 3));
    }
}
