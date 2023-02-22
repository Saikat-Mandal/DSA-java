public class maxProductSubarray {
    public static int maxProduct(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int ans = 0;
        int p = 1;
        for (int i = 0; i < nums.length; i++) {
            p *= nums[i];
            ans = Math.max(ans, p);
            if (p < 0) {
                p = nums[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { -2 };
        System.out.println(maxProduct(nums));
    }
}
