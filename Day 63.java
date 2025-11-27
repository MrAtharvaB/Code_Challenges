class Solution {
    int subsetXORSum(int arr[]) {
        int n = arr.length;
        int orAll = 0;
        for (int x : arr) {
            orAll |= x;
        }
        int multiplier = 1 << (n - 1);
        
        return orAll * multiplier;
    }
}
