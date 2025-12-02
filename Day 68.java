import java.util.*;

class Solution {
    public int maxScore(String s, char[][] jumps) {
        int n = s.length();
        int ALPH = 26;
        long NEG_INF = Long.MIN_VALUE / 4;

        boolean[][] allowed = new boolean[ALPH][ALPH];
        for (char[] p : jumps) {
            int from = p[0] - 'a';
            int to = p[1] - 'a';
            if (from >= 0 && from < ALPH && to >= 0 && to < ALPH) {
                allowed[from][to] = true;
            }
        }
        for (int c = 0; c < ALPH; c++) {
            allowed[c][c] = true;
        }

        List<List<Integer>> edgesFrom = new ArrayList<>();
        for (int i = 0; i < ALPH; i++) {
            edgesFrom.add(new ArrayList<>());
            for (int j = 0; j < ALPH; j++) {
                if (allowed[i][j]) {
                    edgesFrom.get(i).add(j);
                }
            }
        }

        int[] prefAll = new int[n + 1];
        int[][] cnt = new int[ALPH][n + 1];

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            prefAll[i + 1] = prefAll[i] + (int) ch;
            for (int c = 0; c < ALPH; c++) {
                cnt[c][i + 1] = cnt[c][i];
            }
            int idx = ch - 'a';
            if (idx >= 0 && idx < ALPH) {
                cnt[idx][i + 1]++;
            }
        }

        long[] dp = new long[n];
        Arrays.fill(dp, NEG_INF);
        dp[0] = 0;

        long[] best = new long[ALPH];
        Arrays.fill(best, NEG_INF);

        int firstIdx = s.charAt(0) - 'a';
        if (firstIdx >= 0 && firstIdx < ALPH) {
            for (int target : edgesFrom.get(firstIdx)) {
                char tc = (char) ('a' + target);
                long cand = dp[0] - prefAll[0] + (long) tc * cnt[target][0];
                if (cand > best[target]) {
                    best[target] = cand;
                }
            }
        }

        for (int i = 1; i < n; i++) {
            char ch = s.charAt(i);
            int cIdx = ch - 'a';

            if (cIdx >= 0 && cIdx < ALPH && best[cIdx] != NEG_INF) {
                long base = (long) prefAll[i] - (long) ch * cnt[cIdx][i];
                long val = base + best[cIdx];
                if (val > dp[i]) {
                    dp[i] = val;
                }
            }

            if (cIdx >= 0 && cIdx < ALPH && dp[i] != NEG_INF) {
                for (int target : edgesFrom.get(cIdx)) {
                    char tc = (char) ('a' + target);
                    long cand = dp[i] - prefAll[i] + (long) tc * cnt[target][i];
                    if (cand > best[target]) {
                        best[target] = cand;
                    }
                }
            }
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] > ans) {
                ans = dp[i];
            }
        }

        return (int) ans;
    }
}
