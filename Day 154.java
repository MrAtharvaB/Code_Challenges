class Solution {
    public int countSquare(int[][] mat, int x) {
        int n = mat.length;
        int m = mat[0].length;
        
        int[][] prefix = new int[n + 1][m + 1];
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                prefix[i][j] = mat[i - 1][j - 1]
                             + prefix[i - 1][j]
                             + prefix[i][j - 1]
                             - prefix[i - 1][j - 1];
            }
        }
        
        int count = 0;
        
        for (int size = 1; size <= Math.min(n, m); size++) {
            for (int i = size; i <= n; i++) {
                for (int j = size; j <= m; j++) {
                    int total = prefix[i][j]
                              - prefix[i - size][j]
                              - prefix[i][j - size]
                              + prefix[i - size][j - size];
                    
                    if (total == x) {
                        count++;
                    }
                }
            }
        }
        
        return count;
    }
}
