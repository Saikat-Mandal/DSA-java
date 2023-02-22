public class maxSubarrayK {
    public static int sum(int[] nums, int k) {
        int i = 0, j = 0;
        int sum = 0;
        int ans = 0;
        while (j < nums.length) {
            sum += nums[j];
            if ((j - i + 1) < k) {
                j++;
            } else if ((j - i + 1) == k) {
                ans = Math.max(ans, sum);
                sum -= nums[i];
                i++;
                j++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int nums[] = { 100, 200, 300, 400 };
        System.out.println(sum(nums, 2));
    }
}
