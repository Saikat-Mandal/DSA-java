import java.util.HashMap;

public class noRepeatingChar {
    public static int SubstringK(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0;
        int ans = 0;
        while (j < s.length()) {
            char ch = s.charAt(j);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
            if ((map.size() > (j - i + 1))) {
                j++;
            } else if (map.size() == (j - i + 1)) {
                ans = Math.max(ans, (j - i + 1));
                j++;
            } else if (map.size() < (j - i + 1)) {
                while (map.size() < (j - i + 1)) {
                    char now = s.charAt(i);

                    map.put(now, map.get(now) - 1);

                    if (map.get(now) == 0) {
                        map.remove(now);
                    }
                    i++;
                }
                j++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(SubstringK("pwwkew"));
    }
}
