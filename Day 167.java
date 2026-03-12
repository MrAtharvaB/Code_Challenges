class Solution {
    public int kBitFlips(int[] arr, int k) {
        int n = arr.length;
        int flip = 0;
        int res = 0;
        int[] isFlipped = new int[n];

        for (int i = 0; i < n; i++) {

            if (i >= k) {
                flip ^= isFlipped[i - k];
            }

            if ((arr[i] ^ flip) == 0) {
                if (i + k > n) return -1;

                res++;
                flip ^= 1;
                isFlipped[i] = 1;
            }
        }

        return res;
    }
}
