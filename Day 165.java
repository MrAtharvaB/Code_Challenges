import java.util.*;

class Solution {
    public int countSubarrays(int[] arr) {
        int n = arr.length;
        long ans = 0;
        Stack<Integer> stack = new Stack<>();
        
        for (int i = n - 1; i >= 0; i--) {
            
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            
            int nextSmaller = stack.isEmpty() ? n : stack.peek();
            
            ans += nextSmaller - i;
            
            stack.push(i);
        }
        
        return (int) ans;
    }
}
