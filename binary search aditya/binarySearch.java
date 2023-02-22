public class binarySearch {

    // normal bs

    // public static int bs(int arr[], int target) {
    // int s = 0;
    // int e = arr.length - 1;
    // while (s <= e) {
    // int mid = s + (e - s) / 2;
    // if (arr[mid] == target)
    // return mid;
    // else if (arr[mid] < target) {
    // s = mid + 1;
    // } else {
    // e = mid - 1;
    // }
    // }
    // return -1;
    // }

    // reverse order bs
    public static int bs(int arr[], int target) {
        int s = 0;
        int e = arr.length - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (arr[mid] == target)
                return mid;
            else if (arr[mid] >= target) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = { 3, 15, 34, 77, 97 };
        int arr2[] = { 97, 77, 34, 15, 3 };
        System.out.println(bs(arr2, 97));
    }
}
