import java.util.Arrays;

public class heapSort {

    public static void heapify(int i, int n, int[] arr) {
        int max = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[max]) {
            max = left;
        }
        if (right < n && arr[right] > arr[max]) {
            max = right;
        }
        if (max != i) {
            int temp = arr[max];
            arr[max] = arr[i];
            arr[i] = temp;
            heapify(max, n, arr);
        }
    }

    public static void ascSort(int[] arr) {

        // step 1 - create a max heap
        for (int i = arr.length / 2; i >= 0; i--) {
            heapify(i, arr.length, arr);
        }
        // step 2 - swap largest element with the last then call heapify for 0th index
        for (int i = arr.length - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(0, i, arr);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 4, 3, 5 };
        System.out.println(Arrays.toString(arr));
        ascSort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
