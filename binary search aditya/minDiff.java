public class minDiff {
    public static int absolute(int nums[], int key) {
        int s = 0;
        int e = nums.length - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (nums[mid] == key)
                return nums[mid];
            else if (key > nums[mid]) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        int v1 = nums[s] - key;
        int v2 = nums[e] - key;
        return nums[s] = v1 < v2 ? nums[s] : nums[e];
    }

    public static void main(String[] args) {
        int nums[] = { 1, 3, 8, 10, 12, 15 };
        System.out.println(absolute(nums, 12));
    }
}
