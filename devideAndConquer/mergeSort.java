
public class mergeSort {
    public static void merge(int[] nums, int s, int e, int mid) {

        int temp[] = new int[e - s + 1];

        int i = s, j = mid + 1, k = 0;

        while (i <= mid && j <= e) {
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= e) {
            temp[k++] = nums[j++];
        }

        for (k = 0, i = s; k < temp.length; k++, i++) {
            nums[i] = temp[k];
        }
    }

    public static void sort(int[] nums, int s, int e) {
        if (s >= e) {
            return;
        }
        int mid = s + (e - s) / 2;
        sort(nums, s, mid);
        sort(nums, mid + 1, e);
        merge(nums, s, e, mid);
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