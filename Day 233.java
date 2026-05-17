class Solution {
    List<Integer> makeBeautiful(int[] arr) {
        List<Integer> stack = new ArrayList<>();
        
        for (int num : arr) {
            if (!stack.isEmpty()) {
                int top = stack.get(stack.size() - 1);
                
                if ((top >= 0 && num < 0) || (top < 0 && num >= 0)) {
                    stack.remove(stack.size() - 1);
                    continue;
                }
            }
            
            stack.add(num);
        }
        
        return stack;
    }
}
