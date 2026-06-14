class Solution {
    public List<Integer> exitPoint(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        int i = 0, j = 0, d = 0;

        while (i >= 0 && i < n && j >= 0 && j < m) {
            if (mat[i][j] == 1) {
                d = (d + 1) % 4;
                mat[i][j] = 0;
            }

            int ni = i + dr[d];
            int nj = j + dc[d];

            if (ni < 0 || ni >= n || nj < 0 || nj >= m) {
                return Arrays.asList(i, j);
            }

            i = ni;
            j = nj;
        }

        return Arrays.asList(i, j);
    }
}
