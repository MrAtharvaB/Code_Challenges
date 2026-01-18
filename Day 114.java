import java.util.*;

class Solution {
    public ArrayList<Integer> nextFreqGreater(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>(Collections.nCopies(n, 0));
        
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int x : arr) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }
        
        Stack<Integer> stack = new Stack<>();
        
        for (int i = n - 1; i >= 0; i--) {
            int curr = arr[i];
            
            while (!stack.isEmpty() && freq.get(stack.peek()) <= freq.get(curr)) {
                stack.pop();
            }
            
            if (stack.isEmpty()) {
                result.set(i, -1);
            } else {
                result.set(i, stack.peek());
            }
            
            stack.push(curr);
        }
        
        return result;
    }
}
