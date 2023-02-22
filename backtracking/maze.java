import java.util.ArrayList;

public class maze {

    public static boolean isSafe(boolean[][] place, int maze[][], int r, int c) {
        int n = maze.length;

        if (r >= 0 && r < n && c >= 0 && c < n && maze[r][c] != 0 && !place[r][c]) {
            return true;
        }

        return false;
    }

    public static void allPath(String s, int[][] maze, boolean[][] place, int r, int c, ArrayList<String> l) {
        if (!isSafe(place, maze, r, c)) {
            return;
        }
        if (r == maze.length - 1 && c == maze.length - 1) {
            l.add(s);
        }
        place[r][c] = true;
        allPath(s + 'D', maze, place, r + 1, c, l);
        allPath(s + 'U', maze, place, r - 1, c, l);
        allPath(s + 'R', maze, place, r, c + 1, l);
        allPath(s + 'L', maze, place, r, c - 1, l);
        place[r][c] = false;
    }

    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> l = new ArrayList<>();
        boolean place[][] = new boolean[n][n];
        allPath("", m, place, 0, 0, l);
        return l;
    }

    public static void main(String[] args) {
        int[][] maze = { { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 0, 1, 0, 0 },
                { 1, 1, 1, 1 } };

        System.out.println(findPath(maze, 4));
    }
}