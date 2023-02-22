public class quickSort {

    public static int partition(int[] nums, int s, int e) {
        int pivot = nums[e];
        int index = s - 1;

        for (int j = s; j < e; j++) {
            if (nums[j] <= pivot) {
                index++;
                int temp = nums[j];
                nums[j] = nums[index];
                nums[index] = temp;
            }
        }
        index++;
        int temp = pivot;
        nums[e] = nums[index];
        nums[index] = temp;

        return index;
    }

    public static void sort(int[] nums, int s, int e) {
        if (s >= e) {
            return;

        }
        int pivot = partition(nums, s, e);

        sort(nums, s, pivot - 1);
        sort(nums, pivot + 1, e);
    }

    public static void display(int[] nums) {
        for (int i : nums) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = { 6, 3, 9, 5, 2, 8 };
        display(nums);
        sort(nums, 0, nums.length - 1);
        display(nums);

    }
}
