import java.util.Arrays;

public class practice {

    // quickSort practice
    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int partition(int arr[], int l, int h) {
        int pivot = arr[h];

        int index = l - 1;

        for (int j = l; j < h; j++) {
            if (arr[j] < pivot) {
                index++;
                swap(arr, index, j);
            }

        }
        index++;

        swap(arr, h, index);
        return index;
    }

    public static void QuickSort(int arr[], int l, int h) {

        if (l < h) {
            int pivot = partition(arr, l, h);

            QuickSort(arr, l, pivot - 1);
            QuickSort(arr, pivot + 1, h);
        }

    }

    // mergeSort
    public static int[] merge(int arr1[], int arr2[]) {
        int res[] = new int[arr1.length + arr2.length];

        int i = 0, j = 0, k = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                res[k++] = arr1[i];
                i++;
            } else {
                res[k++] = arr2[j];
                j++;
            }
        }

        while (i < arr1.length) {
            res[k++] = arr1[i];
            i++;
        }
        while (j < arr2.length) {
            res[k++] = arr2[j];
            j++;
        }

        return res;
    }

    // merge single list
    public static int[] merge2(int arr[], int l, int h, int mid) {
        int res[] = new int[arr.length];
        int i = l, j = mid + 1, k = l;

        while (i <= mid && j <= h) {
            if (arr[i] < arr[j]) {
                res[k++] = arr[i++];
            } else {
                res[k++] = arr[j++];

            }
        }

        while (i <= mid) {

            res[k++] = arr[i++];
        }

        while (j <= h) {

            res[k++] = arr[j++];
        }

        return res;
    }

    public static void main(String[] args) {
        // int[] arr = { 10, 7, 8, 9, 1, 5 };
        // int[] arr = { 4, 2, 5 };
        // int N = arr.length;

        int arr2[] = { 1, 2, 3 };
        int arr1[] = { 4, 5, 6, 7, 8 };
        int arr[] = { 2, 5, 8, 12, 3, 6, 7, 10 };
        int mid = (0 + arr.length - 1) / 2;
        // Function call
        // QuickSort(arr, 0, N - 1);
        // System.out.println(Arrays.toString(arr));

        // System.out.println(Arrays.toString(merge(arr1, arr2)));
        System.out.println(Arrays.toString(merge2(arr, 0, arr.length - 1, mid)));

    }
}
