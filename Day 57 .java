class Solution {

    int idx;
    int[] head, to, w, next;

    void add(int u, int v, int ww) {
        to[idx] = v;
        w[idx] = ww;
        next[idx] = head[u];
        head[u] = idx++;
    }

    public int shortestPath(int V, int a, int b, int[][] edges) {
        if (a == b) return 0;

        int N = 2 * V;
        int E = edges.length;
        int maxEdges = 6 * E + 5;

        head = new int[N];
        Arrays.fill(head, -1);
        to = new int[maxEdges];
        w = new int[maxEdges];
        next = new int[maxEdges];
        idx = 0;

        for (int[] e : edges) {
            int x = e[0], y = e[1], straight = e[2], curved = e[3];

            add(x, y, straight);
            add(y, x, straight);
            add(x + V, y + V, straight);
            add(y + V, x + V, straight);

            add(x, y + V, curved);
            add(y, x + V, curved);
        }

        long INF = Long.MAX_VALUE / 4;
        long[] dist = new long[N];
        Arrays.fill(dist, INF);
        boolean[] seen = new boolean[N];

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(o -> o[1]));
        dist[a] = 0;
        pq.add(new long[]{a, 0});

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            int u = (int) cur[0];
            if (seen[u]) continue;
            seen[u] = true;

            for (int e = head[u]; e != -1; e = next[e]) {
                int v = to[e];
                long nd = dist[u] + w[e];
                if (nd < dist[v]) {
                    dist[v] = nd;
                    pq.add(new long[]{v, nd});
                }
            }
        }

        long ans = Math.min(dist[b], dist[b + V]);
        return ans >= INF ? -1 : (int) ans;
    }
}
