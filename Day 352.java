class Solution {
    int shortestPath(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[][] dir = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        boolean[][] unsafe = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    unsafe[i][j] = true;

                    for (int[] d : dir) {
                        int ni = i + d[0];
                        int nj = j + d[1];

                        if (ni >= 0 && ni < n && nj >= 0 && nj < m) {
                            unsafe[ni][nj] = true;
                        }
                    }
                }
            }
        }

        boolean[][] visited = new boolean[n][m];
        java.util.Queue<int[]> q = new java.util.LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (!unsafe[i][0]) {
                q.offer(new int[]{i, 0, 1});
                visited[i][0] = true;
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            int r = cur[0];
            int c = cur[1];
            int dist = cur[2];

            if (c == m - 1) {
                return dist;
            }

            for (int[] d : dir) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nr < n &&
                    nc >= 0 && nc < m &&
                    !unsafe[nr][nc] &&
                    !visited[nr][nc]) {

                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc, dist + 1});
                }
            }
        }

        return -1;
    }
}
