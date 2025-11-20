class Solution {
    public int minCost(String s, String t, char[][] transform, int[] cost) {
        long INF = (long)1e15;
        long[][] dist = new long[26][26];

        for (int i = 0; i < 26; i++)
            java.util.Arrays.fill(dist[i], INF);
        for (int i = 0; i < 26; i++)
            dist[i][i] = 0;

        for (int i = 0; i < transform.length; i++) {
            int a = transform[i][0] - 'a';
            int b = transform[i][1] - 'a';
            dist[a][b] = Math.min(dist[a][b], cost[i]);
        }

        for (int k = 0; k < 26; k++)
            for (int i = 0; i < 26; i++)
                for (int j = 0; j < 26; j++)
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];

        long total = 0;

        for (int i = 0; i < s.length(); i++) {
            int a = s.charAt(i) - 'a';
            int b = t.charAt(i) - 'a';
            long best = INF;
            for (int x = 0; x < 26; x++)
                best = Math.min(best, dist[a][x] + dist[b][x]);
            if (best >= INF) return -1;
            total += best;
        }

        return (int) total;
    }
}
