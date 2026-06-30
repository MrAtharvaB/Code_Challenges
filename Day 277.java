import java.util.*;

class Solution {
    public int minInsAndDel(int[] a, int[] b) {
        int n = a.length, m = b.length;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            map.put(b[i], i);
        }

        ArrayList<Integer> seq = new ArrayList<>();
        for (int x : a) {
            if (map.containsKey(x)) {
                seq.add(map.get(x));
            }
        }

        ArrayList<Integer> lis = new ArrayList<>();
        for (int x : seq) {
            int idx = Collections.binarySearch(lis, x);
            if (idx < 0) idx = -(idx + 1);

            if (idx == lis.size())
                lis.add(x);
            else
                lis.set(idx, x);
        }

        int lcs = lis.size();
        return (n - lcs) + (m - lcs);
    }
}
