class Solution {
    public ArrayList<ArrayList<Integer>> searchWord(char[][] mat, String word) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        
        int n = mat.length;
        int m = mat[0].length;
        
        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] != word.charAt(0))
                    continue;
                
                for (int d = 0; d < 8; d++) {
                    int r = i;
                    int c = j;
                    int k = 0;
                    
                    while (k < word.length()) {
                        if (r < 0 || r >= n || c < 0 || c >= m ||
                            mat[r][c] != word.charAt(k)) {
                            break;
                        }
                        
                        r += dr[d];
                        c += dc[d];
                        k++;
                    }
                    
                    if (k == word.length()) {
                        ArrayList<Integer> pos = new ArrayList<>();
                        pos.add(i);
                        pos.add(j);
                        ans.add(pos);
                        break;
                    }
                }
            }
        }
        
        return ans;
    }
}
