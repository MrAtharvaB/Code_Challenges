import java.util.*;

class Solution {

    static class Edge {
        int u, v, w, idx;
        Edge(int u, int v, int w, int idx) {
            this.u = u; this.v = v; this.w = w; this.idx = idx;
        }
    }

    static class DSU {
        int[] parent, rank;
        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }
        int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }
        boolean union(int x, int y) {
            int rx = find(x), ry = find(y);
            if (rx == ry) return false;
            if (rank[rx] < rank[ry]) parent[rx] = ry;
            else if (rank[rx] > rank[ry]) parent[ry] = rx;
            else {
                parent[ry] = rx;
                rank[rx]++;
            }
            return true;
        }
    }

    public int secondMST(int V, int[][] edges) {
        int E = edges.length;
        // Basic connectivity check: need at least V-1 edges for one tree
        if (E < V - 1) return -1; 

        Edge[] arr = new Edge[E];
        for (int i = 0; i < E; i++)
            arr[i] = new Edge(edges[i][0], edges[i][1], edges[i][2], i);

        // Sort edges to build the First MST
        Arrays.sort(arr, (a, b) -> Integer.compare(a.w, b.w));

        DSU dsu = new DSU(V);
        boolean[] inMST = new boolean[E];
        
        // Using ArrayList array for Adjacency list
        @SuppressWarnings("unchecked")
        List<int[]>[] mstAdj = new ArrayList[V];
        for (int i = 0; i < V; i++) mstAdj[i] = new ArrayList<>();

        int mstWeight = 0, count = 0;

        // 1. Build the First MST
        for (Edge e : arr) {
            if (dsu.union(e.u, e.v)) {
                inMST[e.idx] = true; // Use original index to mark used edges
                mstWeight += e.w;
                count++;
                mstAdj[e.u].add(new int[]{e.v, e.w});
                mstAdj[e.v].add(new int[]{e.u, e.w});
            }
        }

        // If graph is disconnected, no MST exists
        if (count != V - 1) return -1;
        
        int secondBest = Integer.MAX_VALUE;

        // 2. Try adding every non-MST edge
        for (int i = 0; i < E; i++) {
            // Skip edges that are already in the First MST
            // Note: We must check the sorted array's 'idx' to match original input
            // But since we iterate 'edges' (input), we check inMST[i] directly.
            if (inMST[i]) continue; 

            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            // Find the smallest POSITIVE difference we can get by swapping
            // an edge on the path between u and v with this new edge w.
            int minDiff = findMinStrictGain(u, v, w, mstAdj);

            if (minDiff != Integer.MAX_VALUE) {
                int candidate = mstWeight + minDiff;
                if (candidate < secondBest) {
                    secondBest = candidate;
                }
            }
        }

        return secondBest == Integer.MAX_VALUE ? -1 : secondBest;
    }

    // Wrapper to initiate DFS
    private int findMinStrictGain(int u, int v, int newWeight, List<int[]>[] adj) {
        // Array to hold the result since Java passes primitives by value
        // minDiff[0] will store the minimum (newWeight - pathEdgeWeight) > 0
        int[] minDiff = {Integer.MAX_VALUE};
        dfsPath(u, v, -1, adj, newWeight, minDiff);
        return minDiff[0];
    }

    // DFS to traverse the path from u to target (v) in the MST
    private boolean dfsPath(int curr, int target, int p, List<int[]>[] adj, 
                            int newWeight, int[] minDiff) {
        if (curr == target) return true;

        for (int[] edge : adj[curr]) {
            int next = edge[0];
            int w = edge[1];

            if (next != p) {
                if (dfsPath(next, target, curr, adj, newWeight, minDiff)) {
                    // If we are here, this edge is part of the path between u and v
                    int diff = newWeight - w;
                    
                    // KEY FIX: We only care about strictly positive differences.
                    // We want the smallest possible increase.
                    if (diff > 0) {
                        if (diff < minDiff[0]) {
                            minDiff[0] = diff;
                        }
                    }
                    return true; // Keep bubbling up true to trace the path back
                }
            }
        }
        return false;
    }
}
