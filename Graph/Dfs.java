import java.util.*;

public class Dfs {
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
        graph[3].add(new Edge(3, 5));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));
        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[6].add(new Edge(6, 4));
        graph[6].add(new Edge(6, 5));
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
        for (int i = 0; i < v; i++) {
            visited[i] = false;
        }
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                System.out.println("dfs from " + i + " :");
                dfs(graph, i, visited);
                // dfsStack(graph, i, visited);
            }
        }
    }

    private static void dfs(ArrayList<Dfs.Edge>[] graph, int start, boolean[] visited) {
        System.out.println(start);
        visited[start] = true;
        for (int i = graph[start].size() - 1; i >= 0; i--) {
            Edge e = graph[start].get(i);
            if (!visited[e.dest]) {
                dfs(graph, e.dest, visited);

            }
        }

    }

    private static void dfsStack(ArrayList<Dfs.Edge>[] graph, int start, boolean[] visited) {
        // dfs using stack
        Stack<Integer> st = new Stack<>();
        st.push(start);
        while (!st.isEmpty()) {
            int curr = st.pop();
            if (!visited[curr]) {
                System.out.println(curr);
                visited[curr] = true;
            }
            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                if (!visited[e.dest]) {

                    st.push(e.dest);
                }
                // System.out.println(st + "stack");
            }

        }
    }
}
