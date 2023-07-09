public class palindrome {

    // public static boolean pal(String s) {
    // for (int i = 0; i < s.length() / 2; i++) {
    // if (s.charAt(i) == s.charAt(s.length() - i - 1)) {
    // continue;
    // } else {
    // return false;
    // }
    // }

    // return true;
    // }

    public static boolean pal(String s) {
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(pal("malayalam"));
    }
}