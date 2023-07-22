import java.util.*;

public class Dijkstras {
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
        // create a graph with with weighted edges
        int n = 7;
        ArrayList<Edge>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 3, 40));
        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 2, 10));
        graph[2].add(new Edge(2, 1, 10));
        graph[2].add(new Edge(2, 3, 10));
        graph[3].add(new Edge(3, 0, 40));
        graph[3].add(new Edge(3, 2, 10));
        graph[3].add(new Edge(3, 4, 2));
        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 3));
        graph[4].add(new Edge(4, 6, 8));
        graph[5].add(new Edge(5, 4, 3));
        graph[5].add(new Edge(5, 6, 3));
        graph[6].add(new Edge(6, 4, 8));
        graph[6].add(new Edge(6, 5, 3));
        dijkstras(graph, 0, n);

    }

    public static class Pair {
        int node;
        int dis;

        // pair is used to store the node and its distance from the source node
        // we will use this pair to store the node and its distance in the priority
        // queue
        // so that we can get the node with the minimum distance from the source node
        Pair(int node, int dis) {
            this.node = node;
            this.dis = dis;
        }
    }

    static void dijkstras(ArrayList<Edge>[] graph, int src, int v) {

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            return (a.dis - b.dis);
        });
        int[] dis = new int[v];
        boolean[] vis = new boolean[v];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[src] = 0;
        pq.add(new Pair(src, 0));
        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (vis[curr.node])
                continue;
            vis[curr.node] = true;
            for (int i = 0; i < graph[curr.node].size(); i++) {
                Edge e = graph[curr.node].get(i);
                int U = e.src;
                int V = e.dest;
                int W = e.wt;
                if (dis[U] + W < dis[V]) {
                    dis[V] = dis[U] + W;
                    pq.add(new Pair(V, dis[V]));
                }

            }
        }
        // print the distance of each node from the source node
        System.out.println("Distance of each node from the source node");
        for (int i = 0; i < v; i++) {
            System.out.println(i + " " + dis[i]);
        }
    }

}
