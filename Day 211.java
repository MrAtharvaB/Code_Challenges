import java.util.*;

class Solution {
    public ArrayList<Integer> reducePairs(int[] arr) {
        Stack<Integer> st = new Stack<>();
        
        for (int num : arr) {
            int curr = num;
            
            while (!st.isEmpty() && 
                  ((st.peek() > 0 && curr < 0) || (st.peek() < 0 && curr > 0))) {
                
                int top = st.peek();
                
                if (Math.abs(top) == Math.abs(curr)) {
                    st.pop();
                    curr = 0;
                    break;
                }
                
                if (Math.abs(top) > Math.abs(curr)) {
                    curr = top;
                    st.pop();
                } else {
                    st.pop();
                }
            }
            
            if (curr != 0) {
                st.push(curr);
            }
        }
        
        return new ArrayList<>(st);
    }
}
