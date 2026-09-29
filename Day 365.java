
class Solution {
    public int minStepToReachTarget(int knightPos[], int targetPos[], int n) {
        int sx = knightPos[0] - 1;
        int sy = knightPos[1] - 1;
        int tx = targetPos[0] - 1;
        int ty = targetPos[1] - 1;

        if (sx == tx && sy == ty) {
            return 0;
        }

        int[] dx = {2, 2, -2, -2, 1, 1, -1, -1};
        int[] dy = {1, -1, 1, -1, 2, -2, 2, -2};

        boolean[][] visited = new boolean[n][n];
        java.util.Queue<int[]> queue = new java.util.LinkedList<>();

        queue.offer(new int[]{sx, sy, 0});
        visited[sx][sy] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            int x = curr[0];
            int y = curr[1];
            int steps = curr[2];

            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n
                        && !visited[nx][ny]) {

                    if (nx == tx && ny == ty) {
                        return steps + 1;
                    }

                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny, steps + 1});
                }
            }
        }

        return -1;
    }
}
