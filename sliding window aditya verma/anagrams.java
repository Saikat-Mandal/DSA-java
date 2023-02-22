import java.util.HashMap;

public class anagrams {
    public static int find(String pat, String txt) {

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < pat.length(); i++) {
            char ch = pat.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }
        int count = map.size();
        int k = pat.length();
        int i = 0, j = 0, ans = 0;
        while (j < txt.length()) {
            char end = txt.charAt(j);
            if (map.containsKey(end)) {
                map.put(end, map.get(end) - 1);

                if (map.get(end) == 0) {
                    count--;
                }
            }

            if ((j - i + 1) < k) {
                j++;
            } else if ((j - i + 1) == k) {
                if (count == 0) {
                    ans++;
                }
                char start = txt.charAt(i);
                if (map.containsKey(start)) {
                    map.put(start, map.get(start) + 1);
                    if (map.get(start) == 1) {
                        count++;
                    }
                }
                i++;
                j++;
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        String s = "forxxorfxdofr";
        String pat = "for";
        System.out.println(find(pat, s));
    }
}
