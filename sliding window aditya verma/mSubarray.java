
public class mSubarray {

    // brute force subprefixay sum

    public static int sum(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int curSum = 0;
                for (int k = i; k <= j; k++) {
                    curSum += nums[k];
                }
                sum = Math.max(curSum, sum);
            }
        }
        return sum;
    }

    // prefix sum
    public static int prefixSum(int[] nums) {

        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = nums[i] + prefix[i - 1];
        }

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int curSum = 0;
            for (int j = i; j < nums.length; j++) {
                curSum = i > 0 ? prefix[j] - prefix[i - 1] : prefix[j];
            }
            sum = Math.max(sum, curSum);
        }
        return sum;
    }

    // kadanes algorithm
    public static int kadanes(int[] nums) {
        int sum = 0;
        int curSum = 0;
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            sum = Math.max(sum, curSum);
            if (curSum < 0) {
                curSum = 0;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int nums[] = { 5, 3, 2, 4 };
        System.out.println(prefixSum(nums));
    }
}
