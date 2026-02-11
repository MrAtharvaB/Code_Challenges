import java.util.*;

class Solution {
    public int minCost(int[] heights, int[] cost) {
        int n = heights.length;
        
        long[][] towers = new long[n][2];
        long totalWeight = 0;
        
        for (int i = 0; i < n; i++) {
            towers[i][0] = heights[i];
            towers[i][1] = cost[i];
            totalWeight += cost[i];
        }
        
        Arrays.sort(towers, (a, b) -> Long.compare(a[0], b[0]));
        
        long cumulativeWeight = 0;
        long medianHeight = 0;
        
        for (int i = 0; i < n; i++) {
            cumulativeWeight += towers[i][1];
            if (cumulativeWeight * 2 >= totalWeight) {
                medianHeight = towers[i][0];
                break;
            }
        }
        
        long minCost = 0;
        for (int i = 0; i < n; i++) {
            minCost += Math.abs(towers[i][0] - medianHeight) * towers[i][1];
        }
        
        return (int) minCost;
    }
}
