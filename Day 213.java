class Solution {
    public int smallestSubstring(String s) {
        int n = s.length();
        int[] count = new int[3];
        
        int left = 0;
        int distinct = 0;
        int minLen = Integer.MAX_VALUE;
        
        for (int right = 0; right < n; right++) {
            int idx = s.charAt(right) - '0';
            
            if (count[idx] == 0) {
                distinct++;
            }
            count[idx]++;
            
            while (distinct == 3) {
                minLen = Math.min(minLen, right - left + 1);
                
                int leftIdx = s.charAt(left) - '0';
                count[leftIdx]--;
                
                if (count[leftIdx] == 0) {
                    distinct--;
                }
                left++;
            }
        }
        
        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }
}
