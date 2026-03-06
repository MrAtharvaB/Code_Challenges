class Solution {
    public static String minWindow(String s, String p) {
        if (p.length() > s.length()) return "";
        
        int[] freq = new int[26];
        
        for (char c : p.toCharArray()) {
            freq[c - 'a']++;
        }
        
        int left = 0, right = 0;
        int count = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        
        while (right < s.length()) {
            char r = s.charAt(right);
            
            if (freq[r - 'a'] > 0) {
                count++;
            }
            
            freq[r - 'a']--;
            right++;
            
            while (count == p.length()) {
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }
                
                char l = s.charAt(left);
                freq[l - 'a']++;
                
                if (freq[l - 'a'] > 0) {
                    count--;
                }
                
                left++;
            }
        }
        
        if (minLen == Integer.MAX_VALUE) return "";
        return s.substring(start, start + minLen);
    }
}
