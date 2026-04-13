class Solution {
    static int[] nextPalindrome(int[] num) {
        int n = num.length;

        boolean all9 = true;
        for (int x : num) {
            if (x != 9) {
                all9 = false;
                break;
            }
        }

        if (all9) {
            int[] res = new int[n + 1];
            res[0] = 1;
            res[n] = 1;
            return res;
        }

        int[] res = num.clone();

        int mid = n / 2;
        int i = mid - 1;
        int j = (n % 2 == 0) ? mid : mid + 1;

        boolean leftSmaller = false;

        while (i >= 0 && res[i] == res[j]) {
            i--;
            j++;
        }

        if (i < 0 || res[i] < res[j]) {
            leftSmaller = true;
        }

        while (i >= 0) {
            res[j] = res[i];
            i--;
            j++;
        }

        if (leftSmaller) {
            int carry = 1;

            i = mid - 1;

            if (n % 2 == 1) {
                res[mid] += carry;
                carry = res[mid] / 10;
                res[mid] %= 10;
                j = mid + 1;
            } else {
                j = mid;
            }

            while (i >= 0 && carry > 0) {
                res[i] += carry;
                carry = res[i] / 10;
                res[i] %= 10;
                res[j] = res[i];
                i--;
                j++;
            }
        }

        return res;
    }
}
