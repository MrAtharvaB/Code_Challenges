class Solution {
    public int getCount(int n) {
        int count = 0;

        for (long k = 2; k * (k + 1) / 2 <= n; k++) {
            long rem = n - k * (k - 1) / 2;
            if (rem > 0 && rem % k == 0) {
                count++;
            }
        }

        return count;
    }
}
