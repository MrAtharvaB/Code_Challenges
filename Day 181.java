import java.util.*;

class Solution {
    public int countPaths(int V, int[][] edges) {
        int mod = (int)1e9 + 7;

        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int[] e : edges) {
            int u = e[0], v = e[1], t = e[2];
            adj.get(u).add(new int[]{v, t});
            adj.get(v).add(new int[]{u, t});
        }

        long[] dist = new long[V];
        Arrays.fill(dist, Long.MAX_VALUE);

        int[] ways = new int[V];

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));

        dist[0] = 0;
        ways[0] = 1;
        pq.offer(new long[]{0, 0});

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            long time = curr[0];
            int node = (int)curr[1];

            if (time > dist[node]) continue;

            for (int[] nei : adj.get(node)) {
                int next = nei[0];
                long newTime = time + nei[1];

                if (newTime < dist[next]) {
                    dist[next] = newTime;
                    ways[next] = ways[node];
                    pq.offer(new long[]{newTime, next});
                } else if (newTime == dist[next]) {
                    ways[next] = (ways[next] + ways[node]) % mod;
                }
            }
        }

        return ways[V - 1];
    }
}
