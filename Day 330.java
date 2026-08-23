class Solution {
    public int numberOfCells(int r, int c, int u, int d, char[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        if (mat[r][c] == '#') {
            return 0;
        }

        int[][] dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            java.util.Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        java.util.ArrayDeque<int[]> q = new java.util.ArrayDeque<>();

        dist[r][c] = 0;
        q.offer(new int[]{r, c});

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int k = 0; k < 4; k++) {
                int nx = x + dr[k];
                int ny = y + dc[k];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                if (mat[nx][ny] == '#') {
                    continue;
                }

                int newUp = dist[x][y] + (nx < x ? 1 : 0);

                if (newUp <= u && newUp < dist[nx][ny]) {
                    dist[nx][ny] = newUp;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dist[i][j] == Integer.MAX_VALUE) {
                    continue;
                }

                int down = dist[i][j] + (i - r);

                if (down <= d) {
                    count++;
                }
            }
        }

        return count;
    }
}
