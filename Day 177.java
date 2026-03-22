import java.util.*;

class Solution {
    public int orangesRot(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 2) {
                    q.offer(new int[]{i, j});
                } else if (mat[i][j] == 1) {
                    fresh++;
                }
            }
        }
        
        if (fresh == 0) return 0;
        
        int time = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        
        while (!q.isEmpty()) {
            int size = q.size();
            boolean rotted = false;
            
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int r = curr[0], c = curr[1];
                
                for (int[] d : dirs) {
                    int nr = r + d[0];
                    int nc = c + d[1];
                    
                    if (nr >= 0 && nc >= 0 && nr < n && nc < m && mat[nr][nc] == 1) {
                        mat[nr][nc] = 2;
                        q.offer(new int[]{nr, nc});
                        fresh--;
                        rotted = true;
                    }
                }
            }
            
            if (rotted) time++;
        }
        
        return fresh == 0 ? time : -1;
    }
}
