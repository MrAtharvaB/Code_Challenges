class Solution {
    static final int MOD = 1000000007;

    int minOperations(int[] b) {
        int n = b.length;
        boolean[] vis = new boolean[n];
        int[] maxExp = new int[n + 1];

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                int cur = i;
                int len = 0;

                while (!vis[cur]) {
                    vis[cur] = true;
                    cur = b[cur] - 1;
                    len++;
                }

                int x = len;
                for (int p = 2; p * p <= x; p++) {
                    if (x % p == 0) {
                        int cnt = 0;
                        while (x % p == 0) {
                            x /= p;
                            cnt++;
                        }
                        maxExp[p] = Math.max(maxExp[p], cnt);
                    }
                }

                if (x > 1) {
                    maxExp[x] = Math.max(maxExp[x], 1);
                }
            }
        }

        long ans = 1;

        for (int p = 2; p <= n; p++) {
            for (int i = 0; i < maxExp[p]; i++) {
                ans = (ans * p) % MOD;
            }
        }

        return (int) ans;
    }
}
