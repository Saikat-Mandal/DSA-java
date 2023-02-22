public class ciel {
    public static int floorr(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;
        int ans = -1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (nums[mid] == target)
                return mid;
            else if (target > nums[mid]) {
                s = mid + 1;
            } else {
                ans = mid;
                e = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 8, 10, 10, 12, 19 };
        System.out.println(floorr(nums, 5));
    }
}
