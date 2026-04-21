class Solution {

    private int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }

    private int pour(int fromJug, int toJug, int d) {
        int from = fromJug;
        int to = 0;
        int step = 1;

        while (from != d && to != d) {

            int temp = Math.min(from, toJug - to);
            to += temp;
            from -= temp;
            step++;

            if (from == d || to == d)
                break;

            if (from == 0) {
                from = fromJug;
                step++;
            }

            if (to == toJug) {
                to = 0;
                step++;
            }
        }
        return step;
    }

    public int minSteps(int m, int n, int d) {

        if (d > Math.max(m, n))
            return -1;

        if (d % gcd(m, n) != 0)
            return -1;

        return Math.min(pour(m, n, d), pour(n, m, d));
    }
}
