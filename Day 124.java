import java.util.*;

class Solution {
    public int countSubset(int[] arr, int k) {
        int n = arr.length;
        int mid = n / 2;

        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, n);

        Map<Long, Integer> leftMap = new HashMap<>();

        int lSize = left.length;
        int lMasks = 1 << lSize;
        for (int mask = 0; mask < lMasks; mask++) {
            long sum = 0;
            for (int i = 0; i < lSize; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum += left[i];
                }
            }
            leftMap.put(sum, leftMap.getOrDefault(sum, 0) + 1);
        }

        int rSize = right.length;
        int rMasks = 1 << rSize;
        long target = k;
        long ans = 0;

        for (int mask = 0; mask < rMasks; mask++) {
            long sum = 0;
            for (int i = 0; i < rSize; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum += right[i];
                }
            }
            long need = target - sum;
            ans += leftMap.getOrDefault(need, 0);
        }

        return (int) ans;
    }
}
