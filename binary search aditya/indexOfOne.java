public class indexOfOne {
    public static int one(int nums[]) {
        int l = 0;
        int h = 1;
        while (nums[h] == 0) {
            l = h;
            h = 2 * h;
        }
        return search(nums, l, h);

    }

    public static int search(int[] nums, int l, int h) {
        int ans = -1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] == 1) {
                ans = mid;
                h = mid - 1;
            } else if (nums[mid] < 1) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int nums[] = { 0, 0, 1, 1, 1, 1 };
        System.out.println(one(nums));
    }
}
