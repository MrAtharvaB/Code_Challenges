class Solution {
    public ArrayList<Integer> optimalArray(int[] arr) {
        int n = arr.length;
        long[] prefix = new long[n];

        prefix[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int mid = i / 2;

            long leftCost = (long) arr[mid] * (mid + 1) - prefix[mid];
            long rightCost = (prefix[i] - prefix[mid]) - (long) arr[mid] * (i - mid);

            long cost = leftCost + rightCost;
            ans.add((int) cost);
        }

        return ans;
    }
}
