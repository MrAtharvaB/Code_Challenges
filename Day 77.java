import java.util.*;

class Solution {
    public ArrayList<Integer> constructArr(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        int m = arr.length;
        if (m == 0) return ans;

        double disc = 1 + 8.0 * m;
        double root = Math.sqrt(disc);
        int n = (int) ((1 + root) / 2.0);
        if (n * (n - 1) / 2 != m) return ans;

        if (n == 2) {
            int s = arr[0];
            if (s == 0) { ans.add(0); ans.add(0); }
            else { ans.add(s - 1); ans.add(1); }
            return ans;
        }

        long s0 = arr[0], s1 = arr[1], sPair12 = arr[n - 1];
        long numer = s0 + s1 - sPair12;
        if (numer % 2 != 0) return ans;
        long a0l = numer / 2;
        int a0 = (int) a0l;

        int[] res = new int[n];
        res[0] = a0;
        res[1] = (int)(s0 - a0);
        res[2] = (int)(s1 - a0);

        for (int i = 3; i < n; ++i) {
            long val = (long)arr[i - 1] - a0;
            res[i] = (int) val;
        }

        int pos = 0;
        for (int i = 0; i < n - 1; ++i) {
            for (int j = i + 1; j < n; ++j) {
                long sum = (long)res[i] + res[j];
                if (sum != arr[pos]) return new ArrayList<>();
                pos++;
            }
        }

        for (int x : res) ans.add(x);
        return ans;
    }
}
