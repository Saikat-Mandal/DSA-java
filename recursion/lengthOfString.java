public class lengthOfString {
    static int count = 0;

    public static int los(String s, int i) {
        if (i == s.length()) {
            return 0;
        }
        count++;
        los(s, i + 1);
        return count;
    }

    public static void main(String[] args) {
        System.out.println(los("", 0));
    }
}
