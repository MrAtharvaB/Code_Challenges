class Solution {
    public int countSpanTree(int n, int[][] edges) {

        if (n == 1) return 1;

        long[][] lap = new long[n][n];

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];

            lap[u][u]++;
            lap[v][v]++;

            lap[u][v]--;
            lap[v][u]--;
        }

        long[][] mat = new long[n - 1][n - 1];

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                mat[i][j] = lap[i][j];
            }
        }

        double det = determinant(mat, n - 1);

        return (int)Math.round(det);
    }

    private double determinant(long[][] matrix, int size) {
        double[][] a = new double[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                a[i][j] = matrix[i][j];
            }
        }

        double det = 1;

        for (int i = 0; i < size; i++) {

            int pivot = i;

            for (int j = i + 1; j < size; j++) {
                if (Math.abs(a[j][i]) > Math.abs(a[pivot][i])) {
                    pivot = j;
                }
            }

            if (Math.abs(a[pivot][i]) < 1e-9) {
                return 0;
            }

            if (pivot != i) {
                double[] temp = a[i];
                a[i] = a[pivot];
                a[pivot] = temp;

                det *= -1;
            }

            det *= a[i][i];

            for (int j = i + 1; j < size; j++) {
                double factor = a[j][i] / a[i][i];

                for (int k = i; k < size; k++) {
                    a[j][k] -= factor * a[i][k];
                }
            }
        }

        return det;
    }
}
