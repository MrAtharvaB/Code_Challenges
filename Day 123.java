class Solution {
    private int n, m;
    private boolean[][] vis;
    
    public boolean isWordExist(char[][] mat, String word) {
        n = mat.length;
        m = mat[0].length;
        vis = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == word.charAt(0)) {
                    if (dfs(mat, word, i, j, 0)) return true;
                }
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] mat, String word, int r, int c, int idx) {
        if (idx == word.length()) return true;
        
        if (r < 0 || c < 0 || r >= n || c >= m) return false;
        if (vis[r][c]) return false;
        if (mat[r][c] != word.charAt(idx)) return false;
        
        vis[r][c] = true;
        
        boolean found =
                dfs(mat, word, r + 1, c, idx + 1) ||
                dfs(mat, word, r - 1, c, idx + 1) ||
                dfs(mat, word, r, c + 1, idx + 1) ||
                dfs(mat, word, r, c - 1, idx + 1);
        
        vis[r][c] = false;
        
        return found;
    }
}
