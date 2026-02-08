class Solution {
    int maxProduct(int[] arr) {
        int maxEndingHere = 1;
        int minEndingHere = 1;
        int result = Integer.MIN_VALUE;

        for (int x : arr) {
            if (x == 0) {
                result = Math.max(result, 0);
                maxEndingHere = 1;
                minEndingHere = 1;
                continue;
            }

            int temp = maxEndingHere * x;
            maxEndingHere = Math.max(x, Math.max(temp, minEndingHere * x));
            minEndingHere = Math.min(x, Math.min(temp, minEndingHere * x));

            result = Math.max(result, maxEndingHere);
        }

        return result;
    }
}
