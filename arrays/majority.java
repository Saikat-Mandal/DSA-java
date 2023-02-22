import java.util.HashMap;

public class majority {
    public static int majorityElement(int a[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            if (map.containsKey(a[i])) {
                map.put(a[i], map.get(a[i]) + 1);
            } else {
                map.put(a[i], 1);
            }
        }
        int c = 0;
        int ans = -1;
        for (int i = 0; i < map.size(); i++) {
            c = Math.max(c, map.get(a[i]));
            if (c > a.length / 2) {
                ans = c;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int a[] = { 3, 1, 3, 3, 2 };
        System.out.println(majorityElement(a));

    }
}
