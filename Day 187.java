class Solution {
    int countStrings(int n) {
        if (n == 1) return 2;
        
        int a = 2; 
        int b = 3; 
        
        for (int i = 3; i <= n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        
        return b;
    }
}
