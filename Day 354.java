import java.util.Arrays;

class Solution {
    public int dominantPairs(int[] arr) {
        int n = arr.length;
        int half = n / 2;

        int[] left = new int[half];
        int[] right = new int[half];

        for (int i = 0; i < half; i++) {
            left[i] = arr[i];
            right[i] = arr[half + i];
        }

        Arrays.sort(left);
        Arrays.sort(right);

        int j = 0;
        int count = 0;

        for (int i = 0; i < half; i++) {
            while (j < half && (long) left[i] >= 5L * right[j]) {
                j++;
            }

            count += j;
        }

        return count;
    }
}
