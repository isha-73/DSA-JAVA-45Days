
//https://leetcode.com/problems/network-delay-time/
import java.util.*;

class Solution {
    static class Pair {
        int node;
        int tm;

        Pair(int node, int tm) {
            this.node = node;
            this.tm = tm;
        }
    }

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

    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<Edge>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) { // Modify the loop to start from 1
            graph[i] = new ArrayList<>();
        }

        // Create graph from the given data
        for (int i = 0; i < times.length; i++) {
            int src = times[i][0];
            int dest = times[i][1];
            int wt = times[i][2];
            graph[src].add(new Edge(src, dest, wt));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.tm - b.tm);

        int[] time = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        Arrays.fill(time, Integer.MAX_VALUE);
        time[k] = 0;
        pq.add(new Pair(k, 0)); // src, tm

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (!visited[curr.node]) {
                visited[curr.node] = true;
                for (Edge e : graph[curr.node]) {
                    int u = e.src;
                    int v = e.dest;
                    int w = e.wt;
                    if (time[u] + w < time[v]) {
                        time[v] = time[u] + w; // relaxation;
                        pq.add(new Pair(v, time[v]));
                    }
                }
            }
        }

        // Find the maximum time from the source (k) to any other node
        int maxTime = -1;
        for (int i = 1; i <= n; i++) {
            if (time[i] == Integer.MAX_VALUE) {
                return -1; // If any node is not reachable from the source, return -1.
            }
            maxTime = Math.max(maxTime, time[i]);
        }

        return maxTime;

    }
}