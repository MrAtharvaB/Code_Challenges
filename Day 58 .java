class Solution {
    private int find(int x, int[] parent) {
        if (parent[x] != x) {
            parent[x] = find(parent[x], parent);
        }
        return parent[x];
    }

    private boolean union(int x, int y, int[] parent, int[] rank) {
        int px = find(x, parent);
        int py = find(y, parent);
        if (px == py) return false;

        if (rank[px] < rank[py]) {
            parent[px] = py;
        } else if (rank[py] < rank[px]) {
            parent[py] = px;
        } else {
            parent[py] = px;
            rank[px]++;
        }
        return true;
    }

    public int minConnect(int V, int[][] edges) {
        int E = edges.length;
        if (E < V - 1) return -1;

        int[] parent = new int[V];
        int[] rank = new int[V];

        for (int i = 0; i < V; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        int components = V;

        for (int[] edge : edges) {
            if (union(edge[0], edge[1], parent, rank)) {
                components--;
            }
        }

        return components - 1;
    }
}
