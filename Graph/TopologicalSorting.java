import java.util.*;

public class TopologicalSorting {
    // topological sorting is only possible in DAG: Directed Acyclic Graph
    // topological sorting is a linear ordering of vertices such that for every
    // directed edge uv, vertex u comes before v in the ordering.
    // topological sorting for a graph is not possible if the graph is not a DAG.
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
        ArrayList<Edge>[] graph = new ArrayList[6];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));

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
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[v];

        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                // this will ensure that all the vertices are visited
                dfs(graph, i, visited, st);
            }
        }
        System.out.println("topological sorting : ");
        while (!st.isEmpty()) {
            System.out.print(st.pop() + " ");
        }
    }

    private static void dfs(ArrayList<TopologicalSorting.Edge>[] graph, int curr, boolean[] visited,
            Stack<Integer> st) {

        visited[curr] = true;
        for (int i = graph[curr].size() - 1; i >= 0; i--) {
            Edge e = graph[curr].get(i);
            if (!visited[e.dest]) {

                dfs(graph, e.dest, visited, st);
            }
        }

        st.push(curr);
    }
}
