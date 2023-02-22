public class compression {
    public static String compress(String s) {
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            Integer count = 1;
            while (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                count++;
                i++;
            }
            ans += s.charAt(i);
            if (count > 1) {
                ans += count.toString();
            }

        }

        return ans;

    }

    public static void main(String[] args) {
        System.out.println(compress("abbcc"));
    }
}
