import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class topologicalSort {
    static class Edge {
        int src, dest;

        Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
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

    // topological sort -DFS

    public static void topology(ArrayList<Edge> graph[]) {
        Stack<Integer> st = new Stack<>();
        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                topologyUtil(graph, i, vis, st);
            }
        }

        while (!st.isEmpty()) {
            System.out.print(st.pop() + " ");
        }
    }

    public static void topologyUtil(ArrayList<Edge> graph[], int cur, boolean vis[], Stack<Integer> st) {
        vis[cur] = true;
        for (int i = 0; i < graph[cur].size(); i++) {
            Edge e = graph[cur].get(i);
            if (!vis[e.dest]) {
                topologyUtil(graph, e.dest, vis, st);
            }
        }
        st.push(cur);

    }

    // topological sort Kahn's algo
    // use indegree
    public static void calcIndegree(ArrayList<Edge> graph[], int[] indegree) {
        for (int i = 0; i < graph.length; i++) {
            int v = i;
            for (int j = 0; j < graph[v].size(); j++) {
                Edge e = graph[v].get(j);
                indegree[e.dest]++;
            }
        }
    }

    public static void topSort(ArrayList<Edge> graph[]) {
        int indegree[] = new int[graph.length];
        calcIndegree(graph, indegree);
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.add(i); // only add those vertices whose indegree is 0
            }
        }
        // bfs
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
        System.out.println();
    }

    public static void main(String[] args) {
        int v = 6;
        ArrayList<Edge> graph[] = new ArrayList[v];

        createGraph(graph);
        topSort(graph);
    }
}
