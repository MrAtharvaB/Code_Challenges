class Solution {

    static class DSU {
        int[] parent;
        int[] size;

        DSU(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int x, int y) {
            int px = find(x), py = find(y);
            if (px == py) return;
            if (size[px] < size[py]) {
                int t = px; px = py; py = t;
            }
            parent[py] = px;
            size[px] += size[py];
        }
    }

    int maxRemove(int[][] stones) {
        int n = stones.length;
        int maxRow = 0, maxCol = 0;
        for (int[] s : stones) {
            maxRow = Math.max(maxRow, s[0]);
            maxCol = Math.max(maxCol, s[1]);
        }

        int offset = maxRow + 1;
        int totalNodes = offset + maxCol + 1;
        DSU dsu = new DSU(totalNodes);
        boolean[] used = new boolean[totalNodes];

        for (int[] s : stones) {
            int r = s[0], c = s[1] + offset;
            dsu.union(r, c);
            used[r] = true;
            used[c] = true;
        }

        java.util.HashSet<Integer> comp = new java.util.HashSet<>();
        for (int i = 0; i < totalNodes; i++) {
            if (used[i]) comp.add(dsu.find(i));
        }

        return n - comp.size();
    }
}
