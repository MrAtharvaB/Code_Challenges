class Solution {
    public int minimumCost(int x, int s, int m, int l, int cs, int cm, int cl) {
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i * s <= x + l; i++) {
            for (int j = 0; j * m <= x + l; j++) {
                int area = i * s + j * m;
                
                if (area >= x) {
                    ans = Math.min(ans, i * cs + j * cm);
                } else {
                    int k = (x - area + l - 1) / l;
                    ans = Math.min(ans, i * cs + j * cm + k * cl);
                }
            }
        }

        return ans;
    }
}
