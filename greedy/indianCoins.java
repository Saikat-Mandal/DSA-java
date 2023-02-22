import java.util.Arrays;

public class indianCoins {
    public static void coins(int[] notes, int fare) {
        Arrays.sort(notes);
        int min = 0;

        for (int i = notes.length - 1; i >= 0; i--) {
            if (notes[i] <= fare) {
                while (notes[i] <= fare) {
                    min++;
                    fare -= notes[i];
                }
            }
        }

        System.out.println(min);
    }

    public static void main(String[] args) {
        int[] notes = { 1, 2, 5, 10, 20, 50, 100, 500, 2000 };
        coins(notes, 590);
    }
}
