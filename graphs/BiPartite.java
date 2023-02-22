import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BiPartite {

    static class Edge {
        int s, d;

        Edge(int src, int dest) {
            this.s = src;
            this.d = dest;

        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        // 0
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        // 1
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        // 2
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        // 3
        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));

        // 4
        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));

    }

    public static boolean isBipartite(ArrayList<Edge> graph[]) {
        int color[] = new int[graph.length];
        Arrays.fill(color, -1);
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1) {
                q.add(i);
                color[i] = 0;
                while (!q.isEmpty()) {
                    int cur = q.remove();
                    for (int j = 0; j < graph[cur].size(); j++) {
                        Edge e = graph[cur].get(j);
                        if (color[e.d] == -1) {
                            int nextColor = color[cur] == 0 ? 1 : 0;
                            color[e.d] = nextColor;
                            q.add(e.d);
                        } else if (color[e.d] == color[cur]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int v = 7;
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);
        System.out.println(isBipartite(graph));
    }
}
