import java.util.*;

class Solution {
    public ArrayList<ArrayList<Integer>> levelSort(int[] arr) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int n = arr.length;
        int i = 0;

        while (i < n) {
            int levelSize = Math.min(1 << ans.size(), n - i);
            ArrayList<Integer> level = new ArrayList<>();

            for (int j = 0; j < levelSize; j++) {
                level.add(arr[i++]);
            }

            Collections.sort(level);
            ans.add(level);
        }

        return ans;
    }
}
