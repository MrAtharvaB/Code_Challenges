class Solution {
    public int countKdivPairs(int[] arr, int k) {
        int[] freq = new int[k];
        int count = 0;

        for (int num : arr) {
            int rem = num % k;
            int complement = (k - rem) % k;

            count += freq[complement];
            freq[rem]++;
        }

        return count;
    }
}
