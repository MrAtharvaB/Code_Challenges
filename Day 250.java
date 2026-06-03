import java.util.*;

class Solution {

    public ArrayList<Integer> freqInRange(int[] arr, int[][] queries) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];
            int x = q[2];

            if (!map.containsKey(x)) {
                ans.add(0);
                continue;
            }

            ArrayList<Integer> pos = map.get(x);

            int left = lowerBound(pos, l);
            int right = upperBound(pos, r);

            ans.add(right - left);
        }

        return ans;
    }

    private int lowerBound(ArrayList<Integer> list, int target) {
        int low = 0, high = list.size();

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (list.get(mid) >= target)
                high = mid;
            else
                low = mid + 1;
        }

        return low;
    }

    private int upperBound(ArrayList<Integer> list, int target) {
        int low = 0, high = list.size();

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (list.get(mid) > target)
                high = mid;
            else
                low = mid + 1;
        }

        return low;
    }
}
