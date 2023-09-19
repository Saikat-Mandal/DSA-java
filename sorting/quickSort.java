import java.util.Arrays;

public class quickSort {

    public static void swap(int i, int j, int arr[]) {
        int temp = arr[i];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static int partition(int arr[], int l, int h) {
        int i = l, j = h;
        int pivot = arr[l];

        do {
            do {
                i++;
            } while (arr[i] <= pivot);
            do {
                j--;
            } while (arr[i] > pivot);

            if (i < j) {
                swap(i, j, arr);
            }
        } while (i < j);

        swap(pivot, j, arr);

        return j;
    }

    public static void Quicksort(int arr[], int l, int h) {
        if (l < h) {

            int pivot = partition(arr, l, h);
            Quicksort(arr, l, pivot - 1);
            Quicksort(arr, pivot + 1, h);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 10, 7, 8, 9, 1, 5 };
        Quicksort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
