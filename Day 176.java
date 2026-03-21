import java.util.*;

class Solution {
    public ArrayList<Integer> countBSTs(int[] arr) {
        int n = arr.length;
        
        int[] catalan = new int[n + 1];
        catalan[0] = 1;
        catalan[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            catalan[i] = 0;
            for (int j = 0; j < i; j++) {
                catalan[i] += catalan[j] * catalan[i - j - 1];
            }
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            int root = arr[i];
            int leftCount = 0;
            int rightCount = 0;
            
            for (int j = 0; j < n; j++) {
                if (arr[j] < root) leftCount++;
                else if (arr[j] > root) rightCount++;
            }
            
            result.add(catalan[leftCount] * catalan[rightCount]);
        }
        
        return result;
    }
}
