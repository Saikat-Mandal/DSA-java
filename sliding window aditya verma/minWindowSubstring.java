import java.util.HashMap;

public class minWindowSubstring {
    public static String substring(String s, String t) {
        if (s.length() == 0 || t.length() == 0)
            return "";
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }
        int i = 0, j = 0, ans = Integer.MAX_VALUE;
        int count = map.size();
        String res = "";
        while (j < s.length()) {
            char ch = s.charAt(j);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) == 0) {
                    count--;
                }
            }

            if (count > 0) {
                j++;
            } else if (count == 0) {
                while (count == 0) {
                    if ((j - i + 1) < ans) {
                        ans = (j - i + 1);
                        res = s.substring(i, j + 1);
                    }

                    char now = s.charAt(i);
                    if (map.containsKey(now)) {
                        map.put(now, map.get(now) + 1);
                        if (map.get(now) == 1) {
                            count++;
                        }
                    }
                    i++;

                }
                j++;

            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(substring("ADOBECODEBANC", "ABC"));
    }
}
