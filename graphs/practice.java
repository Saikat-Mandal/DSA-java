import java.util.*;
import java.util.LinkedList;

public class practice {
    static class Edge {
        int src, dest;

        public Edge(int s, int d) {
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

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));

        graph[3].add(new Edge(3, 1));

        graph[2].add(new Edge(2, 3));
    }

    public static void indeg(ArrayList<Edge>[] graph, int indegree[]) {

        for (int i = 0; i < graph.length; i++) {
            int cur = i;
            for (int j = 0; j < graph[cur].size(); j++) {
                Edge e = graph[cur].get(j);
                indegree[e.dest]++;
            }
        }

    }

    public static void topo(ArrayList<Edge>[] graph) {
        int indegree[] = new int[graph.length];
        indeg(graph, indegree);
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int cur = q.remove();
            System.out.print(cur + " ");
            for (int i = 0; i < graph[cur].size(); i++) {
                Edge e = graph[cur].get(i);
                indegree[e.dest]--;
                if (indegree[e.dest] == 0) {
                    q.add(e.dest);
                }
            }
        }
    }

    public static void main(String[] args) {
        int v = 6;
        ArrayList<Edge> graph[] = new ArrayList[v];

        createGraph(graph);
        topo(graph);
    }
}
