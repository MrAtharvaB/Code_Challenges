class Solution {
    public int findPosition(int n) {
        if (n == 0) return -1;
        if ((n & (n - 1)) != 0) return -1;
        
        int position = 1;
        while (n > 1) {
            n = n >> 1;
            position++;
        }
        
        return position;
    }
}
