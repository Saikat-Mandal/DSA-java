public class searchInNearlySorted {
    public static int sorted(int arr[], int target) {
        int s = 0;
        int e = arr.length - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (arr[mid] == target)
                return mid;
            else if (mid > s && arr[mid - 1] == target) {
                return mid - 1;
            } else if (mid < e && arr[mid + 1] == target) {
                return mid + 1;
            } else if (arr[mid] >= target) {
                e = mid - 2;
            } else {
                s = mid + 2;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int nums[] = { 5, 10, 30, 20, 40 };
        System.out.println(sorted(nums, 30));
    }
}
