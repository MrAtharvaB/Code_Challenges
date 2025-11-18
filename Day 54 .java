class Solution {
    private static final long MOD = 1_000_000_007L;

    public int countPaths(int V, int[][] edges) {
        List<List<long[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; ++i) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            adj.get(u).add(new long[]{v, w});
            adj.get(v).add(new long[]{u, w});
        }

        long[] dist = new long[V];
        long[] ways = new long[V];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.offer(new long[]{0, 0});

        while (!pq.isEmpty()) {
            long[] top = pq.poll();
            long d = top[0];
            int node = (int) top[1];
            if (d > dist[node]) continue;

            for (long[] neiArr : adj.get(node)) {
                int nei = (int) neiArr[0];
                long w = neiArr[1];
                long nd = d + w;

                if (nd < dist[nei]) {
                    dist[nei] = nd;
                    ways[nei] = ways[node];
                    pq.offer(new long[]{nd, nei});
                } else if (nd == dist[nei]) {
                    ways[nei] = (ways[nei] + ways[node]) % MOD;
                }
            }
        }

        return (int) (ways[V - 1] % MOD);
    }
}
