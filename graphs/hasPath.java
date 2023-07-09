import java.util.ArrayList;

public class hasPath {
    static class Edge {
        int src, dest, wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        // 1
        graph[1].add(new Edge(1, 3, 1));
        graph[1].add(new Edge(1, 0, 1));

        // 2
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        // 3
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));
        graph[3].add(new Edge(3, 1, 1));

        // 4
        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        // 5
        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        // 6
        graph[6].add(new Edge(6, 5, 1));

    }

    public static boolean hasPaths(ArrayList<Edge> graph[], int s, int target,
            boolean vis[]) {
        if (s == target) {
            return true;
        }
        int cur = s;
        vis[cur] = true;
        for (int i = 0; i < graph[cur].size(); i++) {
            Edge e = graph[cur].get(i);

            if (!vis[e.dest] && hasPaths(graph, e.dest, target, vis)) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasPaths2(ArrayList<Edge> graph[], int s, int target, boolean vis[]) {
        if (s == target) {
            return true;
        }
        int cur = s;
        vis[cur] = true;
        for (int i = 0; i < graph[cur].size(); i++) {

            if (!vis[graph[cur].get(i).dest]) {
                if (hasPaths2(graph, graph[cur].get(i).dest, target, vis)) {

                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int v = 7;
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);
        boolean[] vis = new boolean[graph.length];
        System.out.println(hasPaths2(graph, 0, 5, vis));
        // System.out.println(hasPaths2(graph, 0, 5, vis));
    }
}
