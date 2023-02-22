public class searchInRotated {
    public static int rotation(int nums[], int target) {
        int min = findMin(nums);
        int s1 = helper(nums, target, 0, min - 1);
        int s2 = helper(nums, target, min, nums.length - 1);
        if (s1 == -1)
            return s2;
        return s1;
    }

    public static int findMin(int nums[]) {
        int s = 0;
        int e = nums.length - 1;
        while (s <= e) {
            if (nums[s] < nums[e])
                return s;
            int mid = s + (e - s) / 2;
            int p = (mid + nums.length - 1) % nums.length;
            int n = (mid + 1) % nums.length;

            if (nums[mid] <= nums[p] && nums[mid] <= nums[n])
                return mid;
            else if (nums[mid] >= nums[s]) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }

        }
        return 0;
    }

    public static int helper(int nums[], int target, int s, int e) {

        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int nums[] = { 4, 5, 6, 7, 0, 1, 2 };
        System.out.println(rotation(nums, 4));
    }
}
