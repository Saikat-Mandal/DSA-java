
public class arrays {
    public static void backtrack(int[] arr, int i, int val) {
        if (i == arr.length) {
            return;
        }
        arr[i] = val;
        backtrack(arr, i + 1, val + 1);
        arr[i] = arr[i] - 2;
    }

    public static void display(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[5];

        backtrack(arr, 0, 1);
        display(arr);
    }
}