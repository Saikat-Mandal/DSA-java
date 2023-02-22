public class AllIndices {
    public static void indices(int[] nums, int key) {
        helper(nums, 0, key);
    }

    public static void helper(int[] nums, int i, int key) {
        if (i == nums.length) {
            return;
        }
        if (nums[i] == key) {
            System.out.println(i);
        }
        helper(nums, i + 1, key);

    }

    public static void main(String[] args) {
        int[] nums = { 3, 2, 4, 5, 6, 2, 7, 2, 2 };
        indices(nums, 2);
    }
}
