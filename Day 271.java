class Solution {

    private boolean solve(int[][] mat, int n, int i, int j,
                          int[][] path, boolean[][] failed) {

        if (i >= n || j >= n || mat[i][j] == 0)
            return false;

        if (failed[i][j])
            return false;

        path[i][j] = 1;

        if (i == n - 1 && j == n - 1)
            return true;

        int jump = mat[i][j];

        for (int step = 1; step <= jump; step++) {

            if (solve(mat, n, i, j + step, path, failed))
                return true;

            if (solve(mat, n, i + step, j, path, failed))
                return true;
        }

        path[i][j] = 0;
        failed[i][j] = true;

        return false;
    }

    public ArrayList<ArrayList<Integer>> shortestDist(int[][] mat) {

        int n = mat.length;

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        if (mat[0][0] == 0) {
            ans.add(new ArrayList<>(java.util.Arrays.asList(-1)));
            return ans;
        }

        int[][] path = new int[n][n];
        boolean[][] failed = new boolean[n][n];

        if (!solve(mat, n, 0, 0, path, failed)) {
            ans.add(new ArrayList<>(java.util.Arrays.asList(-1)));
            return ans;
        }

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(path[i][j]);
            }
            ans.add(row);
        }

        return ans;
    }
}
