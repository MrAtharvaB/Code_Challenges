class Solution {
    public int longestKSubstr(String s, int k) {
        int n = s.length();
        int[] freq = new int[26];
        
        int left = 0;
        int distinct = 0;
        int maxLen = -1;

        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);
            
            if (freq[c - 'a'] == 0) {
                distinct++;
            }
            freq[c - 'a']++;

            while (distinct > k) {
                char leftChar = s.charAt(left);
                freq[leftChar - 'a']--;
                
                if (freq[leftChar - 'a'] == 0) {
                    distinct--;
                }
                left++;
            }

            if (distinct == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }

        return maxLen;
    }
}
