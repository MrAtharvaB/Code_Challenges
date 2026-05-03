import java.util.*;

class Solution {
    ArrayList<Integer> sortBySetBitCount(int[] arr) {
        int n = arr.length;

        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(new int[]{arr[i], i});
        }

        Collections.sort(list, (a, b) -> {
            int countA = Integer.bitCount(a[0]);
            int countB = Integer.bitCount(b[0]);

            if (countA != countB) {
                return countB - countA;
            } else {
                return a[1] - b[1];
            }
        });

        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            result.add(list.get(i)[0]);
        }

        return result;
    }
}
