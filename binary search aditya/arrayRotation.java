public class arrayRotation {
    public static int rotation(int nums[]) {
        int s = 0;
        int e = nums.length - 1;
        while (s <= e) {
            if (nums[s] < nums[e])
                return nums[s];
            int mid = s + (e - s) / 2;
            int prev = (mid + nums.length - 1) % nums.length;
            int next = (mid + 1) % nums.length;
            if (nums[mid] <= nums[prev] && nums[mid] <= next) {
                return mid;
            }
            // checking which half is sorted
            else if (nums[mid] >= nums[s]) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return nums[0];
    }

    public static void main(String[] args) {
        int nums[] = { 4, 5, 6, 7, 0, 1, 2 };
        System.out.println(rotation(nums));
    }
}
