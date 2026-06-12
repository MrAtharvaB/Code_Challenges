import java.util.*;

class Solution {
    public boolean kSubstr(String s, int k) {
        int n = s.length();

        if (n % k != 0) return false;

        int blocks = n / k;
        HashMap<String, Integer> map = new HashMap<>();
        int maxFreq = 0;

        for (int i = 0; i < n; i += k) {
            String part = s.substring(i, i + k);
            int freq = map.getOrDefault(part, 0) + 1;
            map.put(part, freq);
            maxFreq = Math.max(maxFreq, freq);
        }

        return maxFreq >= blocks - 1;
    }
}
