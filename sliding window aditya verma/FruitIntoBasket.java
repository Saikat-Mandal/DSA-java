import java.util.HashMap;

public class FruitIntoBasket {
    public static int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0, j = 0, ans = 0;
        while (j < fruits.length) {
            int key = fruits[j];
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
            if (map.size() <= 2) {
                ans = Math.max(ans, (j - i + 1));
                j++;
            } else if (map.size() > 2) {
                while (map.size() > 2) {
                    int cur = fruits[i];
                    if (map.get(cur) > 0) {
                        map.put(cur, map.get(cur) - 1);
                    }
                    if (map.get(cur) == 0) {
                        map.remove(cur);
                    }
                    i++;
                }
                j++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int fruits[] = { 1, 1 };
        System.out.println(totalFruit(fruits));
    }
}
