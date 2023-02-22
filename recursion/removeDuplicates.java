
public class removeDuplicates {
    public static String rDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        boolean[] map = new boolean[26];
        return helper(s, sb, 0, map);
    }

    public static String helper(String s, StringBuilder sb, int i, boolean[] map) {
        if (i == s.length())
            return sb.toString();
        if (map[s.charAt(i) - 'a']) {
            return helper(s, sb, i + 1, map);
        }
        map[s.charAt(i) - 'a'] = true;
        return helper(s, sb.append(s.charAt(i)), i + 1, map);
    }

    public static void main(String[] args) {
        String s = "appnnacollege";
        System.out.println(rDuplicates(s));
    }
}
