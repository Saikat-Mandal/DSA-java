class Main {
    // ceil

    public static int ceil(int[] arr, int target) {
        int s = 0, e = arr.length - 1;

        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (target == arr[mid]) {
                return mid;
            }

            else if (target > arr[mid]) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return s;
    }

    // floor

    public static int floor(int[] arr, int target) {
        int s = 0, e = arr.length - 1;

        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (target == arr[mid]) {
                return mid;
            }

            else if (target > arr[mid]) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return e;
    }

    // find in a infinite sorted array

    public static int infinite(int arr[], int target) {
        int s = 0, e = 1;

        while (target > arr[e]) {
            int ns = e + 1;
            e = e + (e - s + 1) * 2;
            s = ns;
        }

        return bs(arr, target, s, e);

    }

    public static int bs(int arr[], int target, int s, int e) {
        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (target == arr[mid]) {
                return mid;
            } else if (target > arr[mid]) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 3, 5, 9, 14, 16, 17, 18, 24, 55, 345, 100, 123, 200 };
        // System.out.println(ceil(arr, 15));

        System.out.println(infinite(arr, 17));

    }
}