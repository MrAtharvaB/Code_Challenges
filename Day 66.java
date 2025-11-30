import java.util.*;

class Solution {
    public static int countSubs(String s) {
        int n = s.length();
        int maxStates = 2 * n;
        
        int[][] next = new int[maxStates][26];
        int[] link = new int[maxStates];
        int[] len = new int[maxStates];
        
        for (int i = 0; i < maxStates; i++) {
            Arrays.fill(next[i], -1);
        }
        
        int last = 0;
        int size = 1;
        link[0] = -1;
        len[0] = 0;
        
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            int cur = size++;
            len[cur] = len[last] + 1;
            Arrays.fill(next[cur], -1);
            
            int p = last;
            while (p != -1 && next[p][c] == -1) {
                next[p][c] = cur;
                p = link[p];
            }
            
            if (p == -1) {
                link[cur] = 0;
            } else {
                int q = next[p][c];
                if (len[p] + 1 == len[q]) {
                    link[cur] = q;
                } else {
                    int clone = size++;
                    len[clone] = len[p] + 1;
                    link[clone] = link[q];
                    for (int ch = 0; ch < 26; ch++) {
                        next[clone][ch] = next[q][ch];
                    }
                    while (p != -1 && next[p][c] == q) {
                        next[p][c] = clone;
                        p = link[p];
                    }
                    link[q] = clone;
                    link[cur] = clone;
                }
            }
            last = cur;
        }
        
        long res = 0;
        for (int i = 1; i < size; i++) {
            res += len[i] - len[link[i]];
        }
        
        return (int) res;
    }
}
