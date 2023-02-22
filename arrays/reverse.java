import java.util.Arrays;

public class reverse {
    public static void reverseArr(int arr[]) {
        int j = arr.length - 1;
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 2, 5, 3, 8, 9 };
        reverseArr(arr);
        System.out.println(Arrays.toString(arr));
    }
}