public class peekElement {
    public static int peek(int[] arr) {
        if (arr.length == 1)
            return 0;

        int s = 0;

        int e = arr.length - 1;
        while (s <= e) {

            int mid = s + (e - s) / 2;
            if (mid > 0 && mid < arr.length - 1) {
                if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1])
                    return arr[mid];
                else if (arr[mid - 1] > arr[mid]) {
                    e = mid - 1;

                } else {
                    s = mid + 1;
                }
            } else if (mid == 0) {
                if (arr[0] > arr[1])
                    return 0;
                else
                    return 1;
            } else {

                if (arr[arr.length - 1] > arr[arr.length - 2])
                    return arr[arr.length - 1];

                else {
                    return arr[arr.length - 2];
                }

            }

        }

        return 0;
    }

    public static void main(String[] args) {
        int arr[] = { 3, 2, 1 };
        System.out.println(peek(arr));
    }
}
