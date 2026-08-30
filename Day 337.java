class Solution {
    public ArrayList<Integer> getMarks(int[] l, int[] r, int[] rank) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = l.length;

        long[] prefix = new long[n];
        prefix[0] = (long) r[0] - l[0] + 1;

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + (long) r[i] - l[i] + 1;
        }

        for (int k : rank) {
            int low = 0, high = n - 1;

            while (low < high) {
                int mid = low + (high - low) / 2;

                if (prefix[mid] >= k)
                    high = mid;
                else
                    low = mid + 1;
            }

            long before = low == 0 ? 0 : prefix[low - 1];
            int mark = (int)(l[low] + (k - before) - 1);

            ans.add(mark);
        }

        return ans;
    }
}
