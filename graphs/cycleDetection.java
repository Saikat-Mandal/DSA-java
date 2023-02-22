import java.util.ArrayList;

public class cycleDetection {
    static class Edge {
        int s, d;

        Edge(int s, int d) {
            this.s = s;
            this.d = d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        // 0
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        // 1
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        // 2
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        // 3
        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

        // 4
        graph[4].add(new Edge(4, 3));

    }

    public static boolean cycleUtil(ArrayList<Edge> graph[], boolean[] vis, int cur, int par) {
        vis[cur] = true;
        for (int i = 0; i < graph[cur].size(); i++) {
            Edge e = graph[cur].get(i);

            // case 3
            if (!vis[e.d]) {
                if (cycleUtil(graph, vis, e.d, cur)) {

                    return true;
                }
            }
            // case 2
            else if (vis[e.d] && e.d != par) {
                return true;
            }
            // case 3
            // do nothing i.e continue
        }
        return false;
    }

    // cycledetection
    public static boolean cycle(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (cycleUtil(graph, vis, i, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int v = 5;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        System.out.println(cycle(graph));
    }
}
