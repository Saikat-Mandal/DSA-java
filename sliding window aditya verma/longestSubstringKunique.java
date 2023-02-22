import java.util.HashMap;

public class longestSubstringKunique {
    public static int SubstringK(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();

        int i = 0, j = 0, ans = -1;

        while (j < s.length()) {
            char ch = s.charAt(j);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
            if (map.size() < k) {
                j++;
            } else if (map.size() == k) {
                ans = Math.max(ans, (j - i + 1));
                j++;
            } else if (map.size() > k && i < j) {
                while (map.size() > k) {
                    char now = s.charAt(i);
                    if (map.get(now) > 0) {
                        map.put(now, map.get(now) - 1);
                    }
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
        String s = "aabacbebebe";
        System.out.println(SubstringK(s, 3));
    }
}
