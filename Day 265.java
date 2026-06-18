class Solution {
    public int findCoverage(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        boolean[][] left = new boolean[n][m];
        boolean[][] right = new boolean[n][m];
        boolean[][] up = new boolean[n][m];
        boolean[][] down = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            boolean seen = false;
            for (int j = 0; j < m; j++) {
                left[i][j] = seen;
                if (mat[i][j] == 1) seen = true;
            }
        }

        for (int i = 0; i < n; i++) {
            boolean seen = false;
            for (int j = m - 1; j >= 0; j--) {
                right[i][j] = seen;
                if (mat[i][j] == 1) seen = true;
            }
        }

        for (int j = 0; j < m; j++) {
            boolean seen = false;
            for (int i = 0; i < n; i++) {
                up[i][j] = seen;
                if (mat[i][j] == 1) seen = true;
            }
        }

        for (int j = 0; j < m; j++) {
            boolean seen = false;
            for (int i = n - 1; i >= 0; i--) {
                down[i][j] = seen;
                if (mat[i][j] == 1) seen = true;
            }
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    if (left[i][j]) ans++;
                    if (right[i][j]) ans++;
                    if (up[i][j]) ans++;
                    if (down[i][j]) ans++;
                }
            }
        }

        return ans;
    }
}
