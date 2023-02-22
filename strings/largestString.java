public class largestString {
    public static String largest(String fruits[]) {
        String ans = "";
        for (int i = 0; i < fruits.length - 1; i++) {
            if (fruits[i].compareToIgnoreCase(fruits[i + 1]) > 0) {
                ans = fruits[i];
            } else {
                continue;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String fruits[] = { "apple", "mango", "banana" };
        System.out.println(largest(fruits));
    }
}
