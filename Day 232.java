class Solution {
    public int findSmallest(int[] arr) {
        Arrays.sort(arr);

        long res = 1;

        for (int num : arr) {
            if (num > res) {
                break;
            }

            res += num;
        }

        return (int) res;
    }
}
