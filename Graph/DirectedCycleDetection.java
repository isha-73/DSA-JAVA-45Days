
import java.util.*;

public class DirectedCycleDetection {
    static class Edge {
        int src;
        int dest;
        int wt;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }

        Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static void main(String[] args) {
        ArrayList<Edge>[] graph = new ArrayList[7];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 3));
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));
        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 2));
        graph[3].add(new Edge(3, 4));
        // graph[3].add(new Edge(3, 5));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));
        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[6].add(new Edge(6, 4));

        int v = graph.length;
        // print graph
        for (int i = 0; i < v; i++) {
            System.out.print(i + " -> ");
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                System.out.print(e.dest + " ");
            }
            System.out.println();
        }
        // dfs
        boolean[] visited = new boolean[v];
        boolean[] rec = new boolean[v];
        System.out.println("cycle detected : " + dfs(graph, 0, rec, visited));
    }

    private static boolean dfs(ArrayList<DirectedCycleDetection.Edge>[] graph, int curr, boolean rec[],
            boolean[] visited) {

        visited[curr] = true;
        rec[curr] = true;

        for (int i = graph[curr].size() - 1; i >= 0; i--) {
            Edge e = graph[curr].get(i);
            if (rec[e.dest])
                return true; // cycle detected
            else if (!visited[e.dest]) {
                // dfs(graph, e.dest, visited);
                if (dfs(graph, e.dest, rec, visited))
                    return true;
            }
        }
        rec[curr] = false;
        return false;

    }
}
