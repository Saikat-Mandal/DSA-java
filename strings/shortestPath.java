public class shortestPath {

    public static int path(String s) {
        int x = 0, y = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'N') {
                y = y + 1;
            } else if (s.charAt(i) == 'E') {
                x = x + 1;
            } else if (s.charAt(i) == 'W') {
                x = x - 1;
            } else if (s.charAt(i) == 'S') {
                y = y - 1;
            }
        }
        int ans = (x * x) + (y * y);
        return (int) Math.sqrt(ans);

    }

    public static void main(String[] args) {

        System.out.println(path("WNEENESENNN"));
    }
}
