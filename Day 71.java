class Solution {
    int minCost(int[][] costs) {
        int n = costs.length;
        if (n == 0) return 0;

        int k = costs[0].length;
        if (k == 0) return -1;
        if (k == 1) {
            if (n == 1) return costs[0][0];
            return -1;
        }

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int idx1 = -1;

        for (int j = 0; j < k; j++) {
            int cost = costs[0][j];
            if (cost < min1) {
                min2 = min1;
                min1 = cost;
                idx1 = j;
            } else if (cost < min2) {
                min2 = cost;
            }
        }

        for (int i = 1; i < n; i++) {
            int curMin1 = Integer.MAX_VALUE;
            int curMin2 = Integer.MAX_VALUE;
            int curIdx1 = -1;

            for (int j = 0; j < k; j++) {
                int prevBest = (j == idx1) ? min2 : min1;
                int cost = costs[i][j] + prevBest;

                if (cost < curMin1) {
                    curMin2 = curMin1;
                    curMin1 = cost;
                    curIdx1 = j;
                } else if (cost < curMin2) {
                    curMin2 = cost;
                }
            }

            min1 = curMin1;
            min2 = curMin2;
            idx1 = curIdx1;
        }

        return min1 == Integer.MAX_VALUE ? -1 : min1;
    }
}
