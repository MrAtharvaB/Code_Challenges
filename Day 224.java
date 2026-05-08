class Solution {
    
    private boolean isValid(String str) {
        int count = 0;
        
        for (char ch : str.toCharArray()) {
            if (ch == '(') {
                count++;
            } else if (ch == ')') {
                count--;
                
                if (count < 0)
                    return false;
            }
        }
        
        return count == 0;
    }
    
    public List<String> validParenthesis(String s) {
        
        List<String> ans = new ArrayList<>();
        
        Queue<String> q = new LinkedList<>();
        
        Set<String> visited = new HashSet<>();
        
        q.offer(s);
        visited.add(s);
        
        boolean found = false;
        
        while (!q.isEmpty()) {
            
            String curr = q.poll();
            
            if (isValid(curr)) {
                ans.add(curr);
                found = true;
            }
            
            if (found)
                continue;
            
            for (int i = 0; i < curr.length(); i++) {
                
                char ch = curr.charAt(i);
                
                if (ch != '(' && ch != ')')
                    continue;
                
                String next = curr.substring(0, i) + curr.substring(i + 1);
                
                if (!visited.contains(next)) {
                    visited.add(next);
                    q.offer(next);
                }
            }
        }
        
        Collections.sort(ans);
        
        return ans;
    }
}
