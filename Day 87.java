import java.util.*;

class Solution {
    public ArrayList<Integer> countXInRange(int[] arr, int[][] queries) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];
            int x = q[2];

            int left = lowerBound(arr, x, l, r);
            int right = upperBound(arr, x, l, r);

            result.add(Math.max(0, right - left));
        }
        return result;
    }

    private int lowerBound(int[] arr, int x, int l, int r) {
        int low = l, high = r + 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] < x)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }

    private int upperBound(int[] arr, int x, int l, int r) {
        int low = l, high = r + 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= x)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }
}
