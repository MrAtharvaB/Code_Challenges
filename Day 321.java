class Solution {
    public boolean isPossible(int[] arr, int s, int x) {
        if (x == 0) return true;

        ArrayList<Long> seq = new ArrayList<>();
        long sum = s;

        if (s <= x) seq.add((long) s);

        for (int a : arr) {
            long next = sum + a;

            if (next > x) break;

            seq.add(next);
            sum += next;
        }

        int n = seq.size();
        int mid = n / 2;

        HashSet<Long> left = new HashSet<>();
        generate(seq, 0, mid, 0, x, left);

        return checkRight(seq, mid, n, 0, x, left);
    }

    private void generate(ArrayList<Long> seq, int l, int r, long sum,
                          long x, HashSet<Long> set) {
        if (sum > x) return;

        if (l == r) {
            set.add(sum);
            return;
        }

        generate(seq, l + 1, r, sum, x, set);
        generate(seq, l + 1, r, sum + seq.get(l), x, set);
    }

    private boolean checkRight(ArrayList<Long> seq, int l, int r, long sum,
                               long x, HashSet<Long> left) {
        if (sum > x) return false;

        if (l == r) {
            return left.contains(x - sum);
        }

        if (checkRight(seq, l + 1, r, sum, x, left))
            return true;

        return checkRight(seq, l + 1, r, sum + seq.get(l), x, left);
    }
}
