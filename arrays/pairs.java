public class pairs {
    public static void Pairs(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int cur = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                System.out.print(cur + "," + arr[j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] arr = { 2, 5, 3, 8, 9 };
        Pairs(arr);

    }
}
