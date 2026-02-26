class Solution {
    public boolean areIsomorphic(String s1, String s2) {
        
        if (s1.length() != s2.length()) {
            return false;
        }
        
        int[] map = new int[26];
        boolean[] used = new boolean[26];
        
        for (int i = 0; i < 26; i++) {
            map[i] = -1;
        }
        
        for (int i = 0; i < s1.length(); i++) {
            int c1 = s1.charAt(i) - 'a';
            int c2 = s2.charAt(i) - 'a';
            
            if (map[c1] == -1) {
                if (used[c2]) {
                    return false;
                }
                map[c1] = c2;
                used[c2] = true;
            } else {
                if (map[c1] != c2) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
