class Solution {
    public boolean isNegativeWeightCycle(int V, int[][] edges) {
        int[] dist = new int[V];

        for (int i = 0; i < V - 1; i++) {
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];

                if (dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w;
                }
            }
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            if (dist[v] > dist[u] + w) {
                return true;
            }
        }

        return false;
    }
}
