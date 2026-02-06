import java.util.*;

class Solution {
    int[] smallestDiff(int a[], int b[], int c[]) {

        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);

        int i = 0, j = 0, k = 0;

        int bestDiff = Integer.MAX_VALUE;
        int bestSum = Integer.MAX_VALUE;

        int ra = 0, rb = 0, rc = 0;

        while (i < a.length && j < b.length && k < c.length) {
            int x = a[i];
            int y = b[j];
            int z = c[k];

            int mx = Math.max(x, Math.max(y, z));
            int mn = Math.min(x, Math.min(y, z));

            int diff = mx - mn;
            int sum = x + y + z;

            if (diff < bestDiff || (diff == bestDiff && sum < bestSum)) {
                bestDiff = diff;
                bestSum = sum;
                ra = x;
                rb = y;
                rc = z;
            }

            if (mn == x) {
                i++;
            } else if (mn == y) {
                j++;
            } else {
                k++;
            }
        }

        int[] res = new int[]{ra, rb, rc};
        Arrays.sort(res);
        return new int[]{res[2], res[1], res[0]};
    }
}
