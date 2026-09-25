import java.util.*;

class Solution {
    public int maxHeight(int[] height, int[] width, int[] length) {
        int n = height.length;
        int[][] boxes = new int[3 * n][3];
        int k = 0;

        for (int i = 0; i < n; i++) {
            int a = height[i];
            int b = width[i];
            int c = length[i];

            boxes[k++] = new int[]{a, Math.max(b, c), Math.min(b, c)};
            boxes[k++] = new int[]{b, Math.max(a, c), Math.min(a, c)};
            boxes[k++] = new int[]{c, Math.max(a, b), Math.min(a, b)};
        }

        Arrays.sort(boxes, (x, y) -> {
            long areaX = (long) x[1] * x[2];
            long areaY = (long) y[1] * y[2];
            return Long.compare(areaY, areaX);
        });

        int m = boxes.length;
        int[] dp = new int[m];
        int ans = 0;

        for (int i = 0; i < m; i++) {
            dp[i] = boxes[i][0];

            for (int j = 0; j < i; j++) {
                if (boxes[j][1] > boxes[i][1] &&
                    boxes[j][2] > boxes[i][2]) {
                    dp[i] = Math.max(dp[i], dp[j] + boxes[i][0]);
                }
            }

            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
}
