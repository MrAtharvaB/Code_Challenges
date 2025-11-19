class Solution {
    public int minCostPath(int[][] mat) {
        int n = mat.length, m = mat[0].length;

        int[][] dist = new int[n][m];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        dist[0][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[]{0, 0, 0});

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int effort = cur[0], r = cur[1], c = cur[2];

            if (effort > dist[r][c]) continue;
            if (r == n - 1 && c == m - 1) return effort;

            for (int k = 0; k < 4; ++k) {
                int nr = r + dr[k], nc = c + dc[k];
                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;

                int edgeCost = Math.abs(mat[nr][nc] - mat[r][c]);
                int nextEffort = Math.max(effort, edgeCost);

                if (nextEffort < dist[nr][nc]) {
                    dist[nr][nc] = nextEffort;
                    pq.offer(new int[]{nextEffort, nr, nc});
                }
            }
        }

        return dist[n - 1][m - 1];
    }
}
