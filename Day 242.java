class Solution {
    int minToggle(int[] arr) {
        int n = arr.length;

        int zerosRight = 0;
        for (int x : arr) {
            if (x == 0) zerosRight++;
        }

        int onesLeft = 0;
        int ans = zerosRight;

        for (int x : arr) {
            if (x == 0)
                zerosRight--;
            else
                onesLeft++;

            ans = Math.min(ans, onesLeft + zerosRight);
        }

        return ans;
    }
}
