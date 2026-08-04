import java.util.Arrays;

class Solution {
    public static int countPairs(int arr[], int k) {
        Arrays.sort(arr);

        int n = arr.length;
        int count = 0;
        int j = 0;

        for (int i = 0; i < n; i++) {
            while (j < n && arr[j] - arr[i] < k) {
                j++;
            }
            count += (j - i - 1);
        }

        return count;
    }
}
