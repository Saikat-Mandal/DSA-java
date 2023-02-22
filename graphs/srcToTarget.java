import java.util.ArrayList;

public class srcToTarget {
    static class Edge {
        int src, dest;

        Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[0].add(new Edge(0, 3));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));

        graph[3].add(new Edge(3, 1));

        graph[2].add(new Edge(2, 3));
    }

    public static void findPath(ArrayList<Edge>[] graph, int start, int end, String b) {

        if (start == end) {

            System.out.println(b + end);
            return;
        }
        for (int i = 0; i < graph[start].size(); i++) {
            Edge e = graph[start].get(i);
            findPath(graph, e.dest, end, b + start);
        }

    }

    public static void main(String[] args) {
        int v = 6;
        ArrayList<Edge> graph[] = new ArrayList[v];

        createGraph(graph);
        findPath(graph, 5, 1, "");
    }
}
