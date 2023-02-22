import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DNA {
    public static void findRepeatedDnaSequences(String s) {
        String res = "";
        List<String> l = new ArrayList<>();
        int i = 0, j = 0, k = 10;
        HashMap<String, Integer> map = new HashMap<>();
        while (j < s.length()) {
            res += s.charAt(j);
            if ((j - i + 1) < k) {
                j++;
            } else if ((j - i + 1) == k) {
                if (map.containsKey(res)) {
                    map.put(res, map.get(res) + 1);
                } else {
                    map.put(res, 1);
                }
                res = res.substring(1);
                i++;
            }
            j++;
        }

        System.out.println(map);
    }

    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        findRepeatedDnaSequences(s);
    }
}
