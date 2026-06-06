class Solution {
    public int numOfWays(int n, int m) {
        long cells = 1L * n * m;

        long total = cells * (cells - 1);

        long attacking = 4L * (
                Math.max(0, n - 1) * Math.max(0, m - 2)
              + Math.max(0, n - 2) * Math.max(0, m - 1)
        );

        return (int)(total - attacking);
    }
}
