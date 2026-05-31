class Solution {
    public boolean isSumOfConsecutive(int n) {
        return (n & (n - 1)) != 0;
    }
}
