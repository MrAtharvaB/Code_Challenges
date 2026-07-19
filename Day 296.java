class Solution {
    public ArrayList<Boolean> processQueries(int[] arr, int[][] queries) {
        int n = arr.length;

        int[] upEnd = new int[n];
        int[] downEnd = new int[n];

        upEnd[n - 1] = n - 1;
        downEnd[n - 1] = n - 1;

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] <= arr[i + 1])
                upEnd[i] = upEnd[i + 1];
            else
                upEnd[i] = i;
        }

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= arr[i + 1])
                downEnd[i] = downEnd[i + 1];
            else
                downEnd[i] = i;
        }

        ArrayList<Boolean> ans = new ArrayList<>();

        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];

            int peak = upEnd[l];

            if (peak >= r || downEnd[peak] >= r)
                ans.add(true);
            else
                ans.add(false);
        }

        return ans;
    }
}
