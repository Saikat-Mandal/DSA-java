public class practice {
    public int[] productExceptSelf(int[] nums) {
        int res[] = new int[nums.length];
        int p = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = 1;
            for (int j = 0; j < i; i++) {
                temp *= nums[j];
            }
            for (int j = i + 1; j < nums.length; i++) {
                temp *= nums[j];
            }
            res[p++] = temp;
        }
        return res;
    }

    public static void main(String[] args) {
        int nums[] = new int[];
    }
}
