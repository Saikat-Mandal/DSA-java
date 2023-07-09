import java.util.Arrays;

public class insertionSort {
    public static void sort(int arr[], int n) {
        for (int i = 1; i < n; i++) {
            int x = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > x) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = x;
        }
    }

    public static void main(String[] args) {
        int arr[] = { 12, 11, 13, 5, 6 };
        sort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
