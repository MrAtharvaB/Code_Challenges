import java.util.*;

class Solution {
    public ArrayList<Integer> constructList(int[][] queries) {
        ArrayList<Integer> ans = new ArrayList<>();
        int xr = 0;

        for (int i = queries.length - 1; i >= 0; i--) {
            int type = queries[i][0];
            int x = queries[i][1];

            if (type == 1) {
                xr ^= x;
            } else {
                ans.add(x ^ xr);
            }
        }

        ans.add(xr);
        Collections.sort(ans);

        return ans;
    }
}
