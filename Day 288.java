class Solution {
    int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int rows, cols;

    public int longestPath(int[][] mat, int xs, int ys, int xd, int yd) {
        rows = mat.length;
        cols = mat[0].length;

        if (mat[xs][ys] == 0 || mat[xd][yd] == 0) {
            return -1;
        }

        boolean[][] visited = new boolean[rows][cols];
        return solve(mat, xs, ys, xd, yd, visited);
    }

    private int solve(int[][] mat, int x, int y, int xd, int yd, boolean[][] visited) {
        if (x == xd && y == yd) {
            return 0;
        }

        visited[x][y] = true;
        int ans = -1;

        for (int i = 0; i < 4; i++) {
            int nx = x + moves[i][0];
            int ny = y + moves[i][1];

            if (isValid(nx, ny, mat, visited)) {
                int res = solve(mat, nx, ny, xd, yd, visited);
                if (res >= 0) {
                    ans = Math.max(ans, res + 1);
                }
            }
        }

        visited[x][y] = false;
        return ans;
    }

    private boolean isValid(int x, int y, int[][] mat, boolean[][] visited) {
        return x >= 0 && x < rows &&
               y >= 0 && y < cols &&
               mat[x][y] == 1 &&
               !visited[x][y];
    }
}
